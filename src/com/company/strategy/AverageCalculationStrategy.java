package com.company.strategy;

import com.company.exceptions.AverageCalculationException;

public interface AverageCalculationStrategy {
    double calculateAverage(Params params);
}