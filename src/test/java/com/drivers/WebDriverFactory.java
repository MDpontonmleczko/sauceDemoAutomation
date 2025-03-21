package com.drivers;

import com.config.*;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class WebDriverFactory {

    public static WebDriver createDriver(Browser browser, BrowserOptions options) {
        BrowserConfigurator configurator = getConfigurator(browser);
        MutableCapabilities capabilities = configurator.configure(options);

        WebDriver driver = switch (browser) {
            case EDGE -> new EdgeDriver((EdgeOptions) capabilities);
            case FIREFOX -> new FirefoxDriver((FirefoxOptions) capabilities);
            default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
        };

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        return driver;
    }

    private static BrowserConfigurator getConfigurator(Browser browser) {
        return switch (browser) {
            case EDGE -> new EdgeConfigurator();
            case FIREFOX -> new FirefoxConfigurator();
            default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
        };
    }
}
