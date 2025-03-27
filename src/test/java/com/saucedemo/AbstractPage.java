package com.saucedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected final Duration timeout = Duration.ofSeconds(10);
    protected final WebDriverWait wait;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, timeout);
        PageFactory.initElements(driver, this);
    }

    protected WebElement waitUntilElementIsVisible(WebElement locator) {
        return wait.until(ExpectedConditions.visibilityOf(locator));
    }

    protected WebElement waitUntilElementIsClickable(WebElement locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
