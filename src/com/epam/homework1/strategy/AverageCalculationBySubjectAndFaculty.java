package com.epam.homework1.strategy;

import com.epam.homework1.exception.AverageCalculationException;
import com.epam.homework1.structure.*;

public class AverageCalculationBySubjectAndFaculty implements AverageCalculationStrategy {
    @Override
    public double calculateAverage(Params params) {
        double average = 0, count = 0;
        for (int iGroup = 0; iGroup < params.getFaculty().getNumberOfGroups(); iGroup++) {
            Group currentGroup = params.getFaculty().getGroup(iGroup);
            for (int iStudent = 0; iStudent < currentGroup.getNumberOfStudents(); iStudent++) {
                Student currentStudent = currentGroup.getStudent(iStudent);
                for (int iSubject = 0; iSubject < currentStudent.getNumberOfSubjects(); iSubject++) {
                    if (currentStudent.getSubject(iSubject).getName().equals(params.getSubject().getName())) {
                        average += currentStudent.getGrades()[iSubject];
                        count++;
                        break;
                    }
                }
            }
        }
        if (count == 0) {
            String message = "In " + params.getFaculty().getName() + " don't study " + params.getSubject().getName() + "!";
            throw new AverageCalculationException(message);
        }
        return average / count;
    }
}