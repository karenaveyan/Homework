package com.epam.homework2.main;

import com.epam.homework2.comparator.*;
import com.epam.homework2.custom.DoubleLinkedList;
import com.epam.homework2.custom.DynamicArray;
import com.epam.homework2.model.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<Student>();
        students.add(new Student("Zara", "Karapetyan", 24));
        students.add(new Student("Mari", "Avagyan", 55));
        students.add(new Student("Arman", "Madoyan", 18));

        System.out.println("Initial list.");
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println();

        // 1.
        MyComparator myComparator = new MyComparator();
        Collections.sort(students, myComparator);
        System.out.println("Sorted by first name in ascending order and by age in descending order.");
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println();

        // 2.
        Collections.sort(students);
        System.out.println("Sorted by last name in ascending order.");
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println();

        LinkedList<Student> students1 = new LinkedList<>(students);
        System.out.println("LinkedList of students.");
        for (Student s : students1) {
            System.out.println(s);
        }
        System.out.println();

        // 3.
        DynamicArray students2 = new DynamicArray();
        for (Student s : students) {
            students2.add(s);
        }

        System.out.println("DynamicArray of students.");
        for (int i = 0; i < students2.size(); i++) {
            System.out.println(students2.get(i));
        }
        System.out.println();

        // 4.
        DoubleLinkedList students3 = new DoubleLinkedList();
        for (Student s : students) {
            students3.push(s);
        }

        System.out.println("DoubleLinkedList of students.");
        Iterator<Student> iterator = students3.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
