package com.company.strategy;

import com.company.exceptions.LogicException;

public class GettingBySubjectAndFaculty implements GradeGettingStrategy {
    @Override
    public double getAverageGrade(Params p) throws LogicException {
        double s = 0, n = 0;
        for (int i = 0; i < p.faculty.getNumberOfGroups(); i++) {
            for (int j = 0; j < p.faculty.getGroup(i).getNumberOfSubjects(); j++) {
                if (p.faculty.getGroup(i).getSubject(j).getName().equals(p.subject.getName())) {
                    for (int k = 0; k < p.faculty.getGroup(i).getNumberOfStudents(); k++) {
                        s += p.faculty.getGroup(i).getStudent(k).getGrades()[j];
                    }
                    n += p.faculty.getGroup(i).getNumberOfStudents();
                }
            }
        }
        if (n == 0) {
            throw new LogicException("In " + p.faculty + " doesn't study " + p.subject.getName() + "!");
        }
        return s / n;
    }
}