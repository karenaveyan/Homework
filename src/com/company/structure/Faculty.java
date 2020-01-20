package com.company.structure;

import com.company.exceptions.UniversityCreationException;

public class Faculty {
    private String name;
    private Group[] groups;

    Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setGroups(String[] names) {
        groups = new Group[names.length];
        for (int i = 0; i < groups.length; i++) {
            groups[i] = new Group(names[i]);
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