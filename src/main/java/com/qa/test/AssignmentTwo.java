package com.qa.test;

import com.qa.app.WebDvr;
import com.qa.elements.WebPageElement;
import com.qa.entity.Item;
import com.qa.support.ImplicitWait;
import com.qa.support.Report;
import com.qa.utils.TestData;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by sulari.dulsara on 28/6/2018 .
 */
public class AssignmentTwo {
    private WebDriver webDriverAmz;
    private WebDriver webDriverLaz;
    private ExtentTest test;

    @BeforeClass
    public void setUp() throws Exception {
        webDriverAmz = WebDvr.getInstance().getDriver();
        webDriverLaz = WebDvr.getInstance().getDriver();
    }

    @AfterClass
    public void tearDown() throws Exception {
        ImplicitWait.sleepFor(1000);
        webDriverAmz.close();
        ImplicitWait.sleepFor(1000);
        webDriverLaz.close();
    }

    @AfterMethod
    public void getResult() throws Exception {

    }

    @Test(priority = 0)
    public void pageLoad() throws Exception {
        //Create test report and add test case to the report
        test = Report.getInstance().getReportTest("AssignmentTwo.pageLoad");
        //Page open
        try {
            webDriverAmz.get(TestData.getSafeString("AssignmentTwo_AmazonURL"));
            test.log(LogStatus.PASS, TestData.getSafeString("AssignmentTwo_AmazonURL") + " load success");
        } catch (Exception e) {
            test.log(LogStatus.FAIL, TestData.getSafeString("AssignmentTwo_AmazonURL") + " load failed");
        }
        ImplicitWait.sleepFor(2000);
        try {
            webDriverLaz.get(TestData.getSafeString("AssignmentTwo_LazURL"));
            test.log(LogStatus.PASS, TestData.getSafeString("AssignmentTwo_LazURL") + " load success");
        } catch (Exception e) {
            test.log(LogStatus.FAIL, TestData.getSafeString("AssignmentTwo_LazURL") + " load failed");
        }
        Report.getInstance().endReportTest(test);
    }

    @Test(priority = 1)
    public void search() {
        //Create test report and add test case to the report
        test = Report.getInstance().getReportTest("AssignmentTwo.search");
       //Search in Amazon
        try {
            WebPageElement.amazonSearchTxt(webDriverAmz).sendKeys(TestData.getSafeString("AssignmentTwo_SearchKey"));
            WebPageElement.amazonSearchBtn(webDriverAmz).click();
            Assert.assertEquals(WebPageElement.amazonSearchVerify(webDriverAmz).getText(), "\"iPhone 7\"");
            test.log(LogStatus.PASS, TestData.getSafeString("AssignmentTwo_AmazonURL") + " keyword search success");
        } catch (Exception e) {
            test.log(LogStatus.FAIL, TestData.getSafeString("AssignmentTwo_AmazonURL") + " keyword search failed");
        }

        //Search in lazada
        try {
            WebPageElement.lazSearchTxt(webDriverLaz).sendKeys(TestData.getSafeString("AssignmentTwo_SearchKey"));
            WebPageElement.lazSearchBtn(webDriverLaz).click();
            Assert.assertEquals(WebPageElement.lazSearchVerify(webDriverLaz).getText(), "iPhone 7");
            test.log(LogStatus.PASS, TestData.getSafeString("AssignmentTwo_LazURL") + " keyword search success");
        } catch (Exception e) {
            test.log(LogStatus.FAIL, TestData.getSafeString("AssignmentTwo_LazURL") + " keyword search failed");
        }


        Report.getInstance().endReportTest(test);
    }
    @Test(priority = 2)
    public void priceSort() throws Exception {
        //Create test report and add test case to the report
        test = Report.getInstance().getReportTest("AssignmentTwo.priceSort");
        //Search result of items in laz
        List<WebElement> lazElements = webDriverLaz.findElements(By.className("c2prKC"));
        int count = 0;
        List<Item> itemList = new ArrayList<>();
        for (WebElement e: lazElements) {
            try {
                Item item = new Item();
                //Search result for detail link
                item.setLink(e.findElement(By.cssSelector("a")).getAttribute("href"));

                //Search result of name of the product
                item.setName(e.findElement(By.className("c16H9d")).getText());

                //Search result for price of the product
                String value = e.findElement(By.className("c13VH6")).getText();
                String[] arr = value.split("M");
                double price = Double.valueOf(arr[1].replaceAll(",",""));
                item.setPrice(price);

                //set Website
                item.setWebSite(TestData.getSafeString("AssignmentTwo_AmazonURL"));
                //System.out.println(item.toString());
                itemList.add(item);


            } catch (Exception e1) {
                test.log(LogStatus.SKIP, TestData.getSafeString("AssignmentTwo_AmazonURL") + " broken search item found");
            }
        }

        //Search result of items Amazan
        List<WebElement> amzElements = webDriverAmz.findElements(By.className("s-item-container"));
        count = 0;
        for (WebElement e: amzElements)
        {
            try {
                Item item = new Item();

                //Search result of display Link
                item.setLink(e.findElement(By.cssSelector("a")).getAttribute("href"));

                //Search result of item name
                item.setName (e.findElement(By.cssSelector("h2")).getAttribute("data-attribute"));

                //Search result of price
                String fullVal = null;
                String currency = null;
                int currencyRate = 1;
                try {
                    currency = e.findElement(By.className("sx-price-currency")).getText();
                    if(currency.equalsIgnoreCase("$")){
                        currencyRate = 4;
                    }
                    fullVal = e.findElement(By.className("sx-price-whole")).getText().replaceAll(",", "")+ "." + e.findElement(By.className("sx-price-fractional")).getText();
                } catch (Exception e1) {
                    currency = e.findElement(By.className("a-size-base")).getText().substring(0,1);
                    if(currency.equalsIgnoreCase("$")){
                        currencyRate = 4;
                    }
                    fullVal = e.findElement(By.className("a-size-base")).getText().substring(1).replaceAll(",", "");
                }
                double price = Double.valueOf(fullVal) * currencyRate;
                item.setPrice(price);

                //set Website
                item.setWebSite(TestData.getSafeString("AssignmentTwo_LazURL"));
                //System.out.println(item.toString());
                itemList.add(item);

            } catch (Exception e1) {
                test.log(LogStatus.SKIP, TestData.getSafeString("AssignmentTwo_LazURL") + " broken search item found");
            }
        }

        Collections.sort(itemList);
        for (Item item: itemList) {
            test.log(LogStatus.INFO, item.toString());
        }
        Report.getInstance().endReportTest(test);
    }


}
