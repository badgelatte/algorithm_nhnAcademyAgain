package com.again.day0312.basic;

public final class OldArrayUtils {
    private static OldUser user;

    public OldArrayUtils() {
        throw new IllegalStateException();
    }

    public static boolean contains(Object[] objects, Object find) {
        //todo objects array에서 find가 존재하면 true 존재하지 않다면 false를 반환합니다.

        for (Object object : objects) {
            if (object == find) {
                return true;
            }
            if (object.getClass() == OldUser.class && find.getClass() == OldUser.class) {
                OldUser objectUser = (OldUser) object;
                OldUser findUser = (OldUser) find;
                return OldUser.isSame(objectUser, findUser);
            }
        }
        return false;
    }
}