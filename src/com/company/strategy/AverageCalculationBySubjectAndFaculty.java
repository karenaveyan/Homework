package com.company.strategy;

import com.company.exceptions.AverageCalculationException;
import com.company.structure.*;

public class AverageCalculationBySubjectAndFaculty implements AverageCalculationStrategy {
    @Override
    public double calculateAverage(Params params) {
        double average = 0, n = 0;
        for (int i = 0; i < params.getFaculty().getNumberOfGroups(); i++) {
            Group currentGroup = params.getFaculty().getGroup(i);
            for (int j = 0; j < currentGroup.getNumberOfStudents(); j++) {
                Student currentStudent = currentGroup.getStudent(j);
                for (int k = 0; k < currentStudent.getNumberOfSubjects(); k++) {
                    if (currentStudent.getSubject(k).getName().equals(params.getSubject().getName())) {
                        average += currentStudent.getGrades()[k];
                        n++;
                        break;
                    }
                }
            }
        }
        if (n == 0) {
            String message = "In " + params.getFaculty().getName() + " don't study " + params.getSubject().getName() + "!";
            throw new AverageCalculationException(message);
        }
        return average / n;
    }
}