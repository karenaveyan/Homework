package com.epam.homework4;

import com.epam.homework4.model.Month;

public class Main {

    public static void main(String[] args) {
        System.out.println("The holidays of April.");
        Month.APRIL.printHolidays();

        System.out.println("\nCount Of days of March.");
        System.out.println(Month.MARCH.getCountOfDays());

        System.out.println("\nAll months.");
        for (Month month : Month.values()) {
            System.out.println(month.toString());
        }

        System.out.println("\nChecking if it's holiday or not.");
        System.out.println("March 21: " + Month.MARCH.isHoliday(21));
        System.out.println("March 8: " + Month.MARCH.isHoliday(8));
    }
}
