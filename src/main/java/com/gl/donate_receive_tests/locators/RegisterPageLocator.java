package com.gl.donate_receive_tests.locators;

import org.openqa.selenium.By;

public enum RegisterPageLocator implements BaseLocator {
    ENTER_LOGIN(By.id("login")),
    ENTER_PASSWORD(By.id("password")),
    REGISTER_BUTTON(By.xpath("//input[@value='Register']")),
    CLEAR_BUTTON(By.xpath("//input[@value='Clear']")),
    LOGIN_BUTTON(By.xpath("//input[@value='LogIn']")),
    HOME_PAGE_BUTTON(By.xpath("//a[@class='navbar-brand']")),
    CREATE_NEW_USER_TEXT(By.cssSelector("div.col-md-offset-2 > h2"));
    private By path;

    RegisterPageLocator(By path) {
        this.path = path;
    }

    @Override
    public By getPath() {
        return path;
    }
}
