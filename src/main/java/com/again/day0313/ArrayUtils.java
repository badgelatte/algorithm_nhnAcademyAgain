package com.again.day0313;

public final class ArrayUtils {

    public ArrayUtils() {
        throw new IllegalStateException();
    }

    public static boolean equals(Object[] objects1 , Object[] objects2 ){
        // TODO 1. 두 배열을 배열을 비교하여 일치하면 true , 일치하지 않다면 false를 반환 합니다.
        if (objects1 == null || objects2 == null) {
            throw new IllegalArgumentException();
        }

        if (objects1.length != objects2.length) {
            return false;
        }

        if (objects1[0].getClass().equals(User.class)) {
            for (int i = 0; i < objects1.length; i++) {
                if (!((User)objects1[i]).equals((User)objects2[i])) {
                    return false;
                }
            }
            return true;
        }

        for (int i = 0; i < objects1.length; i++) {
            if (!objects1[i].equals(objects2[i])) {
                return false;
            }
        }
        return true;
    }
}