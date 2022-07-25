package com.gl.donate_receive_tests.elements;

import com.gl.donate_receive_tests.locators.BaseLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ButtonElement extends BaseElement{
    public ButtonElement(WebDriver driver, BaseLocator locator) {
        super(driver, locator);
    }

    public ButtonElement(WebElement webElement, BaseLocator locator) {
        super(webElement, locator);
    }

    public ButtonElement(WebElement webElement) {
        super(webElement);
    }

    public void click() {
        this.webElement.click();
    }

    public String getText() {
        return webElement.getText();
    }

    public void sendKeys(String keys) {
        this.webElement.sendKeys(keys);
    }
}
