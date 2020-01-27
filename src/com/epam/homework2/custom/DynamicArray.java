package com.epam.homework2.custom;

import com.epam.homework2.model.Student;

public class DynamicArray {
    private Student[] students;
    private int size;
    private int capacity;

    public DynamicArray() {
        size = 0;
        capacity = 10;
        students = new Student[capacity];
    }

    public int size() {
        return size;
    }

    public Student get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return students[index];
    }

    public void add(Student newStudent) {
        checkCapacity();
        students[size] = newStudent;
        size++;
    }

    public boolean remove(Student student) {
        for (int i = 0; i < size; i++) {
            if (student.equals(students[i])) {
                size--;
                for (int j = i; j < size; j++) {
                    students[j] = students[j + 1];
                }
                checkCapacity();
                return true;
            }
        }
        return false;
    }

    private void checkCapacity() {
        if (size == capacity) {
            capacity *= 2;
            Student[] temp;
            temp = new Student[capacity];
            for (int i = 0; i < size; i++) {
                temp[i] = students[i];
            }
            students = temp;
        } else if (size >= 10 && size == capacity / 2) {
            capacity /= 2;
            Student[] temp;
            temp = new Student[capacity];
            for (int i = 0; i < size; i++) {
                temp[i] = students[i];
            }
            students = temp;
        }
    }
}
