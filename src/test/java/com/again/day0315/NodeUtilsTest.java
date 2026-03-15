package com.again.day0315;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class NodeUtilsTest {

    Node<Integer> head;

    @BeforeEach
    void setUp(){
        head = new Node(10);
        head.setNext(new Node(20));
        head.getNext().setNext(new Node(30));
        head.getNext().getNext().setNext(new Node(40));
        head.getNext().getNext().getNext().setNext(new Node(50));
    }

    @Test
    @DisplayName("Utility class")
    void constructorTest(){
        Assertions.assertThrows(IllegalStateException.class, () ->
                new NodeUtils()
        );
    }

    @Test
    @DisplayName("create node : 10->20->30->40->50")
    void createNodeTest(){
        // 10,20,30,40,50 Node 생성테스트
        String actual = NodeUtils.printNode(head);
        Assertions.assertEquals("10->20->30->40->50", actual);
    }

    @Test
    @DisplayName("findNodeByValue args validation")
    void findNodeByValue_args_validation(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            NodeUtils.findNode(null, new Node(1));
        });
    }

    @Test
    @DisplayName("printNode args validation")
    void printNode_args_validation(){
        Assertions.assertThrows( IllegalArgumentException.class, () -> {
            NodeUtils.printNode(null);
        });
    }

    @Test
    @DisplayName("remove middle node")
    void removeNode() {
        NodeUtils.removeNode(head, new Node(30));
        Assertions.assertEquals("10->20->40->50", NodeUtils.printNode(head));
    }

    @Test
    @DisplayName("remove tail node")
    void removeTailNode() {
        NodeUtils.removeNode(head, new Node(50));
        Assertions.assertEquals("10->20->30->40", NodeUtils.printNode(head));
    }

    @Test
    @DisplayName("remove head node")
    void removeHeadNode(){
        head = NodeUtils.removeFirst(head);
        Assertions.assertEquals("20->30->40->50", NodeUtils.printNode(head));
    }

    @Test
    @DisplayName("remove 30, push 35, between 20 and 40")
    void addNode(){
        NodeUtils.removeNode(head, new Node(30));

        Node node20 = NodeUtils.findNode(head, new Node(20));
        Node node35 = new Node(35);

        Node temp = node20.getNext();
        node20.setNext(node35);
        node35.setNext(temp);

        Assertions.assertEquals("10->20->35->40->50", NodeUtils.printNode(head));

    }

}
