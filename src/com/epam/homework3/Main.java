package com.epam.homework3;

import com.epam.homework3.model.*;
import com.epam.homework3.service.ServiceManager;

import java.util.ArrayList;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>(6);
        ServiceManager.setStudents(students);
        students.add(null);

        for (Map.Entry<Student, Integer> s : ServiceManager.getMapOfStudents(students).entrySet()) {
            System.out.println("Key: " + s.getKey() + ", Value: " + s.getValue());
        }

        System.out.println();

        for (Map.Entry<Faculty, Integer> s : ServiceManager.getMapOfFaculties(students).entrySet()) {
            System.out.println("Key: " + s.getKey() + ", Value: " + s.getValue());
        }
    }
}