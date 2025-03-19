package com.config;

import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxConfigurator implements BrowserConfigurator {

    @Override
    public FirefoxOptions configure(BrowserOptions browserOptions) {
        FirefoxOptions options = new FirefoxOptions();

        if (browserOptions.isHeadless()) {
            options.addArguments("--headless");
        }
        if (browserOptions.isIncognito()) {
            options.addArguments("-private");
        }
        if (browserOptions.isMaximized()) {
            options.addArguments("--start-maximized");
        }

        return options;
    }
}
