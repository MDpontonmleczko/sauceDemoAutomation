package com.saucedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage{
    @FindBy(xpath = "//div[@class='app_logo']")
    public WebElement titleLocator;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return waitUntilElementIsVisible(titleLocator).getText();
    }

}
