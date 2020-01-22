package com.epam.homework1.service;

import com.epam.homework1.exception.AverageCalculationException;
import com.epam.homework1.strategy.*;
import com.epam.homework1.structure.*;

public class ServiceManager {

    public static University create() throws AverageCalculationException {
        String[] names;
        double[] grades;

        //Creating university
        University university = new University("Yerevan State University");

        //Initializing faculties
        names = new String[1];
        names[0] = "Applied Mathematics and Informatics";
        university.setFaculties(names);

        //Initializing groups
        Faculty currentFaculty = university.getFaculty(0);
        names = new String[2];
        names[0] = "418";
        names[1] = "439";
        currentFaculty.setGroups(names);

        //Initializing students
        Group currentGroup = university.getFaculty(0).getGroup(0);
        names = new String[2];
        names[0] = "Armen";
        names[1] = "Artak";
        currentGroup.setStudents(names);

        currentGroup = university.getFaculty(0).getGroup(1);
        names = new String[3];
        names[0] = "Armine";
        names[1] = "Gevorg";
        names[2] = "Anna";
        currentGroup.setStudents(names);

        //Initializing subjects and grades
        Student currentStudent = university.getFaculty(0).getGroup(0).getStudent(0);
        names = new String[2];
        grades = new double[2];
        names[0] = "Math";
        grades[0] = 9.5;
        names[1] = "English";
        grades[1] = 7.5;
        currentStudent.setSubjects(names);
        currentStudent.setGrades(grades);

        currentStudent = university.getFaculty(0).getGroup(0).getStudent(1);
        names = new String[1];
        grades = new double[1];
        names[0] = "Math";
        grades[0] = 8.5;
        currentStudent.setSubjects(names);
        currentStudent.setGrades(grades);

        currentStudent = university.getFaculty(0).getGroup(1).getStudent(0);
        names = new String[2];
        grades = new double[2];
        names[0] = "English";
        grades[0] = 9;
        names[1] = "Physics";
        grades[1] = 6.5;
        currentStudent.setSubjects(names);
        currentStudent.setGrades(grades);

        currentStudent = university.getFaculty(0).getGroup(1).getStudent(1);
        names = new String[1];
        grades = new double[1];
        names[0] = "Physics";
        grades[0] = 8;
        currentStudent.setSubjects(names);
        currentStudent.setGrades(grades);

        currentStudent = university.getFaculty(0).getGroup(1).getStudent(2);
        names = new String[2];
        grades = new double[2];
        names[0] = "Math";
        grades[0] = 7.5;
        names[1] = "Physics";
        grades[1] = 6.5;
        currentStudent.setSubjects(names);
        currentStudent.setGrades(grades);

        return university;
    }

    public static void printAverageGrade(AverageCalculationStrategy strategy, Params params) {
        double grade;
        try {
            grade = strategy.calculateAverage(params);
        } catch (AverageCalculationException e) {
            System.out.println(e.getMessage());
            return;
        }
        if (strategy instanceof AverageCalculationByStudent) {
            System.out.print("The GPA of all subjects for " + params.getStudent().getName() + ": ");
        } else if (strategy instanceof AverageCalculationBySubjectAndGroup) {
            System.out.print("The GPA of " + params.getSubject().getName() + " in " + params.getGroup().getName() + " group: ");
        } else if (strategy instanceof AverageCalculationBySubjectAndFaculty) {
            System.out.print("The GPA of " + params.getSubject().getName() + " in " + params.getFaculty().getName() + " faculty: ");
        } else if (strategy instanceof AverageCalculationBySubject) {
            System.out.print("The GPA of " + params.getSubject().getName() + " in " + params.getUniversity().getName() + ": ");
        }
        System.out.println(grade);
    }
}