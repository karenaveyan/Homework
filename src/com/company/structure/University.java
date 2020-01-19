package com.company.structure;

import com.company.exceptions.AverageCalculationException;
import com.company.exceptions.UniversityCreationException;

import java.util.Scanner;

public class University {
    private String name;
    private Faculty[] faculties;

    public University(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setFaculties(String[] names) {
        faculties = new Faculty[names.length];
        for (int i = 0; i < faculties.length; i++) {
            faculties[i] = new Faculty(names[i]);
        }
        if (faculties.length == 0) {
            throw new UniversityCreationException("No faculties");
        }
        System.out.println();
    }

    public Faculty getFaculty(int i) {
        return faculties[i];
    }

    public int getNumberOfFaculties() {
        return faculties.length;
    }
}