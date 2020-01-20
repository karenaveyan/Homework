package com.company.structure;

import com.company.exceptions.UniversityCreationException;

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
        for (int iFaculty = 0; iFaculty < faculties.length; iFaculty++) {
            faculties[iFaculty] = new Faculty(names[iFaculty]);
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