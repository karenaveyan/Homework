package com.epam.homework2.custom;

import com.epam.homework2.model.Student;

public class DoubleLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public DoubleLinkedList() {
        head = tail = null;
        size = 0;
    }

    public Node getHead() {
        return head;
    }

    public void push(Student student) {
        if (head == null) {
            head = tail = new Node(student, null, null);
            size++;
            return;
        }
        Node temp = new Node(student, null, head);
        head.setPrevious(temp);
        head = temp;
        size++;
    }

    public Student pop() {
        if (size == 0) {
            return null;
        }
        Student temp = head.getStudent();
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.getNext();
            head.setPrevious(null);
        }
        size--;
        return temp;
    }

    public void addLast(Student student) {
        if (head == null) {
            head = tail = new Node(student, null, null);
            return;
        }
        Node temp = new Node(student, tail, null);
        tail.setNext(temp);
        tail = temp;
        size++;
    }

    public Student removeLast() {
        if (size == 0) {
            return null;
        }
        Student temp = tail.getStudent();
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.getPrevious();
            tail.setNext(null);
        }
        size--;
        return temp;
    }

    public int size() {
        return size;
    }
}
