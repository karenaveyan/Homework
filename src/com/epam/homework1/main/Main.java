package com.epam.homework1.main;

import com.epam.homework1.exception.AverageCalculationException;
import com.epam.homework1.service.ServiceManager;
import com.epam.homework1.strategy.*;
import com.epam.homework1.structure.University;

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
        ServiceManager.printAverageGrade(new AverageCalculationByStudent(), params);

        params.setRandomSubjectAndGroup();
        ServiceManager.printAverageGrade(new AverageCalculationBySubjectAndGroup(), params);

        params.setRandomSubjectAndFaculty();
        ServiceManager.printAverageGrade(new AverageCalculationBySubjectAndFaculty(), params);

        params.setRandomSubject();
        ServiceManager.printAverageGrade(new AverageCalculationBySubject(), params);
    }
}