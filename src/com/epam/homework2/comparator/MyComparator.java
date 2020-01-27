package com.epam.homework2.comparator;

import com.epam.homework2.model.Student;

import java.util.Comparator;

public class MyComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        int firstNameCompare = s1.getFirstName().compareTo(s2.getFirstName());
        int ageCompare = Integer.compare(s2.getAge(), s1.getAge());
        if (firstNameCompare == 0) {
            return ageCompare;
        }
        return firstNameCompare;
    }
}