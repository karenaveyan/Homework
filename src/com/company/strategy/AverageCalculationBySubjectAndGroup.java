package com.company.strategy;

import com.company.exceptions.AverageCalculationException;
import com.company.structure.*;

public class AverageCalculationBySubjectAndGroup implements AverageCalculationStrategy {
    @Override
    public double calculateAverage(Params params) {
        double average = 0, n = 0;
        for (int iStudent = 0; iStudent < params.getGroup().getNumberOfStudents(); iStudent++) {
            Student currentStudent = params.getGroup().getStudent(iStudent);
            for (int iSubject = 0; iSubject < currentStudent.getNumberOfSubjects(); iSubject++) {
                if (currentStudent.getSubject(iSubject).getName().equals(params.getSubject().getName())) {
                    average += currentStudent.getGrades()[iSubject];
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