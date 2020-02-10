package com.epam.homework5.custom;

import java.util.IllformedLocaleException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * SortedSet keeps comparable objects in set in sorted order.
 *
 * @param <T>
 */
public class SortedSet<T extends Comparable<T>> implements Iterable<T> {
    private Node head;
    private Node tail;
    private int size;

    public SortedSet() {
        head = tail = null;
        size = 0;
    }

    /**
     * The method returns the size of set.
     *
     * @return size
     */
    public int getSize() {
        return size;
    }

    /**
     * The method adds the element in set.
     *
     * @param element
     * @return true if method succeeds, false otherwise.
     */
    public boolean add(T element) {
        checkElement(element);
        if (head == null) {
            head = tail = new Node(element, null, null);
            size++;
            return true;
        }
        Node current = head;
        while (current != null) {
            if (element.equals(current.element)) {
                return false;
            }
            if (element.compareTo(current.element) < 0) {
                Node temp = new Node(element, current.previous, current);
                if (current == head) {
                    current.previous = temp;
                    head = temp;
                } else {
                    current.previous.next = temp;
                    current.previous = temp;
                }
                size++;
                return true;
            }
            if (current == tail) {
                Node temp = new Node(element, current, null);
                current.next = temp;
                tail = temp;
                size++;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * The method removes an element if contains.
     *
     * @param element
     * @return true if method succeeds, false otherwise.
     */
    public boolean remove(T element) {
        checkElement(element);
        Node current = head;
        while (current != null) {
            if (element.equals(current.element)) {
                if (size == 1) {
                    head = tail = null;
                } else if (current == head) {
                    head = current.next;
                    head.previous = null;
                } else if (current == tail) {
                    tail = current.previous;
                    tail.next = null;
                } else {
                    current.previous.next = current.next;
                    current.next.previous = current.previous;
                }
                size--;
                return true;
            }
            current = current.next;
        }
        //throw new NoSuchElementException();
        return false;
    }

    /**
     * The method checks if element is null or not.
     *
     * @param element
     */
    private void checkElement(T element) {
        if (element == null) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * The method returns true if set contains the element, false otherwise.
     *
     * @param element
     * @return true if contains, false otherwise.
     */
    public boolean contains(T element) {
        Node current = head;
        while (current != null) {
            if (element.equals(current.element)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new SortedSet<T>.CustomIterator(head);
    }

    /**
     * Custom implementation of iterator for set.
     */
    private class CustomIterator implements Iterator<T> {
        Node current;

        public CustomIterator(Node head) {
            this.current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T temp = current.element;
            current = current.next;
            return temp;
        }
    }

    /**
     * Node is used for keeping data in linked list.
     * Node consists of an element, left node and right node.
     */
    private class Node {
        private T element;
        private Node previous;
        private Node next;

        public Node(T element, Node previous, Node next) {
            this.element = element;
            this.previous = previous;
            this.next = next;
        }
    }
}

