package com.epam.homework1.strategy;

public class AverageCalculationByStudent implements AverageCalculationStrategy {

    @Override
    public double calculateAverage(Params params) {
        double[] grades = params.getStudent().getGrades();
        double average = 0;
        for (double grade : grades) {
            average += grade;
        }
        average /= grades.length;
        return average;
    }
}