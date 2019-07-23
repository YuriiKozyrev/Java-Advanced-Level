package Lesson3.HW;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordCheck {
    public static void main(String[] args) {
        String password = null;

        System.out.println("Введите пароль, отвечающий условиям:");
        System.out.println("1. Длина от 8 до 20 символов");
        System.out.println("2. Должен содержать заглавные и строчные буквы (только латиница)");
        System.out.println("3. Должен содержать хотя бы одну цифру");
        System.out.println("4. Обязательно должен быть спец. символ\n");

        do{
            Scanner scan = new Scanner(System.in);
            if (scan.hasNextLine()) password = scan.nextLine();
            if(!passwordCheck(password)) System.out.println("Пароль '" + password + "' не отвечает условиям, попробуйте ещё раз...");
        } while(!passwordCheck(password));

        System.out.println("Верно. Пароль '" + password + "' отвечает условиям.");
    }

    private static boolean passwordCheck(String str){
        Pattern p = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*\\W).{8,20})");
        Matcher m = p.matcher(str);
        return m.matches();
    }
}
