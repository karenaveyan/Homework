package com.company.strategy;

import com.company.exceptions.LogicException;

public class GettingBySubject implements GradeGettingStrategy {
    @Override
    public double getAverageGrade(Params p) throws LogicException {
        double s = 0, n = 0;
        for (int i = 0; i < p.university.getNumberOfFaculties(); i++) {
            for (int j = 0; j < p.university.getFaculty(i).getNumberOfGroups(); j++) {
                for (int k = 0; k < p.university.getFaculty(i).getGroup(j).getNumberOfSubjects(); k++)
                    if (p.university.getFaculty(i).getGroup(j).getSubject(k).getName().equals(p.subject.getName())) {
                        for (int t = 0; t < p.university.getFaculty(i).getGroup(j).getNumberOfStudents(); t++) {
                            s += p.university.getFaculty(i).getGroup(j).getStudent(t).getGrades()[k];
                        }
                        n += p.university.getFaculty(i).getGroup(j).getNumberOfStudents();
                    }
            }
        }
        if (n == 0) {
            throw new LogicException("In " + p.university + " doesn't study " + p.subject.getName() + "!");
        }
        return s / n;
    }
}