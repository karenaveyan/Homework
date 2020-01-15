package com.company.strategy;

import com.company.exceptions.AverageCalculationException;

public class AverageCalculationBySubject implements AverageCalculationStrategy {
    @Override
    public double calculateAverage(Params params) throws AverageCalculationException {
        double average = 0, n = 0;
        for (int i = 0; i < params.getUniversity().getNumberOfFaculties(); i++) {
            for (int j = 0; j < params.getUniversity().getFaculty(i).getNumberOfGroups(); j++) {
                for (int k = 0; k < params.getUniversity().getFaculty(i).getGroup(j).getNumberOfSubjects(); k++)
                    if (params.getUniversity().getFaculty(i).getGroup(j).getSubject(k).getName().equals(params.getSubject().getName())) {
                        for (int t = 0; t < params.getUniversity().getFaculty(i).getGroup(j).getNumberOfStudents(); t++) {
                            average += params.getUniversity().getFaculty(i).getGroup(j).getStudent(t).getGrades()[k];
                        }
                        n += params.getUniversity().getFaculty(i).getGroup(j).getNumberOfStudents();
                    }
            }
        }
        if (n == 0) {
            throw new AverageCalculationException("In " + params.getUniversity() + " doesn't study " + params.getSubject().getName() + "!");
        }
        return average / n;
    }
}