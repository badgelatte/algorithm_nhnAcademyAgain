package com.again.day0315;

public class NodeUtils {

    public NodeUtils() {
        throw new IllegalStateException();
    }

    public static Node findNode(Node head, Node find) {
        if (head == null) {
            throw new IllegalArgumentException();
        }

        // TODO : head 노드로부터 find node 찾기
        while (head.getNext() != null) {
            if (head.equals(find)) {
                return head;
            }
            head = head.getNext();
        }

        if (head.equals(find)) {
            return head;
        }

        return null;
    }

    public static String printNode(Node head) {
        if (head == null) {
            throw new IllegalArgumentException();
        }

        StringBuilder sb = new StringBuilder();
        // TODO : head 노드에서부터 모든 노드를 다음과 같이 반환하도록 구현합니다.
        // 10->20->30->40->50
        while (head.getNext() != null) {
            sb.append(head.getData() + "->");
            head = head.getNext();
        }

        return sb.append(head.getData()).toString();
    }

    public static Node removeFirst(Node head) {
        // TODO : head node를 삭제하고 새로운 head node를 반환합니다.
        head = head.getNext();
        return head;
    }

    public static void removeNode(Node head, Node find) {
        // TODO : remove node
        if (head.equals(find)) {
            removeFirst(head);
        }

        while (head.getNext() != null && head.getNext().getNext() != null) {
            if (head.getNext().equals(find)) {
                head.setNext(head.getNext().getNext());
            }
            head = head.getNext();
        }
        if (head.getNext().equals(find)) {
            head.setNext(null);
        }
    }
}