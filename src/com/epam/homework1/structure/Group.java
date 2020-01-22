package com.epam.homework1.structure;

import com.epam.homework1.exception.UniversityCreationException;

public class Group {
    private String name;
    private Student[] students;

    Group(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Student getStudent(int i) {
        return students[i];
    }

    public int getNumberOfStudents() {
        return students.length;
    }

    public void setStudents(String[] names) {
        students = new Student[names.length];
        for (int iStudent = 0; iStudent < students.length; iStudent++) {
            students[iStudent] = new Student(names[iStudent]);
        }
        if (students.length == 0) {
            throw new UniversityCreationException("No Students");
        }
    }
}