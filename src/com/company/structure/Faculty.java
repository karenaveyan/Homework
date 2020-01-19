package com.company.structure;

import com.company.exceptions.AverageCalculationException;
import com.company.exceptions.UniversityCreationException;

import java.util.Scanner;

public class Faculty {
    private String name;
    private Group[] groups;

    Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setGroups() {
        System.out.print("Enter the number of groups for " + name + " faculty: ");
        Scanner num = new Scanner(System.in);
        groups = new Group[num.nextInt()];
        for (int i = 0; i < groups.length; i++) {
            System.out.print("Enter the name of the group " + (i + 1) + ": ");
            Scanner name = new Scanner(System.in);
            groups[i] = new Group(name.nextLine());
        }
        if (groups.length == 0) {
            throw new UniversityCreationException("No groups");
        }
        System.out.println();
    }

    public Group getGroup(int i) {
        return groups[i];
    }

    public int getNumberOfGroups() {
        return groups.length;
    }
}