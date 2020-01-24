package com.epam.homework2.model;

public class Student implements Comparable<Student> {
    private String firstName;
    private String lastName;
    private int age;

    public Student(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
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

    public int getAge() {
        return age;
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
