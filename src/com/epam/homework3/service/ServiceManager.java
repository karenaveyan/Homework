package com.epam.homework3.service;

import com.epam.homework3.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ServiceManager {
    public static void setStudents(ArrayList<Student> students) {
        students.add(new Student("Diana", "Asatryan", 22, "098111111", Faculty.MATH));
        students.add(new Student("Diana", "Asatryan", 32, "0922111111", Faculty.PHYSICS));
        students.add(new Student("Diana", "Asatryan", 21, "0938111111", Faculty.PHILOSOPHY));
        students.add(new Student("Karen", "Balayan", 12, "097777777", Faculty.MATH));
        students.add(new Student("Karen", "Balayan", 23, "098888811", Faculty.PHILOSOPHY));
        students.add(new Student("Elen", "Mirzoyan", 12, "093333333", Faculty.ENGLISH));
    }

    public static HashMap<Student, Integer> getMapOfStudents(ArrayList<Student> students) {
        HashMap<Student, Integer> hStudents = new HashMap<>();
        for (Student student : students) {
            if (!hStudents.containsKey(student)) {
                hStudents.put(student, 1);
            } else {
                hStudents.put(student, hStudents.get(student) + 1);
            }
        }
        return hStudents;
    }

    public static HashMap<Faculty, Integer> getMapOfFaculties(ArrayList<Student> students) {
        HashMap<Faculty, Integer> hFaculties = new HashMap<>();
        ArrayList<Faculty> faculties = new ArrayList<>(Arrays.asList(Faculty.values()));
        for (Faculty faculty : faculties) {
            hFaculties.put(faculty, 0);
        }
        for (Student student : students) {
            hFaculties.put(student.getFaculty(), hFaculties.get(student.getFaculty()) + 1);
        }
        return hFaculties;
    }
}
