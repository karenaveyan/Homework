package com.epam.homework1.strategy;

import com.epam.homework1.exception.AverageCalculationException;
import com.epam.homework1.structure.*;

public class AverageCalculationBySubject implements AverageCalculationStrategy {
    @Override
    public double calculateAverage(Params params) {
        double average = 0, count = 0;
        for (int iFaculty = 0; iFaculty < params.getUniversity().getNumberOfFaculties(); iFaculty++) {
            Faculty currentFaculty = params.getUniversity().getFaculty(iFaculty);
            for (int iGroup = 0; iGroup < currentFaculty.getNumberOfGroups(); iGroup++) {
                Group currentGroup = currentFaculty.getGroup(iGroup);
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
        }
        if (count == 0) {
            String message = "In " + params.getUniversity().getName() + " don't study " + params.getSubject().getName() + "!";
            throw new AverageCalculationException(message);
        }
        return average / count;
    }
}