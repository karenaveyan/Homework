package com.company.strategy;

import com.company.exceptions.AverageCalculationException;

public class AverageCalculationBySubject implements AverageCalculationStrategy {
    @Override
    public double calculateAverage(Params params) throws AverageCalculationException {
        double average = 0, n = 0;
        for (int i = 0; i < params.getUniversity().getNumberOfFaculties(); i++) {
            for (int j = 0; j < params.getUniversity().getFaculty(i).getNumberOfGroups(); j++) {
                for (int k = 0; k < params.getUniversity().getFaculty(i).getGroup(j).getNumberOfStudents(); k++) {
                    for (int s = 0; s < params.getUniversity().getFaculty(i).getGroup(j).getStudent(k).getNumberOfSubjects(); s++) {
                        if (params.getUniversity().getFaculty(i).getGroup(j).getStudent(k).getSubject(s).getName().equals(params.getSubject().getName())) {
                            average += params.getUniversity().getFaculty(i).getGroup(j).getStudent(k).getGrades()[s];
                            n++;
                            break;
                        }
                    }

                }
            }
        }
        if (n == 0) {
            throw new AverageCalculationException("In " + params.getUniversity() + " doesn't study " + params.getSubject().getName() + "!");
        }
        return average / n;
    }
}