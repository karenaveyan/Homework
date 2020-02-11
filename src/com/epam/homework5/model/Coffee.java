package com.epam.homework5.model;

import java.util.Objects;

/**
 * Coffee class describes coffee with type and price.
 */
public class Coffee implements Comparable<Coffee> {
    private double price;
    private CoffeeType type;

    public Coffee(CoffeeType type, double price) {
        this.type = type;
        this.price = price;
    }

    @Override
    public int compareTo(Coffee coffee) {
        return Double.compare(price, coffee.price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coffee coffee = (Coffee) o;
        return Double.compare(coffee.price, price) == 0 &&
                type == coffee.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, type);
    }

    @Override
    public String toString() {
        return type + " - " + price + " AMD";
    }
}
