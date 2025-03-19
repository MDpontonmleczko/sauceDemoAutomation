package com.drivers;

import com.config.Browser;
import com.config.BrowserOptions;
import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static final ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    public static WebDriver getWebDriver(Browser browser, BrowserOptions options) {
        if (webDriverThreadLocal.get() == null) {
            webDriverThreadLocal.set(WebDriverFactory.createDriver(browser, options));
        }
        return  webDriverThreadLocal.get();
    }

    public static void quitDriver() {
        if (webDriverThreadLocal.get() != null) {
            webDriverThreadLocal.get().quit();
            webDriverThreadLocal.remove();
        }
    }
}
