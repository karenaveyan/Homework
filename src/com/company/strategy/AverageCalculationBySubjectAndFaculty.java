package com.company.strategy;

import com.company.exceptions.AverageCalculationException;

public class AverageCalculationBySubjectAndFaculty implements AverageCalculationStrategy {
    @Override
    public double calculateAverage(Params params) {
        double average = 0, n = 0;
        for (int i = 0; i < params.getFaculty().getNumberOfGroups(); i++) {
            for (int j = 0; j < params.getFaculty().getGroup(i).getNumberOfStudents(); j++) {
                for (int k = 0; k < params.getFaculty().getGroup(i).getStudent(j).getNumberOfSubjects(); k++) {
                    if (params.getFaculty().getGroup(i).getStudent(j).getSubject(k).getName().equals(params.getSubject().getName())) {
                        average += params.getFaculty().getGroup(i).getStudent(j).getGrades()[k];
                        n++;
                        break;
                    }
                }
            }
        }
        if (n == 0) {
            throw new AverageCalculationException("In " + params.getFaculty() + " doesn't study " + params.getSubject().getName() + "!");
        }
        return average / n;
    }
}