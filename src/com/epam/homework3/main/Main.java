package com.epam.homework3.main;

import com.epam.homework3.model.*;
import com.epam.homework3.service.ServiceManager;

import java.util.ArrayList;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>(6);
        ServiceManager.setStudents(students);

        for (Map.Entry<Object, Integer> s : ServiceManager.getMap(students).entrySet()) {
            System.out.println("Key: " + s.getKey() + ", Value: " + s.getValue());
        }

        System.out.println();

        ArrayList<Faculty> faculties = new ArrayList<>(students.size());
        for (Student s : students) {
            faculties.add(s.getFaculty());
        }
        for (Map.Entry<Object, Integer> s : ServiceManager.getMap(faculties).entrySet()) {
            System.out.println("Key: " + s.getKey() + ", Value: " + s.getValue());
        }
    }
}