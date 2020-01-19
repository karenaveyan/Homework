package com.company.strategy;

import com.company.exceptions.AverageCalculationException;

public class AverageCalculationBySubjectAndGroup implements AverageCalculationStrategy {
    @Override
    public double calculateAverage(Params params) throws AverageCalculationException {
        double average = 0, n = 0;
        for (int i = 0; i < params.getGroup().getNumberOfStudents(); i++) {
            for (int j = 0; j < params.getGroup().getStudent(i).getNumberOfSubjects(); j++) {
                if (params.getGroup().getStudent(i).getSubject(j).getName().equals(params.getSubject().getName())) {
                    average += params.getGroup().getStudent(i).getGrades()[j];
                    n++;
                    break;
                }
            }
        }
        if (n == 0) {
            throw new AverageCalculationException("In " + params.getGroup().getName() + " doesn't study " + params.getSubject().getName() + "!");
        }
        return average / n;
    }
}