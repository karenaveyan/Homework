package com.company.main;

import com.company.exceptions.LogicException;
import com.company.services.ServiceManager;
import com.company.strategy.*;
import com.company.structure.University;

public class Main {

    public static void main(String[] args) {
        University university;
        try {
            university = ServiceManager.create();
        } catch (LogicException e) {
            System.out.println(e.getMessage());
            return;
        }

        Params p = new Params(university);

        // You can also set values manually with default setters
        p.setRandomStudent();
        GettingByStudent s1 = new GettingByStudent();
        double d1 = ServiceManager.gradeGettingService(s1, p);
        if (d1 != -1) {
            System.out.print("The GPA of all subjects for " + p.getStudent().getName() + ": ");
            System.out.println(d1);
        }

        p.setRandomSubjectAndGroup();
        GettingBySubjectAndGroup s2 = new GettingBySubjectAndGroup();
        double d2 = ServiceManager.gradeGettingService(s2, p);
        if (d2 != -1) {
            System.out.print("The GPA of " + p.getSubject().getName() + " in " + p.getGroup().getName() + ": ");
            System.out.println(d2);
        }

        p.setRandomSubjectAndFaculty();
        GettingBySubjectAndFaculty s3 = new GettingBySubjectAndFaculty();
        double d3 = ServiceManager.gradeGettingService(s3, p);
        if (d3 != -1) {
            System.out.print("The GPA of " + p.getSubject().getName() + " in " + p.getFaculty().getName() + ": ");
            System.out.println(d3);
        }

        p.setRandomSubject();
        GettingBySubject s4 = new GettingBySubject();
        double d4 = ServiceManager.gradeGettingService(s4, p);
        if (d4 != -1) {
            System.out.print("The GPA of " + p.getSubject().getName() + " in " + p.getUniversity().getName() + ": ");
            System.out.println(d4);
        }
    }
}