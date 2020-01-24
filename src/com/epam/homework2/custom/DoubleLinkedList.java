package com.epam.homework2.custom;

import com.epam.homework2.model.Student;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedList implements Iterable<Student> {
    private Node head;
    private Node tail;
    private int size;

    public DoubleLinkedList() {
        head = tail = null;
        size = 0;
    }

    public void push(Student student) {
        if (head == null) {
            head = tail = new Node(student, null, null);
            size++;
            return;
        }
        Node temp = new Node(student, null, head);
        head.previous = temp;
        head = temp;
        size++;
    }

    public Student pop() {
        checkSize();
        Student temp = head.student;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.previous = null;
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
        tail.next = temp;
        tail = temp;
        size++;
    }

    public Student removeLast() {
        checkSize();
        Student temp = tail.student;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.previous;
            tail.next = null;
        }
        size--;
        return temp;
    }

    public int size() {
        return size;
    }

    private void checkSize() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
    }

    @Override
    public Iterator<Student> iterator() {
        return new customIterator(head);
    }

    private static class customIterator implements Iterator<Student> {
        Node current;

        public customIterator(Node current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Student next() {
            Student temp = current.student;
            current = current.next;
            return temp;
        }
    }

    private static class Node {
        private Student student;
        private Node previous;
        private Node next;

        public Node(Student student, Node previous, Node next) {
            this.student = student;
            this.previous = previous;
            this.next = next;
        }
    }
}
