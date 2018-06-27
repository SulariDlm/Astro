package com.qa.elements;

import com.qa.utils.ElementData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by sulari.dulsara on 27/6/2018 .
 */
public class AstroWebPageElement {

    public static WebElement pageVerificationAfter1Sec(WebDriver webDriver) throws Exception {
        WebElement locator = webDriver.findElement(By.xpath(ElementData.getSafeString("pageVerificationAfter1Sec")));
        return locator;
    }

    public static WebElement pageVerificationAfter5Sec(WebDriver webDriver) throws Exception {
        WebElement locator = webDriver.findElement(By.xpath(ElementData.getSafeString("pageVerificationAfter5Sec")));
        return locator;
    }

    public static WebElement pageFooter(WebDriver webDriver) throws Exception {
        WebElement locator = webDriver.findElement(By.xpath(ElementData.getSafeString("pageFooter")));
        return locator;
    }
}
