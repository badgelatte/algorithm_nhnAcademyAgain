package com.again.day0318;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class MyLinkedList<E> implements ILinkedList<E>, MyList<E>, Iterable<E> {
    // head node
    private Node<E> head;
    // tail node
    private Node<E> tail;

    @Override
    public void addFirst(E e) {
        Node<E> node = new Node<E>(e);

        if (head == null) {
            head = node;
            tail = node;
        } else {
            head.setPrev(node);
            head = head.getPrev();
        }
    }

    @Override
    public void addLast(E e) {
        Node<E> node = new Node<E>(e);

        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = tail.getNext();
        }
    }

    @Override
    public E removeFirst() {
        if (Objects.equals(head, tail)) {
            E data = tail.getData();
            head = null;
            tail = null;
            return data;
        }

        E data =  head.getData();
        head = head.getNext();
        head.setPrev(null);

        return data;
    }

    @Override
    public E removeLast() {
        if (Objects.equals(head, tail)) {
            E data = tail.getData();
            head = null;
            tail = null;

            return data;
        }

        E data =  tail.getData();
        tail = tail.getPrev();
        tail.setNext(null);

        return data;
    }

    @Override
    public E getFirst() {
        return  head.getData();
    }

    @Override
    public E getLast() {
        return  tail.getData();
    }


    @Override
    public boolean add(E element) {
        Node<E> node = new Node<E>(element);

        if (head == null) {
            head = node;
            tail = node;
            return true;
        }

        if (contains(node)) {
            return false;
        }

        tail.setNext(node);
        node.setPrev(tail);
        tail = tail.getNext();

        return true;
    }

    @Override
    public boolean remove(int index) {
        Node<E> current = head;

        while (index-- > 0) {
            if(current.getNext() == null) {
                return false;
            }
            current = current.getNext();
        }

        Node<E> prev = current.getPrev();
        Node<E> next = current.getNext();

        if (Objects.isNull(prev)) {
            removeFirst();
            return true;
        }
        if (Objects.isNull(next)) {
            removeLast();
            return true;
        }

        prev.setNext(next);
        next.setPrev(prev);

        return true;
    }

    @Override
    public boolean remove(E e) {
        Node<E> current = head;

        while (current != null) {
            if (current.getData() == e) {
                if (current.getPrev() == null) {
                    removeFirst();
                }
                else if (current.getNext() == null) {
                    removeLast();
                }
                else {
                    Node<E> prev = current.getPrev();
                    Node<E> next = current.getNext();
                    prev.setNext(next);
                    next.setPrev(prev);
                }
                return true;
            }
            current = current.getNext();
        }

        return false;
    }

    @Override
    public E get(int index) {
        Node<E> current = head;

        while (index-- > 0) {
            current = current.getNext();
        }

        return current.getData();
    }

    @Override
    public E set(int index, E element) {
        Node<E> current = head;
        Node<E> node = new Node<E>(element);

        while (index-- > 0) {
            current = current.getNext();
        }

        Node<E> prev = current.getPrev();

        prev.setNext(node);
        current.setPrev(node);
        node.setPrev(prev);
        node.setNext(current);

        return element;
    }

    @Override
    public int size() {
        Node<E> current = head;
        int size = 0;

        while (current.hasNext()) {
            size++;
            current = current.getNext();
        }

        return ++size;
    }

    @Override
    public boolean contains(Object o) {
        Node<E> current = head;

        while (current.hasNext()) {
            if (Objects.equals(o, current.getData())) {
                return true;
            }

            current = current.getNext();
        }

        return Objects.equals(o, current.getData());
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> next = head;

            @Override
            public boolean hasNext() {
                return next != null;
            }

            @Override
            public E next() {
                if (next == null) {
                    throw new NoSuchElementException();
                }

                E data = next.getData();
                next = next.getNext();

                return data;
            }
        };
    }
}