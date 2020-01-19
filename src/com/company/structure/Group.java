package com.company.structure;

import com.company.exceptions.AverageCalculationException;
import com.company.exceptions.UniversityCreationException;

import java.util.Scanner;

public class Group {
    private String name;
    private Student[] students;

    Group(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Student getStudent(int i) {
        return students[i];
    }

    public int getNumberOfStudents() {
        return students.length;
    }

    public void setStudents() {
        System.out.print("Enter the number of students for " + name + " group: ");
        Scanner num = new Scanner(System.in);
        students = new Student[num.nextInt()];
        for (int i = 0; i < students.length; i++) {
            System.out.print("Enter the name of the student " + (i + 1) + ": ");
            Scanner name = new Scanner(System.in);
            students[i] = new Student(name.nextLine());
        }
        if (students.length == 0) {
            throw new UniversityCreationException("No Students");
        }
        System.out.println();
    }
}