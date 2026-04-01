package com.again.day0331;

public interface ISet <E>{

    //지정된 요소가 없을 경우 Set에 요소를 추가합니다. 지정된 요소가 존재하는 경우 false를 반환합니다.
    boolean add(E item);
    //지정된 객체가 존재하는 경우 해당 요소를 제거합니다. 요소가 없는 경우 false를 반환합니다.
    boolean remove(E o);
    //지정된 요소가 집합에 있는지 확인합니다.
    boolean contains(E o);
    //집합이 비어있을 경우 true를, 아닌 경우 false를 반환합니다
    boolean isEmpty();
    //집합에 포함된 요소의 수를 반환합니다.
    int size();
    //집합의 모든 요소를 제거합니다.
    void clear();

}