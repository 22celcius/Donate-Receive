package com.gl.donate_receive_tests.pages;

import com.gl.donate_receive_tests.elements.ButtonElement;
import com.gl.donate_receive_tests.elements.FieldElement;
import com.gl.donate_receive_tests.elements.LabelElement;
import com.gl.donate_receive_tests.locators.LoginFormLocators;
import com.gl.donate_receive_tests.locators.RegisterPageLocator;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class RegisterFormPage extends BasePage {
    FieldElement enterLoginField;
    FieldElement enterPasswordField;

    ButtonElement registerButton;
    ButtonElement clearButton;
    ButtonElement logInButtonOnRegisterPage;
    ButtonElement homePageButton;
    ButtonElement registerNowButton;

    LabelElement createNewUserText;

    public RegisterFormPage setLogin(String text) {
        if (enterLoginField == null) {
            enterLoginField = new FieldElement(this.driver, RegisterPageLocator.ENTER_LOGIN);
        }
        enterLoginField.sendKeys(text);
        return this;
    }

    public RegisterFormPage setPassword(String text) {
        if (enterPasswordField == null) {
            enterPasswordField = new FieldElement(this.driver, RegisterPageLocator.ENTER_PASSWORD);
        }
        enterPasswordField.sendKeys(text);
        return this;
    }

    public RegisterFormPage clickRegisterButton() {
        if (registerButton == null) {
            registerButton = new ButtonElement(this.driver, RegisterPageLocator.REGISTER_BUTTON);
        }
        registerButton.click();
        return new RegisterFormPage(driver);
    }

    public RegisterFormPage clickClearButton() {
        if (clearButton == null) {
            clearButton = new ButtonElement(this.driver, RegisterPageLocator.CLEAR_BUTTON);
        }
        clearButton.click();
        return new RegisterFormPage(driver);
    }

    public RegisterFormPage clickLogInButtonOnRegisterPage() {
        if (logInButtonOnRegisterPage == null) {
            logInButtonOnRegisterPage = new ButtonElement(this.driver, RegisterPageLocator.LOGIN_BUTTON);
        }
        logInButtonOnRegisterPage.click();
        return new RegisterFormPage(driver);
    }

    public RegisterFormPage clickHomePageButton() {
        if (homePageButton == null) {
            homePageButton = new ButtonElement(this.driver, RegisterPageLocator.HOME_PAGE_BUTTON);
        }
        homePageButton.click();
        return new RegisterFormPage(driver);
    }

    public LabelElement getCreateNewUserText() {
        if (createNewUserText == null) {
            createNewUserText = new LabelElement(this.driver, RegisterPageLocator.CREATE_NEW_USER_TEXT);
        }
        return createNewUserText;
    }

    public RegisterFormPage clickRegisterNowButton() {
        if (registerNowButton == null) {
            registerNowButton = new ButtonElement(this.driver, LoginFormLocators.REGISTER_NOW_BOTTON);
        }
        registerNowButton.click();
        return new RegisterFormPage(driver);
    }

    public boolean isRegisterNowButtonActive() {
        if (registerNowButton == null) {
            try {
                registerNowButton = new ButtonElement(this.driver, LoginFormLocators.REGISTER_NOW_BOTTON);
            } catch (NoSuchElementException e) {
                return false;
            }
        }
        return true;
    }

    public RegisterFormPage(WebDriver driver) {
        super(driver);
    }
}
