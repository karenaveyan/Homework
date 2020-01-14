package com.company.strategy;

import com.company.exceptions.LogicException;

public interface GradeGettingStrategy {
    double getAverageGrade(Params p) throws LogicException;
}