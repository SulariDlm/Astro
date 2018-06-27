package com.qa.support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * Created by sulari.dulsara on 27/6/2018 .
 */
public class ExplicitWait {
    static WebDriverWait wait ;
    public static WebElement elementToBeClickable(WebDriver driver, WebElement element, int waitFor) throws Exception {
        wait = new WebDriverWait(driver, waitFor);
        WebElement waitElement = wait.until(ExpectedConditions.elementToBeClickable(element));

        return (waitElement);
    }

    public static  WebElement visibilityOf(WebDriver driver,WebElement element) throws Exception{
        wait= new WebDriverWait(driver,30);
        WebElement waitElement = wait.until(ExpectedConditions.visibilityOf(element));

        return (waitElement);
    }

    public static WebElement visibilityOf(WebDriver driver,String s){
        WebElement standard =driver.findElement(By.partialLinkText(s));
        wait = new WebDriverWait(driver,30);
        WebElement waitElement = wait.until(ExpectedConditions.visibilityOf(standard));

        return (waitElement);

    }

    public static  void frameToBeAvailable(WebDriver driver,String s) throws Exception{
        wait= new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(s));

    }

}
