package com.company.services;

import com.company.exceptions.AverageCalculationException;
import com.company.strategy.AverageCalculationStrategy;
import com.company.strategy.Params;
import com.company.structure.*;

import java.util.Scanner;

public class ServiceManager {
    private static double INVALID_GRADE = -1;

    public static boolean isValidGrade(double grade) {
        return grade != INVALID_GRADE;
    }

    public static University create() throws AverageCalculationException {
        System.out.print("Enter the name of a university: ");
        Scanner uName = new Scanner(System.in);
        University university = new University(uName.nextLine());
        System.out.println();

        {
            System.out.print("Enter the number of faculties for " + university.getName() + ": ");
            Scanner num = new Scanner(System.in);
            String[] names = new String[num.nextInt()];
            for (int i = 0; i < names.length; i++) {
                System.out.print("Enter the name of the faculty " + (i + 1) + ": ");
                Scanner name = new Scanner(System.in);
                names[i] = name.nextLine();
            }
            university.setFaculties(names);
        }
        for (int i = 0; i < university.getNumberOfFaculties(); i++) {
            Faculty currentFaculty = university.getFaculty(i);
            System.out.print("Enter the number of groups for " + currentFaculty.getName() + " faculty: ");
            Scanner num = new Scanner(System.in);
            String[] names = new String[num.nextInt()];
            for (int j = 0; j < names.length; j++) {
                System.out.print("Enter the name of the group " + (j + 1) + ": ");
                Scanner name = new Scanner(System.in);
                names[j] = name.nextLine();
            }
            currentFaculty.setGroups(names);
        }
        for (int i = 0; i < university.getNumberOfFaculties(); i++) {
            for (int j = 0; j < university.getFaculty(i).getNumberOfGroups(); j++) {
                Group currentGroup = university.getFaculty(i).getGroup(j);
                System.out.print("Enter the number of students for " + currentGroup.getName() + " group: ");
                Scanner num = new Scanner(System.in);
                String[] names = new String[num.nextInt()];
                for (int k = 0; k < names.length; k++) {
                    System.out.print("Enter the name of the student " + (k + 1) + ": ");
                    Scanner name = new Scanner(System.in);
                    names[k] = name.nextLine();
                }
                currentGroup.setStudents(names);
            }
        }
        for (int i = 0; i < university.getNumberOfFaculties(); i++) {
            for (int j = 0; j < university.getFaculty(i).getNumberOfGroups(); j++) {
                for (int k = 0; k < university.getFaculty(i).getGroup(j).getNumberOfStudents(); k++) {
                    Student currentStudent = university.getFaculty(i).getGroup(j).getStudent(k);
                    System.out.print("Enter the number of subjects for " + currentStudent.getName() + ": ");
                    Scanner num = new Scanner(System.in);
                    String[] names = new String[num.nextInt()];
                    for (int s = 0; s < names.length; s++) {
                        System.out.print("Enter the name of the subject " + (s + 1) + ": ");
                        Scanner name = new Scanner(System.in);
                        names[s] = name.nextLine();
                    }
                    currentStudent.setSubjects(names);
                    double[] grades = new double[names.length];
                    for (int s = 0; s < grades.length; s++) {
                        System.out.print("Enter the grade of " + names[s] + " for " + currentStudent.getName() + ": ");
                        Scanner grade = new Scanner(System.in);
                        grades[s] = grade.nextDouble();
                    }
                    currentStudent.setGrades(grades);
                }
            }
        }
        return university;
    }

    public static double AverageCalculationService(AverageCalculationStrategy strategy, Params params) {
        try {
            return strategy.calculateAverage(params);
        } catch (AverageCalculationException e) {
            System.out.println(e.getMessage());
            return INVALID_GRADE;
        }
    }
}