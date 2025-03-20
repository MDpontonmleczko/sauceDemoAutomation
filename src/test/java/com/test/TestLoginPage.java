package com.test;

import com.model.User;
import com.saucedemo.LoginPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestLoginPage extends CommonConditions{

    @Test()
    public void shouldReturnErrorMessageWhenLoginCredentialsAreDeleted() {

        //given
        User user = new User("username", "password");
        String expectedErrorMessage = "Username is required";

        //when
        String actualErrorMessage = new LoginPage(super.driver)
                .open()
                .setUsername(user.username())
                .setPassword(user.password())
                .clearUsername()
                .clearPassword()
                .clickLoginButton()
                .getErrorMessage();

        //then
        assertTrue(actualErrorMessage.contains(expectedErrorMessage),
                "Expected: '" + expectedErrorMessage +  "' Instead got: '" + actualErrorMessage + "'");
    }
}
