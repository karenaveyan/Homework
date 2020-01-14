package com.company.structure;

import com.company.exceptions.LogicException;

import java.util.Scanner;

public class Student {
    String name;
    Subject[] subjects;
    private double[] grades;

    public Student(String name, Subject[] subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public double[] getGrades(){
        return grades;
    }

    public void setGrades() throws LogicException {
        grades = new double[subjects.length];
        for (int i = 0; i < subjects.length; i++) {
            System.out.print("Enter the grade of " + subjects[i].name + " for " + name + ": ");
            Scanner grade = new Scanner(System.in);
            grades[i] = grade.nextDouble();
            if (grades[i] < 0 || grades[i] > 10) {
                throw new LogicException("Invalid grade");
            }
        }
        System.out.println();
    }
}