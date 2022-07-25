package com.gl.donate_receive_tests.tools;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class WaitSwitcher {
    private WebDriver driver;

    public WaitSwitcher(WebDriver webDriver) {
        this.driver = webDriver;
    }
    public void setImplicitWaits(int seconds){
        if (seconds > 0) {
            driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
        }
    }

    public static void sleep(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
