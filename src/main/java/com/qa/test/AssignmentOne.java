package com.qa.test;

import com.qa.app.WebDvr;
import com.qa.elements.AstroWebPageElement;
import com.qa.support.*;
import com.qa.utils.TestData;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by sulari.dulsara on 27/6/2018 .
 */
public class AssignmentOne {
    WebDriver webDriver;
    ExtentTest test;


    @BeforeClass
    public void setUp() throws Exception {
        webDriver = WebDvr.getInstance().getDriver();

    }

    @AfterClass
    public void tearDown() throws Exception {
        ImplicitWait.sleepFor(1000);
    }

    @AfterMethod
    public void getResult() throws Exception {
        ImplicitWait.waitFor(webDriver, 5);

    }

    @Test(priority = 0)
    public void pageLoad() {
        //Create test report and add test case to the report
        test = Report.getInstance().getReportTest("AssignmentOne.pageLoad");
        webDriver.get(TestData.getSafeString("AstroURL"));

        try {
            //Wait one second until page load and click on Continue to Astro
            ExplicitWait.elementToBeClickable(webDriver, AstroWebPageElement.pageVerificationAfter1Sec(webDriver), 1).click();
            //Add pass entry to test report
            test.log(LogStatus.PASS, "Page load success within 1 second");
        } catch (Exception e) {
            //Add fail entry to test report
            test.log(LogStatus.FAIL, "Page load failed within 1 second");
            //If above click failed wait for 30 seconds to click on Continue to Astro
            try {
                ExplicitWait.elementToBeClickable(webDriver, AstroWebPageElement.pageVerificationAfter1Sec(webDriver), 30).click();
            } catch (Exception e1) {
                test.log(LogStatus.FAIL, "Page load failed within 30 second");
            }

        }

        try {
            //Wait five second until page load and click on Continue to Astro
            ExplicitWait.elementToBeClickable(webDriver, AstroWebPageElement.pageVerificationAfter5Sec(webDriver), 5).click();
            //Add pass entry to test report
            test.log(LogStatus.PASS, "Main Page load success within 5 second");
        } catch (Exception e) {
            //Add fail entry to test report
            test.log(LogStatus.FAIL, "Main Page load failed within 5 second");
            //If above click failed wait for 30 seconds to click on Continue to Astro
            try {
                ExplicitWait.elementToBeClickable(webDriver, AstroWebPageElement.pageVerificationAfter5Sec(webDriver), 30).click();
            } catch (Exception e1) {
                test.log(LogStatus.FAIL, "Main Page load failed within 30 second");
            }

        }

        try {
            //Verify page loaded completly
            String footer = AstroWebPageElement.pageFooter(webDriver).getText();
            String expected = "Copyright © 2018. Measat Broadcast Network Systems Sdn Bhd (240064-A). All Rights Reserved.";
            Assert.assertEquals(expected, footer);
            //Add pass entry to test report
            test.log(LogStatus.PASS, "Main Page completely loaded success within 5 second");
        } catch (Exception e) {
            //Add fail entry to test report
            test.log(LogStatus.FAIL, "Main Page completely loaded failed within 5 second");
            //If above click failed wait for 30 seconds to click on Continue to Astro
            try {
                ExplicitWait.elementToBeClickable(webDriver, AstroWebPageElement.pageVerificationAfter5Sec(webDriver), 30).click();
            } catch (Exception e1) {
                test.log(LogStatus.FAIL, "Main Page completely loaded failed within 30 second");
            }

        }
        Report.getInstance().endReportTest(test);
    }

    @Test(priority = 1)
    public void verifyLinks() {
        //Add test case to the report
        test = Report.getInstance().getReportTest("AssignmentOne.verifyLinks");

        try {
            List<WebElement> links = webDriver.findElements(By.cssSelector("a"));
            String href;
            for (WebElement link : links) {
                href = link.getAttribute("href");
                if(href == null){
                    continue;
                }
                Stopwatch timer = new Stopwatch();
                int statusCode = 0;
                try {
                    statusCode = HttpResponseCode.httpResponseCodeViaGet(href);
                    test.log(LogStatus.INFO, href + " gave a response code of " + statusCode + " with response time of : " + timer.elapsedTime() + " sec");
                } catch (Exception e) {
                    test.log(LogStatus.WARNING, href + " gave a response code of " + statusCode + " with response time of : " + timer.elapsedTime() + " sec");
                }

            }
        } catch (Exception e) {
            test.log(LogStatus.FAIL, "Links verify failed");
        }
        Report.getInstance().endReportTest(test);

    }
}
