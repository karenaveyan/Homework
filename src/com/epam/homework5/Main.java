package com.epam.homework5;

import com.epam.homework5.custom.SortedSet;
import com.epam.homework5.model.Student;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        SortedSet<Student> set = new SortedSet<>();
        set.add(new Student("Armen", "Ghazaryan", 18));
        set.add(new Student("Karen", "Ghazaryan", 17));
        set.add(new Student("Artak", "Meliqyan", 22));
        set.add(new Student("Arthur", "Petrosyan", 22));
        set.remove(new Student("Armen", "Ghazaryan", 18));

        System.out.println("Size of set: " + set.getSize());
        Iterator<Student> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
