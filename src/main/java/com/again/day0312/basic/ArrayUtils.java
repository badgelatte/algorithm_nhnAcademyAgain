package com.again.day0312.basic;

public final class ArrayUtils {

    public ArrayUtils(){
        throw new IllegalStateException();
    }

    public static boolean contains(Object[] objects, Object find){
        //todo objects array에서 find가 존재하면 true 존재하지 않다면 false를 반환합니다.
        //todo 형변환을 이용하여 같은 객체인지 확인한다면 새로운 클래스가 생길때마다 새로운 contains 를 만들어야하겠죠?
        // Object 를 상속받는 다른 클래스들은 어떻게 비교하는지 확인해보세요. ex) String.class
        for (Object o : objects){
            if (o.equals(find)){
                return true;
            }

            if (o.getClass() == User.class && find.getClass() == User.class) {
                User oUser = (User) o;
                User findUser = (User) find;
                return oUser.isSame(findUser);
            }
        }

        return false;
    }

}