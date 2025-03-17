package com.config;

import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxConfigurator implements BrowserConfigurator {

    @Override
    public FirefoxOptions configure(BrowserOptions browserOptions) {
        FirefoxOptions options = new FirefoxOptions();

        BrowserOptionsUtil.applyCommonOptions(options, browserOptions);

        return options;
    }
}
