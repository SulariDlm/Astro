package com.qa.app;

import com.qa.support.ImplicitWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Created by sulari.dulsara on 27/6/2018 .
 */
public class WebDvr {
    private static WebDvr self;
    public static WebDriver webDriver;


    private WebDvr() throws Exception {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver_238.exe");
        webDriver = new ChromeDriver(chromeOptions);
        ImplicitWait.sleepFor(1000);
    }

    public static WebDvr getInstance() throws Exception {
        if (self == null){
            self = new WebDvr();
        }
        return self;
    }

    public org.openqa.selenium.WebDriver getDriver() {
        return webDriver;
    }
}
