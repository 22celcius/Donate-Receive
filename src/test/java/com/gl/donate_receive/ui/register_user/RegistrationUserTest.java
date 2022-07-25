package com.gl.donate_receive.ui.register_user;

import com.gl.donate_receive.ui.BasicTest;
import com.gl.donate_receive_tests.pages.RegisterFormPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class RegistrationUserTest extends BasicTest {
    @AfterMethod
    private void close(){
        webDriver.close();
    }

    public RegisterFormPage userRegistrationWithValidData;
    @Test
    public void userRegistrationWithValidData() {
        userRegistrationWithValidData = new RegisterFormPage(webDriver)
                .clickRegisterNowButton()
                .setLogin("user1")
                .setPassword("user1")
                .clickRegisterButton();
        Assert.assertTrue(userRegistrationWithValidData.isRegisterNowButtonActive(), "User successfully registered");
    }
}
