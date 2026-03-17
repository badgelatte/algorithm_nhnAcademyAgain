package com.again.day0317;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
@Slf4j
class NodeUtilsTest {

    Node<Integer> head;

    @BeforeEach
    void setUp() {
        //todo 10->20->30->40->50 node를 생성하세요.
        head = new Node(10);
        Node node20 = new Node(20);
        head.setNext(node20);
        node20.setPrev(head);
        Node node30 = new Node(30);
        node20.setNext(node30);
        node30.setPrev(node20);
        Node node40 = new Node(40);
        node30.setNext(node40);
        node40.setPrev(node30);
        Node node50 = new Node(50);
        node40.setNext(node50);
        node50.setPrev(node40);
    }

    @Test
    @DisplayName("Utility class")
    void constructorTest() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            throw new IllegalStateException();
        });
    }

    @Test
    @DisplayName("create node : 10->20->30->40->50")
    void createNodeTest() {
        //10,20,30,40,50 Node 생성테스트
        String actual = NodeUtils.printNode(head);
        Assertions.assertEquals("10->20->30->40->50", actual);
    }

    @Test
    @DisplayName("findNodeByValue args validation")
    void findNodeByValue_args_validation() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            NodeUtils.findNode(null, new Node(1));
        });
    }

    @Test
    @DisplayName("printNode args validation")
    void printNode_args_validation() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
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
    void removeHeadNode() {
        head = NodeUtils.removeFirst(head);
        Assertions.assertEquals("20->30->40->50", NodeUtils.printNode(head));
    }

    @Test
    @DisplayName("remove 30, push 35, between 20 and 40")
    void addNode() {
        NodeUtils.removeNode(head, new Node(30));
        Node node20 = NodeUtils.findNode(head, new Node(20));
        Node node35 = new Node(35);

        Node temp = node20.getNext();
        node20.setNext(node35);
        node35.setNext(temp);
        Assertions.assertEquals("10->20->35->40->50", NodeUtils.printNode(head));
    }

    @Test
    @DisplayName("remove 20, index 1")
    void removeNodeByIndex() {
        NodeUtils.removeNodeByIndex(head,1);
        Assertions.assertEquals("10->30->40->50", NodeUtils.printNode(head));
    }

    @Test
    @DisplayName("remove node : out of index")
    void removeNodeBy_out_of_index(){
        Assertions.assertThrows(NoSuchNodeException.class,()->{
            NodeUtils.removeNodeByIndex(head,10);
        });
    }

    @Test
    @DisplayName("size of node")
    void getSize() {
        Assertions.assertAll(
                ()->{
                    Assertions.assertEquals(5,NodeUtils.getSize(head));
                },
                ()->{
                    Assertions.assertThrows(IllegalArgumentException.class,()->{
                        NodeUtils.getSize(null);
                    });
                }
        );
    }
}