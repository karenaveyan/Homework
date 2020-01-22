package com.epam.homework2.main;

import com.epam.homework2.comparator.*;
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

        LinkedList<Student> students1 = new LinkedList<>(students);
        System.out.println("LinkedList of students.");
        for (Student s : students1) {
            System.out.println(s);
        }
    }
}
