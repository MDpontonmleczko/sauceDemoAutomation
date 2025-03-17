package com.test;

import com.saucedemo.LoginPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestLoginPage {

    @Test()
    public void shouldReturnErrorMessageWhenLoginCredentialsAreEmpty() {

        String expectedErrorMessage = "Username is required";
        String actualErrorMessage = LoginPage
                .open()
                .setUsername(username)
                .setPassword(password)
                .clearUsername()
                .clearPassword()
                .clicLoginButton()
                .getErrorMessage();

        assertEquals(expectedErrorMessage, actualErrorMessage,
                "Expected: '" + expectedErrorMessage +  "' Instead got: '" + actualErrorMessage + "'");
    }
}
