package com.company.services;

import com.company.exceptions.AverageCalculationException;
import com.company.strategy.*;
import com.company.structure.*;

public class ServiceManager {
    private static double INVALID_GRADE = -1;

    public static boolean isValidGrade(double grade) {
        return grade != INVALID_GRADE;
    }

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
        double grade = ServiceManager.getAverageGrade(strategy, params);
        if (ServiceManager.isValidGrade(grade)) {
            if (strategy instanceof AverageCalculationByStudent) {
                System.out.print("The GPA of all subjects for " + params.getStudent().getName() + ": ");
            }
            if (strategy instanceof AverageCalculationBySubjectAndGroup) {
                System.out.print("The GPA of " + params.getSubject().getName() + " in " + params.getGroup().getName() + " group: ");
            }
            if (strategy instanceof AverageCalculationBySubjectAndFaculty) {
                System.out.print("The GPA of " + params.getSubject().getName() + " in " + params.getFaculty().getName() + " faculty: ");
            }
            if (strategy instanceof AverageCalculationBySubject) {
                System.out.print("The GPA of " + params.getSubject().getName() + " in " + params.getUniversity().getName() + ": ");
            }
            System.out.println(grade);
        }
    }

    private static double getAverageGrade(AverageCalculationStrategy strategy, Params params) {
        try {
            return strategy.calculateAverage(params);
        } catch (AverageCalculationException e) {
            System.out.println(e.getMessage());
            return INVALID_GRADE;
        }
    }
}