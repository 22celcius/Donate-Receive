package com.gl.donate_receive_tests.locators;

import org.openqa.selenium.By;

public enum LoginFormLocators implements BaseLocator{
    REGISTER_NOW_BOTTON(By.cssSelector("div>h4>a"));
    private By path;

    LoginFormLocators(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
