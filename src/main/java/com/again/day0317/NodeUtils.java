package com.again.day0317;

import lombok.extern.slf4j.Slf4j;
import java.util.Objects;

@Slf4j
public class NodeUtils {

    public static Node findNode(Node head, Node find){
        //todo : head 노드에서 find
        if (Objects.isNull(head) || Objects.isNull(find)) {
            throw new IllegalArgumentException();
        }

        while (head.hasNext()) {
            if (head.getData() == find.getData()){
                return head;
            }
            head = head.getNext();
        }

        if (head.getData() == find.getData()) {
            return head;
        }

        return null;
    }

    public static Node findNodeByIndex(Node head, int index){
        //todo head 노드로 부터 index 번째 노드 탐색, index는 0 부터 시작합니다.
        while (index-- > 0) {
            head = head.getNext();
        }

        return head;
    }

    public static String printNode(Node head){
        StringBuilder sb = new StringBuilder();
        //todo: head 노드에서부터 모든 노드를 다음과 같이 반환하도록 구현합니다.
        //10->20->30->40->50

        if (Objects.isNull(head)) {
            throw new IllegalArgumentException();
        }

        while (head.hasNext()) {
            sb.append(head.getData() + "->");
            head = head.getNext();
        }
        sb.append(head.getData());

        return sb.toString();
    }

    public static Node removeFirst(Node head){
        //todo head node를 삭제하고 새로운 head node를 반환합니다.
        if (Objects.isNull(head)) {
            throw new NoSuchNodeException();
        }
        head = head.getNext();
        head.setPrev(null);
        return head;
    }

    public static void removeNode(Node head, Node find){
        //todo node 삭제
        find = findNode(head, find);

        if (Objects.isNull(head) || Objects.isNull(find)) {
            throw new NoSuchNodeException();
        }

        Node findPrev = find.getPrev();
        Node findNext = find.getNext();
        if (Objects.nonNull(findPrev)) {
            findPrev.setNext(findNext);
        }

        if (Objects.nonNull(findNext)) {
            findNext.setPrev(findPrev);
        }
    }

    public static void removeNodeByIndex(Node head, int index){
            if (getSize(head) < index) {
                throw new NoSuchNodeException();
            }

        //todo index 번째 노드 삭제
        head = findNodeByIndex(head, index);
        Node findPrev = head.getPrev();
        Node findNext = head.getNext();
        findPrev.setNext(findNext);
        findNext.setPrev(findPrev);
    }

    public static int getSize(Node head){
        //node의 size 반환
        int size=0;

        if (Objects.isNull(head)) {
            throw new IllegalArgumentException();
        }

        while (head.hasNext()) {
            size++;
            head = head.getNext();
        }
        return ++size;
    }

}