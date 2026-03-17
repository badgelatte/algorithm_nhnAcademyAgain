package com.again.day0317.legacy;

import lombok.extern.slf4j.Slf4j;
import java.util.NoSuchElementException;
import java.util.Objects;

// 1030에 당시 TA 선생님과 함께 완성한 풀이
@Slf4j
public class OldNodeUtils_together {
    public OldNodeUtils_together(){
        throw new IllegalArgumentException();
    }

    public static OldNode_together findOldNode_together(OldNode_together head, OldNode_together find){
        //todo : head 노드에서 find
        if (Objects.isNull(find)) {
            throw new IllegalArgumentException();
        }

        OldNode_together OldNode_together = head;
        while(Objects.nonNull(OldNode_together)){
            if(OldNode_together.equals(find)){
                return OldNode_together;
            }
            OldNode_together = OldNode_together.getNext();
        }
        return null;
    }

    public static OldNode_together findOldNode_togetherByIndex(OldNode_together head, int index){
        //todo head 노드로 부터 index 번째 노드 탐색, index는 0 부터 시작합니다.
        int current = 0;    // 현재 index

        OldNode_together OldNode_together = head;
        while(Objects.nonNull(OldNode_together)){
            if(current == index) {
                return OldNode_together;
            }
            OldNode_together = OldNode_together.getNext();
            current++;
        }
        return null;
    }

    public static String printOldNode_together(OldNode_together head){
        if (Objects.isNull(head)) {
            throw new IllegalArgumentException();
        }

        StringBuilder sb = new StringBuilder();
        //todo: head 노드에서부터 모든 노드를 다음과 같이 반환하도록 구현합니다.
        //10->20->30->40->50
        OldNode_together OldNode_together = head;
        while(Objects.nonNull(OldNode_together)){
            sb.append(OldNode_together.getData());
            if(Objects.nonNull(OldNode_together.getNext())){
                sb.append("->");
            }
            OldNode_together = OldNode_together.getNext();
        }

        return sb.toString();
    }

    public static OldNode_together removeFirst(OldNode_together head){
        //todo head OldNode_together를 삭제하고 새로운 head OldNode_together를 반환합니다.
        OldNode_together OldNode_together = head.getNext();
        OldNode_together.setPrev(null);
        return head.getNext();

    }

    public static void removeOldNode_together(OldNode_together head, OldNode_together find){
        //todo OldNode_together 삭제
        OldNode_together OldNode_together = findOldNode_together(head,find);

        OldNode_together prev = OldNode_together.getPrev();
        OldNode_together next = OldNode_together.getNext();

        prev.setNext(next);
        if(Objects.nonNull(next)) {
            next.setPrev(prev);
        }
    }

    public static void removeOldNode_togetherByIndex(OldNode_together head, int index){
        //todo index 번째 노드 삭제
        OldNode_together OldNode_together = findOldNode_togetherByIndex(head, index);
        if(Objects.isNull(OldNode_together)){
            throw new NoSuchElementException();
        }
        removeOldNode_together(head, OldNode_together);
    }

    public static int getSize(OldNode_together head){
        //OldNode_together의 size 반환
        if(Objects.isNull(head)){
            throw new IllegalArgumentException();
        }
        int size = 0;

        OldNode_together OldNode_together = head;
        while(Objects.nonNull(OldNode_together)){
            size++;
            OldNode_together = OldNode_together.getNext();
        }
        return size;
    }

}