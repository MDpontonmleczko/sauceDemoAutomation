package com.config;

import org.openqa.selenium.MutableCapabilities;

public interface BrowserConfigurator {
    MutableCapabilities configure(BrowserOptions browserOptions);
}
