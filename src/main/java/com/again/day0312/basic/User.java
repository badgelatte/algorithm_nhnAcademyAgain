package com.again.day0312.basic;

import java.util.Objects;

public class User {

    private final String userId;
    private final String userName;

    public User(String userId, String userName){
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
    public boolean isSame(User user) {
        if (this.equals(user)) {
            return true;
        }

        return this.userId.equals(user.getUserId()) && this.userName.equals(user.getUserName());
    }
}
