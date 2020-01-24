package com.epam.homework2.comparator;

import com.epam.homework2.model.Student;

import java.util.Comparator;

public class MyComparator implements Comparator<Object> {
    @Override
    public int compare(Object o1, Object o2) {
        Student s1 = (Student) o1;
        Student s2 = (Student) o2;
        int firstNameCompare = s1.getFirstName().compareTo(s2.getFirstName());
        int ageCompare = Integer.compare(s2.getAge(), s1.getAge());
        if (firstNameCompare == 0) {
            return ageCompare;
        }
        return firstNameCompare;
    }
}