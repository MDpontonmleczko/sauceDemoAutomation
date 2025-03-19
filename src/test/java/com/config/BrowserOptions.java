package com.config;

public class BrowserOptions {
    private final boolean headless;
    private final boolean incognito;
    private final boolean maximized;

    private BrowserOptions(Builder builder) {
        this.headless = builder.headless;
        this.incognito = builder.incognito;
        this.maximized = builder.maximized;
    }

    public boolean isHeadless() {
        return headless;
    }

    public boolean isIncognito() {
        return incognito;
    }

    public boolean isMaximized() {
        return maximized;
    }

    public static class Builder {
        private boolean headless = false;
        private boolean incognito = false;
        private boolean maximized = false;

        public Builder headless(boolean value) {
            this.headless = value;
            return this;
        }

        public Builder incognito(boolean value) {
            this.incognito = value;
            return this;
        }

        public Builder maximized(boolean value) {
            this.maximized = value;
            return this;
        }

        public BrowserOptions build() {
            return new BrowserOptions(this);
        }
    }
}
