package com.again.day0315;

// 1027에 완성한 풀이
public class OldNodeUtils {
    public static Node findNode(Node head, Node find) {
        Node node = head;
        // TODO : head 노드로부터 find node 찾기
        if (head == null){
            throw new IllegalArgumentException();
        }
        while(!node.equals(find)) {
            node = node.getNext();
        }

        return node;
    }

    public static String printNode(Node head) {
        StringBuilder sb = new StringBuilder();
        // TODO : head 노드에서부터 모든 노드를 다음과 같이 반환하도록 구현합니다.
        // 10->20->30->40->50
        if (head == null) {
            throw new IllegalArgumentException();
        }
        Node node = head;
        for (int index = 0; node.getNext() != null; index++) {
            sb.append(node.getData() + "->");
            node = node.getNext();
        }
        return sb.append(node.getData()).toString();
    }

    public static Node removeFirst(Node head) {
        // TODO : head node를 삭제하고 새로운 head node를 반환합니다.
        head = head.getNext();
        return head;
    }

    public static void removeNode(Node head, Node find) {
        // TODO : remove node
        Node nowNode = head;
        while(nowNode.getNext().getData() != find.getData()) {
            nowNode = nowNode.getNext();
        }
        nowNode.setNext(nowNode.getNext().getNext());
    }
}