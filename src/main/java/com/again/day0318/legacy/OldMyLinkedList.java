package com.again.day0318.legacy;

import com.again.day0318.ILinkedList;
import com.again.day0318.MyList;
import com.again.day0318.Node;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

// rapping
public class OldMyLinkedList<E> implements ILinkedList<E>, MyList<E>, Iterable<E> {
    // tail node
    private Node<E> head;
    // tail node
    private Node<E> tail;
    // linkedlist size
    private int size = 0;

    public OldMyLinkedList() {
    }

    @Override
    public void addFirst(E e) {
        Node<E> node = new Node<E>(e);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            head.setPrev(node);
            head = node;
        }

    }

    @Override
    public void addLast(E e) {
        Node<E> node = new Node<E>(e);
        tail.setNext(node);
        node.setPrev(tail);
        tail = node;
    }

    @Override
    public E removeFirst() {
        if (Objects.isNull(head)) {
            throw new NullPointerException();
        }
        E data = head.getData();
        head = head.getNext();
        head.setPrev(null);
        return data;
    }

    @Override
    public E removeLast() {
        E data = tail.getData();
        tail = tail.getPrev();
        tail.setNext(null);
        return data;
    }

    @Override
    public E getFirst() {
        return head.getData();
    }

    @Override
    public E getLast() {
        return tail.getData();
    }

    @Override
    public boolean add(E element) {
        if (Objects.isNull(head)) {
            addFirst(element);
            return true;
        } else {
            this.addLast(element);
            return tail.getData() == element;
        }
    }

    @Override
    public boolean remove(int index) {
        Node<E> node = head;
        for (int i = 0; i <= index; i++) {
            if (index == 0) {
                removeFirst();
                return true;
            } else if (node.getNext() == null) {
                removeLast();
                return true;
            } else if (i == index) {
                node.getPrev().setNext(node.getNext());
                node.getNext().setPrev(node.getPrev());
                return true;
            }
            node = node.getNext();
        }
        return false;
    }

    @Override
    public boolean remove(E e) {
        Node<E> node = head;
        while (node != null) {
            if (node.getData() == e) {
                if (node.getPrev() == null) {
                    removeFirst();
                    return true;
                } else if (node.getNext() == null) {
                    removeLast();
                    return true;
                } else {
                    node.getPrev().setNext(node.getNext());
                    node.getNext().setPrev(node.getPrev());
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public E get(int index) {
        Node<E> node = head;
        while (index-- > 0) {
            node = node.getNext();
        }
        return node.getData();
    }

    @Override
    public E set(int index, E element) {
        Node<E> insert = new Node<E>(element);
        Node<E> node = head;
        while (index-- > 0) {
            node = node.getNext();
        }
        node.getNext().setPrev(insert);
        node.getPrev().setNext(insert);
        return element;
    }

    @Override
    public int size() {
        Node<E> node = head;
        while (node != null) {
            node = node.getNext();
            size++;
        }
        return size;
    }

    @Override
    public boolean contains(Object o) {
        Node<E> node = head;
        while (node != null) {
            if (node.getData() == o) {
                return true;
            }
            node = node.getNext();
        }
        return false;
    }

    // 미리보기
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node node = head;

            @Override
            public boolean hasNext() {
                return node != null;
                // 내 입장에선 현재이지만 밖에서 꺼낼라는 첫번째이기 때문에 나를 확인하는 게 맞다
            }

            @Override
            public E next() {
                if (hasNext()) {
                    E nodeData = (E) node.getData();
                    node = node.getNext();
                    return nodeData;
                    // 있으면 다음 값 가져오기
                    // MyLinkedList와 iterator 내부 진행도는 다르다 생각해야한다
                    // MyLinkedList와 iterator가 12345고 iterator에서 5를 뺐다면 MyLinkedList는 12345,
                    // iterator는 1234여야 한다
                }
                throw new NoSuchElementException();
            }

        };

    }
}
