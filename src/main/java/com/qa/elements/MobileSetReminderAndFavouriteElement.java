package com.qa.elements;

import com.qa.utils.ElementData;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * Created by sulari.dulsara on 1/7/2018 .
 */
public class MobileSetReminderAndFavouriteElement {

    public static AndroidElement setReminderIcon(AndroidDriver<AndroidElement> andDriver) throws Exception {
        AndroidElement locator = null;
        try {
            locator = andDriver.findElementById(ElementData.getSafeString("AssignmentThree_SetReminderIcon"));
        } catch (Exception e) {
           locator = null;
        }
        return locator;
    }

    public static AndroidElement OkBtn(AndroidDriver<AndroidElement> andDriver) throws Exception {
        AndroidElement locator = andDriver.findElementById(ElementData.getSafeString("AssignmentThree_OkBtn"));
        return locator;
    }

    public static AndroidElement favouriteIcon(AndroidDriver<AndroidElement> andDriver) throws Exception {
        AndroidElement locator = andDriver.findElementById(ElementData.getSafeString("AssignmentThree_FavouriteIcon"));
        return locator;
    }

    public static AndroidElement backBtn(AndroidDriver<AndroidElement> andDriver) throws Exception {
        AndroidElement locator = andDriver.findElementByXPath(ElementData.getSafeString("AssignmentThree_BackBtn"));
        return locator;
    }

    public static AndroidElement verifyFavouriteTab(AndroidDriver<AndroidElement> andDriver) throws Exception {
        AndroidElement locator = andDriver.findElementByXPath(ElementData.getSafeString("AssignmentThree_VerifyFavouriteTab"));
        return locator;
    }

    public static AndroidElement verifyFavouriteItemChanelId(AndroidDriver<AndroidElement> andDriver) throws Exception {
        AndroidElement locator = andDriver.findElementById(ElementData.getSafeString("AssignmentThree_VerifyFavouriteItemChanelId"));
        return locator;
    }

    public static AndroidElement verifyFavouriteItem(AndroidDriver<AndroidElement> andDriver) throws Exception {
        AndroidElement locator = andDriver.findElementByXPath(ElementData.getSafeString("AssignmentThree_VerifyFavouriteItem"));
        return locator;
    }

    public static AndroidElement verifyFavouriteEmpty(AndroidDriver<AndroidElement> andDriver) throws Exception {
        AndroidElement locator = andDriver.findElementById(ElementData.getSafeString("AssignmentThree_VerifyFavouriteEmpty"));
        return locator;
    }
}
