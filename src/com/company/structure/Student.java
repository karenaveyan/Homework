package com.company.structure;

import com.company.exceptions.AverageCalculationException;

import java.util.Scanner;

public class Student {
    private String name;
    private Subject[] subjects;
    private double[] grades;

    public Student(String name) {
        this.name = name;
        this.subjects = subjects;
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

    public void setSubjects() throws AverageCalculationException {
        System.out.print("Enter the number of subjects for " + name + " student: ");
        Scanner num = new Scanner(System.in);
        subjects = new Subject[num.nextInt()];
        for (int i = 0; i < subjects.length; i++) {
            System.out.print("Enter the name of the subject " + (i + 1) + ": ");
            Scanner name = new Scanner(System.in);
            subjects[i] = new Subject(name.nextLine());
        }
        if (subjects.length == 0) {
            throw new AverageCalculationException("No subjects");
        }
        System.out.println();
    }

    public double[] getGrades() {
        return grades;
    }

    public void setGrades() throws AverageCalculationException {
        grades = new double[subjects.length];
        for (int i = 0; i < subjects.length; i++) {
            System.out.print("Enter the grade of " + subjects[i].name + " for " + name + ": ");
            Scanner grade = new Scanner(System.in);
            grades[i] = grade.nextDouble();
            if (grades[i] < 0 || grades[i] > 10) {
                throw new AverageCalculationException("Invalid grade");
            }
        }
        System.out.println();
    }
}