package com.test;

import com.config.Browser;
import com.config.BrowserOptions;
import com.drivers.DriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class CommonConditions {

    protected WebDriver driver;
    protected Browser browserUnderTest;

    private static final Logger logger = LoggerFactory.getLogger(CommonConditions.class);

    @BeforeEach()
    public void setUp(TestInfo testInfo) {
        String testMethodName = testInfo.getDisplayName();
        MDC.put("testMethod", testMethodName);

        String browserName = System.getProperty("browser", "EDGE");
        browserUnderTest = Browser.valueOf(browserName.toUpperCase());

        logger.info("\n##############################################\n" +
                "Setting up test with browser: {} for test {}", browserUnderTest, testMethodName);

        driver = DriverManager.getWebDriver(
                browserUnderTest,
                new BrowserOptions.Builder()
                        .headless(false)
                        .incognito(true)
                        .maximized(true)
                        .build());

        logger.info("Driver initialized successfully for {}", testMethodName);
    }

    @AfterEach
    void tearDown(TestInfo testInfo) {
        String testMethodName = testInfo.getDisplayName();
        MDC.put("testMethod", testMethodName);

        logger.info("Tearing down driver for {}", testMethodName);
        DriverManager.quitDriver();
        logger.info("Driver quit successfully for {}", testMethodName);
    }
}
