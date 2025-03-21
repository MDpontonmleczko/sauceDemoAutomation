package com.saucedemo;

import com.test.CommonConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractPage extends CommonConditions {
    protected WebDriver driver;
    protected final Duration timeout = Duration.ofSeconds(10);
    protected final WebDriverWait wait = new WebDriverWait(driver, timeout);

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected WebElement waitUntilElementIsVisible(WebElement locator) {
        return wait.until(ExpectedConditions.visibilityOf(locator));
    }

    protected WebElement waitUntilElementIsClickable(WebElement locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
