package com.gl.donate_receive_tests.elements;

import com.gl.donate_receive_tests.locators.BaseLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LabelElement extends BaseElement{
    public LabelElement(WebDriver driver, BaseLocator locator) {
        super(driver, locator);
    }

    public LabelElement(WebElement webElement, BaseLocator locator) {
        super(webElement, locator);
    }

    public LabelElement(WebElement webElement) {
        super(webElement);
    }

    public String getText(){
        return webElement.getText();
    }
}
