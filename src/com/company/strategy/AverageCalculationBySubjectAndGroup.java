package com.company.strategy;

import com.company.exceptions.AverageCalculationException;
import com.company.structure.*;

public class AverageCalculationBySubjectAndGroup implements AverageCalculationStrategy {
    @Override
    public double calculateAverage(Params params) {
        double average = 0, n = 0;
        for (int i = 0; i < params.getGroup().getNumberOfStudents(); i++) {
            Student currentStudent = params.getGroup().getStudent(i);
            for (int j = 0; j < currentStudent.getNumberOfSubjects(); j++) {
                if (currentStudent.getSubject(j).getName().equals(params.getSubject().getName())) {
                    average += currentStudent.getGrades()[j];
                    n++;
                    break;
                }
            }
        }
        if (n == 0) {
            String message = "In " + params.getGroup().getName() + " don't study " + params.getSubject().getName() + "!";
            throw new AverageCalculationException(message);
        }
        return average / n;
    }
}