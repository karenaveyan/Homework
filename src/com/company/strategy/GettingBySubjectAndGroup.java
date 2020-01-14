package com.company.strategy;

import com.company.exceptions.LogicException;

public class GettingBySubjectAndGroup implements GradeGettingStrategy {
    @Override
    public double getAverageGrade(Params p) throws LogicException {
        int index = -1;
        for (int i = 0; i < p.group.getNumberOfSubjects(); i++) {
            if (p.group.getSubject(i).getName().toLowerCase().equals(p.subject.getName().toLowerCase())) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new LogicException("In " + p.group.getName() + " doesn't study " + p.subject.getName() + "!");
        }
        double s = 0;
        for (int i = 0; i < p.group.getNumberOfStudents(); i++) {
            s += p.group.getStudent(i).getGrades()[index];
        }
        s /= p.group.getNumberOfStudents();
        return s;
    }
}