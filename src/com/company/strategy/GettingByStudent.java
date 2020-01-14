package com.company.strategy;

public class GettingByStudent implements GradeGettingStrategy {

    @Override
    public double getAverageGrade(Params p) {
        double[] grades = p.student.getGrades();
        double s = 0;
        for (double grade : grades) {
            s += grade;
        }
        s /= grades.length;
        return s;
    }
}