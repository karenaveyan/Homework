package com.company.main;

import com.company.exceptions.AverageCalculationException;
import com.company.services.ServiceManager;
import com.company.strategy.*;
import com.company.structure.University;

public class Main {

    public static void main(String[] args) {
        University university;
        try {
            university = ServiceManager.create();
        } catch (AverageCalculationException e) {
            System.out.println(e.getMessage());
            return;
        }

        Params params = new Params(university);

        // You can also set values manually with default setters
        params.setRandomStudent();
        AverageCalculationByStudent s1 = new AverageCalculationByStudent();
        double d1 = ServiceManager.AverageCalculationService(s1, params);
        if (ServiceManager.isValidGrade(d1)) {
            System.out.print("The GPA of all subjects for " + params.getStudent().getName() + ": ");
            System.out.println(d1);
        }

        params.setRandomSubjectAndGroup();
        AverageCalculationBySubjectAndGroup s2 = new AverageCalculationBySubjectAndGroup();
        double d2 = ServiceManager.AverageCalculationService(s2, params);
        if (ServiceManager.isValidGrade(d2)) {
            System.out.print("The GPA of " + params.getSubject().getName() + " in " + params.getGroup().getName() + ": ");
            System.out.println(d2);
        }

        params.setRandomSubjectAndFaculty();
        AverageCalculationBySubjectAndFaculty s3 = new AverageCalculationBySubjectAndFaculty();
        double d3 = ServiceManager.AverageCalculationService(s3, params);
        if (ServiceManager.isValidGrade(d3)) {
            System.out.print("The GPA of " + params.getSubject().getName() + " in " + params.getFaculty().getName() + ": ");
            System.out.println(d3);
        }

        params.setRandomSubject();
        AverageCalculationBySubject s4 = new AverageCalculationBySubject();
        double d4 = ServiceManager.AverageCalculationService(s4, params);
        if (ServiceManager.isValidGrade(d4)) {
            System.out.print("The GPA of " + params.getSubject().getName() + " in " + params.getUniversity().getName() + ": ");
            System.out.println(d4);
        }
    }
}