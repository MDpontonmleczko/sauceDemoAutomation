package com.config;

import org.openqa.selenium.edge.EdgeOptions;

public class EdgeConfigurator implements BrowserConfigurator {

    @Override
    public EdgeOptions configure(BrowserOptions browserOptions) {
        EdgeOptions options = new EdgeOptions();

        if (browserOptions.isHeadless()) {
            options.addArguments("--headless", "--disable-gpu");
        }
        if (browserOptions.isIncognito()) {
            options.addArguments("--incognito");
        }
        if (browserOptions.isMaximized()) {
            options.addArguments("--start-maximized");
        }

        return options;
    }
}
