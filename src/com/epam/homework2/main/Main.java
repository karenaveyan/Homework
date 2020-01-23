package com.epam.homework2.main;

import com.epam.homework2.comparator.*;
import com.epam.homework2.custom.DoubleLinkedList;
import com.epam.homework2.custom.DynamicArray;
import com.epam.homework2.custom.Node;
import com.epam.homework2.model.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<Student>();
        students.add(new Student("Zara", "Karapetyan", 1996));
        students.add(new Student("Mari", "Avagyan", 1965));
        students.add(new Student("Arman", "Madoyan", 2002));

        System.out.println("Initial list.");
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println();

        // 1.
        FirstNameComparator firstNameComparator = new FirstNameComparator();
        Collections.sort(students, firstNameComparator);
        System.out.println("Sorted by first name in ascending order.");
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println();

        AgeComparator ageComparator = new AgeComparator();
        Collections.sort(students, ageComparator);
        System.out.println("Sorted by age in descending order.");
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println();

        Collections.sort(students);
        System.out.println("Sorted by last name in ascending order.");
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println();

        // 2.
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
        Node current = students3.getHead();
        while (current != null) {
            System.out.println(current.getStudent());
            current = current.getNext();
        }
    }
}
