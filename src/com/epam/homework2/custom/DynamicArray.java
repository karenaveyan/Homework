package com.epam.homework2.custom;

import com.epam.homework2.model.Student;

public class DynamicArray {
    private Student[] students;

    public DynamicArray() {
        students = new Student[0];
    }

    public int size() {
        return students.length;
    }

    public Student get(int index) {
        if (index < 0 || index >= size()) {
            return null;
        }
        return students[index];
    }

    public void add(Student newStudent) {
        Student[] temp;
        temp = new Student[size() + 1];
        for (int i = 0; i < size(); i++) {
            temp[i] = students[i];
        }
        temp[size()] = newStudent;
        students = temp;
    }

    public boolean remove(Student student) {
        boolean studentExist = false;
        for (Student s : students) {
            if (s == student) {
                studentExist = true;
                break;
            }
        }
        if (!studentExist) {
            return false;
        }
        Student[] temp = new Student[size() - 1];
        for (int i = 0, j = 0; j < size(); j++) {
            if (students[i] == student && studentExist) {
                studentExist = false;
                continue;
            }
            temp[i++] = students[j];
        }
        students = temp;
        return true;
    }
}
