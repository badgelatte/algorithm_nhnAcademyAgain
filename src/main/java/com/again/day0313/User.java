package com.again.day0313;

public class User {
    private final String userId;
    private final String userName;

    public User(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public boolean equals(User user) {
        return this.userId.equals(user.userId) && this.userName.equals(user.userName);
    }
}
