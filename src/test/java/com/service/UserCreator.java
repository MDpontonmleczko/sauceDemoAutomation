package com.service;

import com.model.User;

public class UserCreator {
    public static final String USER_NAME = "NameFree";
    public static final String USER_PASSWORD = "PasswordFree";

    public static User withCredentialsFromProperty() {
        return new User(USER_NAME, USER_PASSWORD);
    }

    public static User withLockedCredentials() {
        return new User("locked_out_user", "secret_sauce");
    }
}
