package com.company.strategy;

import com.company.exceptions.AverageCalculationException;
import com.company.structure.*;

public class AverageCalculationBySubject implements AverageCalculationStrategy {
    @Override
    public double calculateAverage(Params params) {
        double average = 0, n = 0;
        for (int i = 0; i < params.getUniversity().getNumberOfFaculties(); i++) {
            Faculty currentFaculty = params.getUniversity().getFaculty(i);
            for (int j = 0; j < currentFaculty.getNumberOfGroups(); j++) {
                Group currentGroup = currentFaculty.getGroup(j);
                for (int k = 0; k < currentGroup.getNumberOfStudents(); k++) {
                    Student currentStudent = currentGroup.getStudent(k);
                    for (int s = 0; s < currentStudent.getNumberOfSubjects(); s++) {
                        if (currentStudent.getSubject(s).getName().equals(params.getSubject().getName())) {
                            average += currentStudent.getGrades()[s];
                            n++;
                            break;
                        }
                    }

                }
            }
        }
        if (n == 0) {
            String message = "In " + params.getUniversity().getName() + " don't study " + params.getSubject().getName() + "!";
            throw new AverageCalculationException(message);
        }
        return average / n;
    }
}