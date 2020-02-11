package com.epam.homework5;

import com.epam.homework5.custom.SortedSet;
import com.epam.homework5.model.Coffee;
import com.epam.homework5.model.CoffeeType;
import com.epam.homework5.model.Student;

/**
 * This program uses custom implemented sorted set with examples.
 *
 * @author Karen Aveyan
 * @version 1.0
 * @since 07.02.2020
 */
public class Main {

    public static void main(String[] args) {
        SortedSet<Student> studentSet = new SortedSet<>();
        studentSet.add(new Student("Armen", "Ghazaryan", 18));
        studentSet.add(new Student("Karen", "Ghazaryan", 17));
        studentSet.add(new Student("Artak", "Meliqyan", 22));
        studentSet.add(new Student("Arthur", "Petrosyan", 22));
        studentSet.remove(new Student("Armen", "Ghazaryan", 18));

        System.out.println("Size of studentSet: " + studentSet.getSize());
        for (Student student : studentSet) {
            System.out.println(student);
        }
        System.out.println();

        SortedSet<Coffee> coffeeSet = new SortedSet<>();
        coffeeSet.add(new Coffee(CoffeeType.AMERICANO, 500));
        coffeeSet.add(new Coffee(CoffeeType.CAPPUCCINO, 550));
        coffeeSet.add(new Coffee(CoffeeType.ARABICA, 500));
        coffeeSet.add(new Coffee(CoffeeType.ESPRESSO, 500));

        coffeeSet.add(new Coffee(CoffeeType.LATTE, 600));
        coffeeSet.remove(new Coffee(CoffeeType.AMERICANO, 500));

        System.out.println("Size of coffeeSet: " + coffeeSet.getSize());
        for (Coffee coffee : coffeeSet) {
            System.out.println(coffee);
        }
    }
}