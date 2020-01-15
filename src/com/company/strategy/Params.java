package com.company.strategy;

import com.company.structure.*;

import java.util.Random;

public class Params {
    private Student student;
    private Subject subject;
    private Group group;
    private Faculty getFaculty;
    private University university;

    public Params(University university) {
        this.university = university;
    }

    public Student getStudent() {
        return student;
    }

    public Subject getSubject() {
        return subject;
    }

    public Group getGroup() {
        return group;
    }

    public Faculty getFaculty() {
        return getFaculty;
    }

    public University getUniversity() {
        return university;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void setFaculty(Faculty faculty) {
        this.getFaculty = faculty;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public void setRandomStudent() {
        Random r = new Random();
        int i = r.nextInt(university.getNumberOfFaculties());
        int j = r.nextInt(university.getFaculty(i).getNumberOfGroups());
        int k = r.nextInt(university.getFaculty(i).getGroup(j).getNumberOfStudents());
        student = university.getFaculty(i).getGroup(j).getStudent(k);
    }

    public void setRandomSubjectAndGroup() {
        Random r = new Random();
        int i = r.nextInt(university.getNumberOfFaculties());
        int j = r.nextInt(university.getFaculty(i).getNumberOfGroups());
        group = university.getFaculty(i).getGroup(j);
        int k = r.nextInt(group.getNumberOfSubjects());
        subject = group.getSubject(k);
    }

    public void setRandomSubjectAndFaculty() {
        Random r = new Random();
        int i = r.nextInt(university.getNumberOfFaculties());
        getFaculty = university.getFaculty(i);
        int j = r.nextInt(getFaculty.getNumberOfGroups());
        int k = r.nextInt(getFaculty.getGroup(j).getNumberOfSubjects());
        subject = getFaculty.getGroup(j).getSubject(k);
    }

    public void setRandomSubject() {
        Random r = new Random();
        int i = r.nextInt(university.getNumberOfFaculties());
        int j = r.nextInt(university.getFaculty(i).getNumberOfGroups());
        int k = r.nextInt(university.getFaculty(i).getGroup(j).getNumberOfSubjects());
        subject = university.getFaculty(i).getGroup(j).getSubject(k);
    }
}