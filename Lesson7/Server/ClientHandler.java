package Lesson7.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;

public class ClientHandler {

    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private Server server;
    private String nickName;

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getNickName(){
        return nickName;
    }


    public ClientHandler(Server server, Socket socket) {
        try {
            this.socket = socket;
            this.server = server;

            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String str = in.readUTF();
                            if (str.startsWith("/auth")) {
                                String[] tokens = str.split(" ");
                                String newNick = AuthService.getNickByLoginAndPass(tokens[1], tokens[2]);
                                setNickName(newNick);
                                if (newNick != null) {
                                    if (!server.isNickNameOnLine(newNick)){
                                        sendMsg("/authok");
                                        server.subscribe(ClientHandler.this);
                                        break;
                                    }else {
                                        sendMsg("Такой пользователь уже онлайн!");
                                    }
                                } else {
                                    sendMsg("Неверный логин/пароль!");
                                }
                            }
                        }

                        while (true) {
                            String str = in.readUTF();
                            System.out.println("Client " + str);
                            if (str.equals("/end")) {
                                out.writeUTF("/serverClosed");
                                break;
                            }

                            if (str.startsWith("/w")) {
                                String[] tokens = str.split(" ");
                                String privateDestinationNick = tokens[1];
                                String privateMsg = tokens[2];
                                server.privateMsg(ClientHandler.this, privateDestinationNick, privateMsg);
                            }else{
                                server.broadcastMsg(nickName + ": " + str);
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            correctDisconnect();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public   void correctDisconnect() throws IOException {
        in.close();
        out.close();
        socket.close();
        server.unsubscribe(ClientHandler.this);
    }
}
