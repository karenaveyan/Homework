package com.company.services;

import com.company.exceptions.LogicException;
import com.company.strategy.GradeGettingStrategy;
import com.company.strategy.Params;
import com.company.structure.University;

import java.util.Scanner;

public class ServiceManager {
    public static University create() throws LogicException {
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
                university.getFaculty(i).getGroup(j).setSubjects();
            }
        }
        for (int i = 0; i < university.getNumberOfFaculties(); i++) {
            for (int j = 0; j < university.getFaculty(i).getNumberOfGroups(); j++) {
                university.getFaculty(i).getGroup(j).setStudents();
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
    public static double gradeGettingService(GradeGettingStrategy strategy, Params params) {
        try {
            return strategy.getAverageGrade(params);
        }catch (LogicException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }
}