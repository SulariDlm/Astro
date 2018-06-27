package com.qa.support;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;
/**
 * Created by sulari.dulsara on 27/6/2018 .
 */
public class ImplicitWait {

    public static void waitFor(WebDriver driver,int time) throws Exception {

        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    public static void sleepFor(long time) throws Exception {

        Thread.sleep(time);
    }
}
