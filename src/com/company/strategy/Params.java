package com.company.strategy;

import com.company.structure.*;

import java.util.Random;

public class Params {
    private Student student;
    private Subject subject;
    private Group group;
    private Faculty faculty;
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
        return faculty;
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
        this.faculty = faculty;
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
        int k = r.nextInt(group.getNumberOfStudents());
        int s = r.nextInt(group.getStudent(k).getNumberOfSubjects());
        subject = group.getStudent(k).getSubject(s);
    }

    public void setRandomSubjectAndFaculty() {
        Random r = new Random();
        int i = r.nextInt(university.getNumberOfFaculties());
        faculty = university.getFaculty(i);
        int j = r.nextInt(faculty.getNumberOfGroups());
        int k = r.nextInt(faculty.getGroup(j).getNumberOfStudents());
        int s = r.nextInt(faculty.getGroup(j).getStudent(k).getNumberOfSubjects());
        subject = faculty.getGroup(j).getStudent(k).getSubject(s);
    }

    public void setRandomSubject() {
        Random r = new Random();
        int i = r.nextInt(university.getNumberOfFaculties());
        int j = r.nextInt(university.getFaculty(i).getNumberOfGroups());
        int k = r.nextInt(university.getFaculty(i).getGroup(j).getNumberOfStudents());
        int s = r.nextInt(university.getFaculty(i).getGroup(j).getStudent(k).getNumberOfSubjects());
        subject = university.getFaculty(i).getGroup(j).getStudent(k).getSubject(s);
    }
}