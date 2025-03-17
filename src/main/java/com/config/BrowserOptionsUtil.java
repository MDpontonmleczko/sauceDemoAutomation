package com.config;

import org.openqa.selenium.MutableCapabilities;

public class BrowserOptionsUtil {

    public static void applyCommonOptions(MutableCapabilities options, BrowserOptions browserOptions) {
        if (browserOptions.isHeadless()) options.setCapability("headless", true);
        if (browserOptions.isIncognito()) options.setCapability("incognito", true);
        if (browserOptions.isMaximized()) options.setCapability("start-maximized", true);
    }
}
