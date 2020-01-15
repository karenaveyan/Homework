package com.company.strategy;

import com.company.exceptions.AverageCalculationException;

public class AverageCalculationBySubjectAndFaculty implements AverageCalculationStrategy {
    @Override
    public double calculateAverage(Params params) throws AverageCalculationException {
        double average = 0, n = 0;
        for (int i = 0; i < params.getFaculty().getNumberOfGroups(); i++) {
            for (int j = 0; j < params.getFaculty().getGroup(i).getNumberOfSubjects(); j++) {
                if (params.getFaculty().getGroup(i).getSubject(j).getName().equals(params.getSubject().getName())) {
                    for (int k = 0; k < params.getFaculty().getGroup(i).getNumberOfStudents(); k++) {
                        average += params.getFaculty().getGroup(i).getStudent(k).getGrades()[j];
                    }
                    n += params.getFaculty().getGroup(i).getNumberOfStudents();
                }
            }
        }
        if (n == 0) {
            throw new AverageCalculationException("In " + params.getFaculty() + " doesn't study " + params.getSubject().getName() + "!");
        }
        return average / n;
    }
}