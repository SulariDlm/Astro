package com.qa.elements;

import com.qa.utils.ElementData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by sulari.dulsara on 27/6/2018 .
 */
public class WebPageElement {

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

    public static List<WebElement> getHyperLinks(WebDriver webDriver) throws Exception {
        List<WebElement> links = webDriver.findElements(By.cssSelector("a"));
        return links;
    }

    public static WebElement amazonSearchTxt(WebDriver webDriver) throws Exception {
        WebElement locator = webDriver.findElement(By.xpath(ElementData.getSafeString("AssignmentTwo_AmazonSearchTxt")));
        return locator;
    }

    public static WebElement amazonSearchBtn(WebDriver webDriver) throws Exception {
        WebElement locator = webDriver.findElement(By.xpath(ElementData.getSafeString("AssignmentTwo_AmazonSearchBtn")));
        return locator;
    }

    public static WebElement amazonSearchVerify(WebDriver webDriver) throws Exception {
        WebElement locator = webDriver.findElement(By.xpath(ElementData.getSafeString("AssignmentTwo_AmazonSearchVerify")));
        return locator;
    }

    public static WebElement lazSearchTxt(WebDriver webDriver) throws Exception {
        WebElement locator = webDriver.findElement(By.xpath(ElementData.getSafeString("AssignmentTwo_LazSearchTxt")));
        return locator;
    }

    public static WebElement lazSearchBtn(WebDriver webDriver) throws Exception {
        WebElement locator = webDriver.findElement(By.xpath(ElementData.getSafeString("AssignmentTwo_LazSearchBtn")));
        return locator;
    }

    public static WebElement lazSearchVerify(WebDriver webDriver) throws Exception {
        WebElement locator = webDriver.findElement(By.xpath(ElementData.getSafeString("AssignmentTwo_LazSearchVerify")));
        return locator;
    }
}
