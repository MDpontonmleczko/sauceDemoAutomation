package com.saucedemo;

import com.test.CommonConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractPage extends CommonConditions {
    protected static WebDriver driver;
    protected final Duration timeout = Duration.ofSeconds(10);
    protected final WebDriverWait wait = new WebDriverWait(driver, timeout);

    protected AbstractPage(WebDriver driver) {
        AbstractPage.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
