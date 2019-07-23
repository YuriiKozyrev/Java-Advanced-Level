package Lesson3.HW;

import java.util.*;

public class Question1 {
    public static void main(String[] args) {
        String[] namesArray = {"Вася", "Петя", "Коля", "Дима", "Вася", "Вася", "Коля", "Миша", "Сеня", "Иван"};

        List<String> namesArrayList = new ArrayList<>(Arrays.asList(namesArray));
        System.out.println("Исходный список: " + namesArrayList);

        Set<String> uniqueNamesArrayList = new HashSet<>(namesArrayList);
        System.out.println("\nУникальный список: " + uniqueNamesArrayList);


        System.out.println("\nКоличество повторов способ 1: ");
        for (String s : uniqueNamesArrayList) {
            int count = Collections.frequency(namesArrayList, s);
            System.out.println(s + ": " + count);
        }


        System.out.println("\nКоличество повторов способ 2: ");
        Map<String, Integer> hm = new HashMap<>();
        for (String name : namesArray) {
            Integer res = hm.get(name);
            hm.put(name, res == null ? 1 : res + 1);
        }
        System.out.println(hm);
    }
}
