package com.test;

import com.config.Browser;
import com.config.BrowserOptions;
import com.drivers.DriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class CommonConditions {

    protected WebDriver driver;
    protected Browser browserUnderTest;

    @BeforeEach()
    public void setUp() {
        String browserName = System.getProperty("browser", "EDGE");
        browserUnderTest = Browser.valueOf(browserName.toUpperCase());

        System.out.println("Using browser: " + browserUnderTest);

        driver = DriverManager.getWebDriver(
                browserUnderTest,
                new BrowserOptions.Builder()
                        .headless(false)
                        .incognito(true)
                        .maximized(true)
                        .build());
    }

    @AfterEach
    void tearDown() {
        DriverManager.quitDriver();
    }
}
