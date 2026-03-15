package com.again.day0315;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NodeTest {
    @Test
    void getData() {
        Node node = new Node(10);
        Assertions.assertEquals(10, node.getData());
    }

    @Test
    void getNext() {
        Node head = new Node(10);
        head.setNext(new Node(20));
        Assertions.assertEquals(head.getNext(), new Node(20));
    }

}