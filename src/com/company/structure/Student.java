package com.company.structure;

import com.company.exceptions.AverageCalculationException;
import com.company.exceptions.UniversityCreationException;

import java.util.Scanner;

public class Student {
    private String name;
    private Subject[] subjects;
    private double[] grades;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Subject getSubject(int i) {
        return subjects[i];
    }

    public int getNumberOfSubjects() {
        return subjects.length;
    }

    public void setSubjects(String[] names) {
        subjects = new Subject[names.length];
        for (int i = 0; i < subjects.length; i++) {
            subjects[i] = new Subject(names[i]);
        }
        if (subjects.length == 0) {
            throw new UniversityCreationException("No subjects");
        }
        System.out.println();
    }

    public double[] getGrades() {
        return grades;
    }

    public void setGrades(double[] grades) {
        this.grades = new double[grades.length];
        for (int i = 0; i < grades.length; i++) {
            this.grades[i] = grades[i];
            if (grades[i] < 0 || grades[i] > 10) {
                throw new UniversityCreationException("Invalid grade for " + subjects[i].getName());
            }
        }
        System.out.println();
    }
}