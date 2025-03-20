package com.saucedemo;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage{
    private final static String LOGIN_PAGE_URL = "https://www.saucedemo.com/";

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement usernameFieldLocator;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordFieldLocator;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement loginButtonLocator;

    @FindBy(xpath = "//h3[contains(text(), 'Username is required')]")
    private WebElement errorMessageLocator;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage open() {
        driver.get(LOGIN_PAGE_URL);
        return this;
    }

    public LoginPage setUsername(String username) {
        waitUntilElementIsClickable(usernameFieldLocator).sendKeys(username);
        return this;
    }

    public LoginPage setPassword(String password) {
        waitUntilElementIsClickable(passwordFieldLocator).sendKeys(password);
        return this;
    }

    public LoginPage clearUsername() {
        waitUntilElementIsClickable(usernameFieldLocator);
        usernameFieldLocator.sendKeys(Keys.CONTROL + "a");
        usernameFieldLocator.sendKeys(Keys.DELETE);
        return this;
    }

    public LoginPage clearPassword() {
        waitUntilElementIsClickable(passwordFieldLocator);
        passwordFieldLocator.sendKeys(Keys.CONTROL + "a");
        passwordFieldLocator.sendKeys(Keys.DELETE);
        return this;
    }

    public MainPage clickLoginButton() {
        waitUntilElementIsClickable(loginButtonLocator).click();
        return new MainPage(driver);
    }

    public String getErrorMessage() {
        return waitUntilElementIsVisible(errorMessageLocator).getText();
    }
}
