package com.company.services;

import com.company.exceptions.AverageCalculationException;
import com.company.strategy.AverageCalculationStrategy;
import com.company.strategy.Params;
import com.company.structure.University;

import java.util.Scanner;

public class ServiceManager {
    public static University create() throws AverageCalculationException {
        System.out.print("Enter the name of a university: ");
        Scanner uName = new Scanner(System.in);
        University university = new University(uName.nextLine());
        System.out.println();

        university.setFaculties();
        for (int i = 0; i < university.getNumberOfFaculties(); i++) {
            university.getFaculty(i).setGroups();
        }
        for (int i = 0; i < university.getNumberOfFaculties(); i++) {
            for (int j = 0; j < university.getFaculty(i).getNumberOfGroups(); j++) {
                university.getFaculty(i).getGroup(j).setStudents();
            }
        }
        for (int i = 0; i < university.getNumberOfFaculties(); i++) {
            for (int j = 0; j < university.getFaculty(i).getNumberOfGroups(); j++) {
                for (int k = 0; k < university.getFaculty(i).getGroup(j).getNumberOfStudents(); k++) {
                    university.getFaculty(i).getGroup(j).getStudent(k).setSubjects();
                }
            }
        }
        for (int i = 0; i < university.getNumberOfFaculties(); i++) {
            for (int j = 0; j < university.getFaculty(i).getNumberOfGroups(); j++) {
                for (int k = 0; k < university.getFaculty(i).getGroup(j).getNumberOfStudents(); k++) {
                    university.getFaculty(i).getGroup(j).getStudent(k).setGrades();
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
            return -1;
        }
    }
}