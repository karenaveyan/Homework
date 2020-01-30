package com.epam.homework4.model;

public enum Month {
    JANUARY(31, 1, 6),
    FEBRUARY(28),
    MARCH(31, 8),
    APRIL(30, 1, 7),
    MAY(31, 9),
    JUNE(30, 1),
    JULE(31),
    AUGUST(31),
    SEPTEMBER(30, 1),
    OCTOBER(31),
    NOVEMBER(30),
    DECEMBER(31);

    private int countOfDays;
    private int[] holidays;

    Month(int countOfDays, int... holidays) {
        this.countOfDays = countOfDays;
        this.holidays = holidays;
    }

    public boolean isHoliday(int day) {
        for (int holiday : holidays) {
            if (day == holiday) {
                return true;
            }
        }
        return false;
    }

    public int getCountOfHolidays() {
        return holidays.length;
    }

    public int getCountOfDays() {
        return countOfDays;
    }

    public void printHolidays() {
        if (holidays.length == 0) {
            System.out.println("There's no holidays on " + this.toString());
        } else {
            for (int holiday : holidays) {
                System.out.println(this.toString() + " " + holiday);
            }
        }
    }
}
