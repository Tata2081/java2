package ru.gb.jtwo.lesson3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Phonebook {
    private final HashMap<String, ArrayList<Person>> enters = new HashMap<>();

    public void add(String name, String phone, String email){
        if (enters.containsKey(name)) {
            ArrayList<Person> person = enters.get(name);
            person.add(new Person(phone, email));
        } else {
            ArrayList<Person> person = new ArrayList<>();
            person.add(new Person(phone, email));
            enters.put(name, person);
        }
    }

    public ArrayList<String> getPhone(String name){
        if (!enters.containsKey(name)) return null;
        ArrayList<Person> person = enters.get(name);
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < person.size(); i++) {
            result.add(person.get(i).phone);
        }
        return result;
    }

    public ArrayList<String> getMails(String name){
        if (!enters.containsKey(name)) return null;
        return enters.get(name).stream().map(person -> person.email).collect(Collectors.toCollection(ArrayList::new));
    }
}
