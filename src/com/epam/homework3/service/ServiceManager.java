package com.epam.homework3.service;

import com.epam.homework3.model.*;

import java.util.ArrayList;
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

    public static HashMap<Object, Integer> getMap(ArrayList objects) {
        HashMap<Object, Integer> hObjects = new HashMap<>();
        for (Object obj : objects) {
            if (!hObjects.containsKey(obj)) {
                hObjects.put(obj, 1);
            } else {
                hObjects.put(obj, hObjects.get(obj) + 1);
            }
        }
        return hObjects;
    }
}
