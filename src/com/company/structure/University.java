package com.company.structure;

import com.company.exceptions.LogicException;

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

    public void setFaculties() throws LogicException {
        System.out.print("Enter the number of faculties for " + name + ": ");
        Scanner num = new Scanner(System.in);
        faculties = new Faculty[num.nextInt()];
        for (int i = 0; i < faculties.length; i++) {
            System.out.print("Enter the name of the faculty " + (i + 1) + ": ");
            Scanner name = new Scanner(System.in);
            faculties[i] = new Faculty(name.nextLine());
        }
        if(faculties.length == 0) {
            throw new LogicException("No faculties");
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