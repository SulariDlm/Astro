package com.qa.elements;

import com.qa.utils.ElementData;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

/**
 * Created by sulari.dulsara on 30/6/2018 .
 */
public class MobileLoginElement {
    public static AndroidElement usernameTxt(AndroidDriver<AndroidElement> andDriver) throws Exception {
        AndroidElement locator = andDriver.findElement(By.xpath(ElementData.getSafeString("AssignmentThree_Login_UserNameTxt")));
        return locator;
    }

    public static AndroidElement passwordTxt(AndroidDriver<AndroidElement> andDriver) throws Exception {
        AndroidElement locator = andDriver.findElement(By.xpath(ElementData.getSafeString("AssignmentThree_Login_PasswordTxt")));
        return locator;
    }

    public static AndroidElement firstLoginBtn(AndroidDriver<AndroidElement> andDriver) throws Exception {
        AndroidElement locator = andDriver.findElement(By.id(ElementData.getSafeString("AssignmentThree_FirstLoginBtn")));
        return locator;
    }

    public static AndroidElement loginBtn(AndroidDriver<AndroidElement> andDriver) throws Exception {
        AndroidElement locator = andDriver.findElement(By.xpath(ElementData.getSafeString("AssignmentThree_LoginBtn")));
        return locator;
    }

    public static AndroidElement firstNotNowBtn(AndroidDriver<AndroidElement> andDriver) throws Exception {
        AndroidElement locator = andDriver.findElement(By.xpath(ElementData.getSafeString("AssignmentThree_FirstNotNowBtn")));
        return locator;
    }

    public static AndroidElement secondNotNowBtn(AndroidDriver<AndroidElement> andDriver) throws Exception {
        AndroidElement locator = andDriver.findElement(By.xpath(ElementData.getSafeString("AssignmentThree_SecondNotNowBtn")));
        return locator;
    }

    public static AndroidElement gotItBtn(AndroidDriver<AndroidElement> andDriver) throws Exception {
        AndroidElement locator = andDriver.findElement(By.xpath(ElementData.getSafeString("AssignmentThree_GotItBtn")));
        return locator;
    }

    public static AndroidElement agreeBtn(AndroidDriver<AndroidElement> andDriver) throws Exception {
        AndroidElement locator = andDriver.findElement(By.id(ElementData.getSafeString("AssignmentThree_AgreeBtn")));
        return locator;
    }

    public static AndroidElement poupClose(AndroidDriver<AndroidElement> andDriver) throws Exception {
        AndroidElement locator = andDriver.findElement(By.id(ElementData.getSafeString("AssignmentThree_PopupClose")));
        return locator;
    }

    public static void PageSwipeLeft(AndroidDriver<AndroidElement> driver, TouchAction act) throws Exception {
        Dimension screenSize = driver.manage().window().getSize();
        act.longPress((int) (screenSize.getWidth() * 0.9), screenSize.getHeight()/2, Duration.ofSeconds(1)).moveTo((int) (screenSize.getWidth() * 0.1), screenSize.getHeight()/2).release().perform();
    }
}

