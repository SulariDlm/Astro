package com.qa.elements;

import com.qa.utils.ElementData;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.time.Duration;

/**
 * Created by sulari.dulsara on 1/7/2018 .
 */
public class MobileSelectSecondContentElement {

    public static AndroidElement secondItem(AndroidDriver<AndroidElement> andDriver){
        AndroidElement locator = null;
        try {
            locator = andDriver.findElement(By.xpath(ElementData.getSafeString("AssignmentThree_SecondItem")));
        } catch (Exception e) {
            locator = null;
        }
        return locator;
    }

    public static AndroidElement secondItemChanelId(AndroidDriver<AndroidElement> andDriver) throws Exception {
        AndroidElement locator = andDriver.findElement(By.xpath(ElementData.getSafeString("AssignmentThree_SecondItemChanelId")));
        return locator;
    }

    public static AndroidElement expandArrow(AndroidDriver<AndroidElement> andDriver) throws Exception {
        AndroidElement locator = andDriver.findElement(By.id(ElementData.getSafeString("AssingnmentThree_ExpandArrow")));
        return locator;
    }

    public static AndroidElement synopsisTxt(AndroidDriver<AndroidElement> andDriver) throws Exception {
        AndroidElement locator = andDriver.findElement(By.id(ElementData.getSafeString("AssignmentThree_SynopsisTxt")));
        return locator;
    }

    public static AndroidElement searchBtn(AndroidDriver<AndroidElement> andDriver) throws Exception {
        AndroidElement locator = andDriver.findElement(By.xpath(ElementData.getSafeString("AssignmentThree_SearchBtn")));
        return locator;
    }


    public static void pageScrollUp(AndroidDriver<AndroidElement> driver) throws Exception {
        TouchAction ts = new TouchAction(driver);
        Dimension screenSize = driver.manage().window().getSize();
        ts.longPress(screenSize.getWidth()/2, (int) (screenSize.height * 0.9), Duration.ofSeconds(2)).moveTo(screenSize.getWidth()/2, (int) (screenSize.height * 0.1)).release().perform();

    }


    public static AndroidElement cancelBtn(AndroidDriver<AndroidElement> andDriver) throws Exception {
        AndroidElement locator = andDriver.findElementById(ElementData.getSafeString("AssignmentThree_CancelBtn"));
        return locator;
    }

}
