package com.epam.homework2.custom;

import com.epam.homework2.model.Student;

public class Node {
    private Student student;
    private Node previous;
    private Node next;

    public Node(Student student, Node previous, Node next) {
        this.student = student;
        this.previous = previous;
        this.next = next;
    }

    public Student getStudent() {
        return student;
    }

    public Node getPrevious() {
        return previous;
    }

    public Node getNext() {
        return next;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }
}
