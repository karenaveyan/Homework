package com.epam.homework2.model;

import java.util.Calendar;

public class Student implements Comparable<Student> {
    private String firstName;
    private String lastName;
    private int year;

    public Student(String firstName, String lastName, int year) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.year = year;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public int getYear() {
        return year;
    }

    public int getAge() {
        return Calendar.getInstance().get(Calendar.YEAR) - year;
    }

    @Override
    public int compareTo(Student s) {
        return lastName.compareTo(s.getLastName());
    }

    @Override
    public String toString() {
        return getFullName() + ": " + getAge();
    }
}
