package com.epam.homework2.comparator;

import com.epam.homework2.model.Student;

import java.util.Comparator;

public class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.getYear(), s2.getYear());
    }
}