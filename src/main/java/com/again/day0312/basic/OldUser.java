package com.again.day0312.basic;

public class OldUser {

    private final String userId;
    private final String userName;

    public OldUser(String userId, String userName){
        this.userId = userId;
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    //todo user 객체의 비교가 될 수 있도록 구현합니다.
    public static boolean isSame(OldUser user1, OldUser user2) {
        //equals -> data 비교 / == -> 주소값 비교
        if (user1.userId.equals(user2.userId) && user1.userName.equals(user2.userName)){
            return true;
        }
        return false;
        // return (userId.equals(userName));
    }
}
