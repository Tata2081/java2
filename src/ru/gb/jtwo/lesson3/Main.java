package ru.gb.jtwo.lesson3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    private static final String[] words = {"A", "A", "B", "C", "B", "D"};

    private static HashSet<String> getWords(String[] arr) {
        return new HashSet<>(Arrays.asList(arr));
    }

    private static HashMap<String, Integer> getCountWords(String[] arr) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i=0; i < arr.length; i++) {
            String word = arr[i];
            if (map.containsKey(word)) {
                map.put(word, map.get(word)+1);
            } else {
                map.put(word, 1);
            }
        }
        return map;
    }
    public static void main(String[] args) {
        System.out.println(getWords(words));
        System.out.println(getCountWords(words));

        Phonebook phonebook = new Phonebook();
        phonebook.add("Ivanov", "89051565665", "etr@mdfm.dmk");
        phonebook.add("Petrov", "89042365896", "23645@klkld.df");
        phonebook.add("Ivanov", "32563698133", "ndfjkdgkd@d;lgld.mdk");

        System.out.println(phonebook.getPhone("Ivanov"));
        System.out.println(phonebook.getMails("Petrov"));
    }
}