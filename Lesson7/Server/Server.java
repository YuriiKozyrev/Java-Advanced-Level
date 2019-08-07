package Lesson7.Server;

import Lesson7.Client.Controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Vector;

public class Server {


    private Vector<ClientHandler> clients;

    public Server() throws SQLException {
        clients = new Vector<>();
        ServerSocket server = null;
        Socket socket = null;

        try {
            AuthService.connect();
//            String test = AuthService.getNickByLoginAndPass("login2", "pass2");
//            System.out.println(test);
            server = new ServerSocket(8189);
            System.out.println("Сервер запущен!");

            while (true) {
                socket = server.accept();
                new ClientHandler(this, socket);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            AuthService.disconnect();
        }
    }

    public void broadcastMsg(String msg) {
        for (ClientHandler o: clients) {
            o.sendMsg(msg);
        }
    }

    public void privateMsg(ClientHandler source, String destinationNick, String msg){
        String clientNick;
        ClientHandler chDestination;

        if(isNickNameOnLine(destinationNick)){
            for (int i = 0; i < clients.size(); i++) {
                clientNick = clients.get(i).getNickName();
                if(clientNick.equals(destinationNick)){
                    chDestination = clients.get(i);
                    chDestination.sendMsg("Частное сообщение от " + source.getNickName() + ": " + msg);
                    source.sendMsg("Частное сообщение для " + destinationNick + ": " + msg);
                    break;
                }
            }
        }else{
            source.sendMsg("Частное сообщение для " + destinationNick + " невозможно. Пользователь не найден.");
        }
    }


    public void subscribe(ClientHandler client) {
        clients.add(client);
    }

    public void unsubscribe(ClientHandler client) {
        clients.remove(client);
    }

    public boolean isNickNameOnLine (String nickName){
        boolean status = false;
        for (ClientHandler o : clients) {
            if (nickName.equals(o.getNickName())) {
                status = true;
                break;
            }
        }
        return status;
    }


}
