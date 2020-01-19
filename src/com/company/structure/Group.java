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

    public void setStudents(String[] names) {
        students = new Student[names.length];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student(names[i]);
        }
        if (students.length == 0) {
            throw new UniversityCreationException("No Students");
        }
        System.out.println();
    }
}