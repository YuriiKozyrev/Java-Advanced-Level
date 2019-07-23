package Lesson3.HW;

import java.util.*;

public class PhoneBook {

    static HashMap<String, HashSet<String>> hm = new HashMap<>();

    public static void add(String login, String number){
        hm.put(login, hm.getOrDefault(login, new HashSet<>()));
        hm.get(login).add(number);
        System.out.println("Добавлен логин '" + login + "' с телефонным номером '" + number + "'");
    }

    public static void get(String login){
        System.out.println("По логину '" + login + "' найдены следующие номера: " + hm.get(login));
    }

    public static void main(String[] args) {

        add("Бендер", "111");
        add("Воробьянинов", "222");
        add("Бендер", "999");
        add("Щукин", "333");
        add("Ляпис-Трубецкой", "444");
        add("Грицацуева", "555");
        add("Бендер", "666");

        System.out.println("\n");

        get("Бендер");
        get("Ляпис-Трубецкой");

    }
}
