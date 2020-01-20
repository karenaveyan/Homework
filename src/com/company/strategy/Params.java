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
        int iFaculty = r.nextInt(university.getNumberOfFaculties());
        int iGroup = r.nextInt(university.getFaculty(iFaculty).getNumberOfGroups());
        int iStudent = r.nextInt(university.getFaculty(iFaculty).getGroup(iGroup).getNumberOfStudents());
        student = university.getFaculty(iFaculty).getGroup(iGroup).getStudent(iStudent);
    }

    public void setRandomSubjectAndGroup() {
        Random r = new Random();
        int iFaculty = r.nextInt(university.getNumberOfFaculties());
        int iGroup = r.nextInt(university.getFaculty(iFaculty).getNumberOfGroups());
        group = university.getFaculty(iFaculty).getGroup(iGroup);
        int iStudent = r.nextInt(group.getNumberOfStudents());
        int iSubject = r.nextInt(group.getStudent(iStudent).getNumberOfSubjects());
        subject = group.getStudent(iStudent).getSubject(iSubject);
    }

    public void setRandomSubjectAndFaculty() {
        Random r = new Random();
        int iFaculty = r.nextInt(university.getNumberOfFaculties());
        faculty = university.getFaculty(iFaculty);
        int iGroup = r.nextInt(faculty.getNumberOfGroups());
        int iStudent = r.nextInt(faculty.getGroup(iGroup).getNumberOfStudents());
        int iSubject = r.nextInt(faculty.getGroup(iGroup).getStudent(iStudent).getNumberOfSubjects());
        subject = faculty.getGroup(iGroup).getStudent(iStudent).getSubject(iSubject);
    }

    public void setRandomSubject() {
        Random r = new Random();
        int iFaculty = r.nextInt(university.getNumberOfFaculties());
        int iGroup = r.nextInt(university.getFaculty(iFaculty).getNumberOfGroups());
        int iStudent = r.nextInt(university.getFaculty(iFaculty).getGroup(iGroup).getNumberOfStudents());
        int iSubject = r.nextInt(university.getFaculty(iFaculty).getGroup(iGroup).getStudent(iStudent).getNumberOfSubjects());
        subject = university.getFaculty(iFaculty).getGroup(iGroup).getStudent(iStudent).getSubject(iSubject);
    }
}