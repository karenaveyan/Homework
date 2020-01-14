package com.company.structure;

import com.company.exceptions.LogicException;

import java.util.Scanner;

public class Group {
    private String name;
    private Student[] students;
    private Subject[] subjects;

    Group(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Student getStudent(int i) {
        return students[i];
    }

    public Subject getSubject(int i) {
        return subjects[i];
    }

    public int getNumberOfStudents() {
        return students.length;
    }

    public int getNumberOfSubjects() {
        return subjects.length;
    }

    public void setSubjects() throws LogicException {
        System.out.print("Enter the number of subjects for " + name + " group: ");
        Scanner num = new Scanner(System.in);
        subjects = new Subject[num.nextInt()];
        for (int i = 0; i < subjects.length; i++) {
            System.out.print("Enter the name of the subject " + (i + 1) + ": ");
            Scanner name = new Scanner(System.in);
            subjects[i] = new Subject(name.nextLine());
        }
        if(subjects.length == 0) {
            throw new LogicException("No subjects");
        }
        System.out.println();
    }

    public void setStudents() throws LogicException {
        System.out.print("Enter the number of students for " + name + " group: ");
        Scanner num = new Scanner(System.in);
        students = new Student[num.nextInt()];
        for (int i = 0; i < students.length; i++) {
            System.out.print("Enter the name of the student " + (i + 1) + ": ");
            Scanner name = new Scanner(System.in);
            students[i] = new Student(name.nextLine(), subjects);
        }
        System.out.println();
        if (students.length == 0) {
            throw new LogicException("No Students");
        }
    }
}