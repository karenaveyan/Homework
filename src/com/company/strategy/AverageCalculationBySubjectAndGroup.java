package com.company.strategy;

import com.company.exceptions.AverageCalculationException;

public class AverageCalculationBySubjectAndGroup implements AverageCalculationStrategy {
    @Override
    public double calculateAverage(Params params) throws AverageCalculationException {
        int index = -1;
        for (int i = 0; i < params.getGroup().getNumberOfSubjects(); i++) {
            if (params.getGroup().getSubject(i).getName().toLowerCase().equals(params.getSubject().getName().toLowerCase())) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new AverageCalculationException("In " + params.getGroup().getName() + " doesn't study " + params.getSubject().getName() + "!");
        }
        double average = 0;
        for (int i = 0; i < params.getGroup().getNumberOfStudents(); i++) {
            average += params.getGroup().getStudent(i).getGrades()[index];
        }
        average /= params.getGroup().getNumberOfStudents();
        return average;
    }
}