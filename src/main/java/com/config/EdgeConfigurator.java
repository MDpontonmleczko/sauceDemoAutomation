package com.config;

import org.openqa.selenium.edge.EdgeOptions;

public class EdgeConfigurator implements BrowserConfigurator {

    @Override
    public EdgeOptions configure(BrowserOptions browserOptions) {
        EdgeOptions options = new EdgeOptions();

        BrowserOptionsUtil.applyCommonOptions(options, browserOptions);

        return options;
    }
}
