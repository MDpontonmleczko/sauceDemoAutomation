package com.test;

import com.model.User;
import com.saucedemo.LoginPage;
import com.service.UserCreator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class TestLoginPage extends CommonConditions{

    private static final Logger logger = LoggerFactory.getLogger(TestLoginPage.class);

    @Test()
    public void shouldReturnErrorMessageWhenLoginCredentialsAreEmpty() {
        logger.info("Test shouldReturnErrorMessageWhenLoginCredentialsAreEmpty started");

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
        logger.info("Error message for shouldReturnErrorMessageWhenLoginCredentialsAreEmpty received: {}",
                actualErrorMessage);

        assertThat(actualErrorMessage).contains(expectedErrorMessage);

        logger.info("Test shouldReturnErrorMessageWhenLoginCredentialsAreEmpty completed");
    }

    @Test()
    public void shouldReturnErrorMessageWhenPasswordIsEmpty() {
        logger.info("Test shouldReturnErrorMessageWhenPasswordIsEmpty started");

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
        logger.info("Error message for shouldReturnErrorMessageWhenPasswordIsEmpty received: {}",
                actualErrorMessage);

        assertThat(actualErrorMessage).contains(expectedErrorMessage);

        logger.info("Test shouldReturnErrorMessageWhenPasswordIsEmpty completed");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/valid_login_credentials.csv", numLinesToSkip = 1)
    public void shouldLoginSuccessfullyWhenProvidedWithValidCredentials(String username, String password) {
        logger.info("Test shouldLoginSuccessfullyWhenProvidedWithValidCredentials started");

        //given
        User user = new User(username, password);
        logger.info("Test shouldLoginSuccessfullyWhenProvidedWithValidCredentials using username: {}, password: {}",
                user.username(), user.password());

        String expectedTitle = "Swag Labs";

        //when
        String actualTitle = new LoginPage(super.driver)
                .open()
                .setUsername(user.username())
                .setPassword(user.password())
                .clickLoginButton()
                .getTitle();

        //then
        assertThat(actualTitle).isEqualTo(expectedTitle);

        logger.info("Test shouldLoginSuccessfullyWhenProvidedWithValidCredentials for username: {}, password: {} completed",
                user.username(), user.password());
    }

    @Test()
    public void shouldReturnErrorMessageWhenProvidedWithLockeUser() {
        logger.info("Test shouldReturnErrorMessageWhenProvidedWithLockeUser started");

        //given
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
        logger.info("Error message for shouldReturnErrorMessageWhenProvidedWithLockeUser received: {}",
                actualErrorMessage);

        assertThat(actualErrorMessage).contains(expectedErrorMessage);

        logger.info("Test shouldReturnErrorMessageWhenProvidedWithLockeUser completed");
    }

}
