package com.epam.homework1.structure;

import com.epam.homework1.exception.UniversityCreationException;

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
        for (int iGroup = 0; iGroup < groups.length; iGroup++) {
            groups[iGroup] = new Group(names[iGroup]);
        }
        if (groups.length == 0) {
            throw new UniversityCreationException("No groups");
        }
    }

    public Group getGroup(int i) {
        return groups[i];
    }

    public int getNumberOfGroups() {
        return groups.length;
    }
}