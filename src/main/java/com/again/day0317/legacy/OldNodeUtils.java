package com.again.day0317.legacy;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

// 1030에 완성한 풀이
@Slf4j
public class OldNodeUtils {
    public OldNodeUtils(){
        throw new IllegalArgumentException();
    }

    public static OldNode findOldNode(OldNode head, OldNode find){
        //todo : head 노드에서 find
        if (head == null) {
            throw new IllegalArgumentException();
        }
        while(head != null && head.getData() != find.getData()){
            head = head.getNext();
        }
        return head;
    }

    public static OldNode findOldNodeByIndex(OldNode head, int index){
        //todo head 노드로 부터 index 번째 노드 탐색, index는 0 부터 시작합니다.
        for(int i = 0; head!=null;i++) {
            if(i == index) {
                break;
            }
            head = head.getNext();
        }
        return head;
    }

    public static String printOldNode(OldNode head){
        StringBuilder sb = new StringBuilder();
        //todo: head 노드에서부터 모든 노드를 다음과 같이 반환하도록 구현합니다.
        //10->20->30->40->50
        if (head == null) {
            throw new IllegalArgumentException();
        }
        while(head.getNext() != null) {
            sb.append(head.getData() + "->");
            head = head.getNext();
        }
        sb.append(head.getData());
        return sb.toString();
    }

    public static OldNode removeFirst(OldNode head){
        //todo head OldNode를 삭제하고 새로운 head OldNode를 반환합니다.
        head.getNext().setPrev(null);
        return head.getNext();
    }

    public static void removeOldNode(OldNode head, OldNode find){
        //todo OldNode 삭제
        while(head != null && head.getData() != find.getData()) {
            head = head.getNext();
        }
        if(Objects.nonNull(head.getNext())) {
            head.getNext().setPrev(head.getPrev());
        }
        head.getPrev().setNext(head.getNext());
    }

    public static void removeOldNodeByIndex(OldNode head, int index){
        //todo index 번째 노드 삭제
        for (int i = 0; head != null; i++) {
            if(i == index) {
                head.getPrev().setNext(head.getNext());
                break;
            }
            head = head.getNext();
            if (head.getNext() == null) {
                throw new NoSuchOldNodeException();
            }
        }
    }

    public static int getSize(OldNode head){
        //OldNode의 size 반환
        int size = 0;
        if(head == null) {
            throw new IllegalArgumentException();
        }
        while(head != null){
            size++;
            head = head.getNext();
        }
        // int size = (int)head.getData();
        return size;
    }

}