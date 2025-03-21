package com.test;

import com.model.User;
import com.saucedemo.LoginPage;
import com.service.UserCreator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

public class TestLoginPage extends CommonConditions{

    @Test()
    public void shouldReturnErrorMessageWhenLoginCredentialsAreEmpty() {
        //given
        User user = UserCreator.withCredentialsFromProperty();
        String expectedErrorMessage = "Username is required";
        LoginPage loginPage = new LoginPage(super.driver);

        //when
        loginPage.open()
                .setUsername(user.username())
                .setPassword(user.password())
                .clearUsername()
                .clearPassword()
                .clickLoginButton();

        //then
        String actualErrorMessage = loginPage.getErrorMessage();
        assertTrue(actualErrorMessage.contains(expectedErrorMessage),
                "Expected: '" + expectedErrorMessage +  "' Instead got: '" + actualErrorMessage + "'");
    }

    @Test()
    public void shouldReturnErrorMessageWhenPasswordIsEmpty() {
        //given
        User user = UserCreator.withCredentialsFromProperty();
        String expectedErrorMessage = "Password is required";
        LoginPage loginPage = new LoginPage(driver);

        //when
        loginPage.open()
                .setUsername(user.username())
                .setPassword(user.password())
                .clearPassword()
                .clickLoginButton();

        //then
        String actualErrorMessage = loginPage.getErrorMessage();
        assertTrue(actualErrorMessage.contains(expectedErrorMessage),
                "Expected: '" + expectedErrorMessage +  "' Instead got: '" + actualErrorMessage + "'");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/valid_login_credentials.csv", numLinesToSkip = 1)
    public void shouldLoginSuccessfullyWhenProvidedWithValidCredentials(String username, String password) {
        //given
        User user = new User(username, password);
        String expectedTitle = "Swag Labs";

        //when
        String actualTitle = new LoginPage(super.driver)
                .open()
                .setUsername(user.username())
                .setPassword(user.password())
                .clickLoginButton()
                .getTitle();

        //then
        assertEquals(actualTitle, expectedTitle,
                "Expected: '" + expectedTitle +  "' Instead got: '" + actualTitle + "'");
    }

    @Test()
    public void shouldReturnErrorMessageWhenProvidedWithLockeUser() {
        User user = UserCreator.withLockedCredentials();
        String expectedErrorMessage = "Sorry, this user has been locked out.";
        LoginPage loginPage = new LoginPage(driver);

        //when
        loginPage.open()
                .setUsername(user.username())
                .setPassword(user.password())
                .clickLoginButton();

        //then
        String actualErrorMessage = loginPage.getErrorMessage();
        assertTrue(actualErrorMessage.contains(expectedErrorMessage),
                "Expected: '" + expectedErrorMessage +  "' Instead got: '" + actualErrorMessage + "'");
    }

}
