package com.qa.test;

import com.qa.app.AndroidDvr;
import com.qa.elements.MobileLoginElement;
import com.qa.elements.MobileSelectSecondContentElement;
import com.qa.elements.MobileSetReminderAndFavouriteElement;
import com.qa.support.ImplicitWait;
import com.qa.support.Report;
import com.qa.utils.TestData;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



/**
 * Created by sulari.dulsara on 30/6/2018 .
 */
public class AssignmentThree {
    AndroidDriver<AndroidElement> driver;
    ExtentTest test;
    private String secondItemChanelId;

    @BeforeClass
    public void setUp() throws Exception {
        driver = AndroidDvr.getInstance().getDriver();

    }

    @AfterClass
    public void tearDown() throws Exception {
        ImplicitWait.sleepFor(1000);
    }

    @AfterMethod
    public void getResult() throws Exception {
        ImplicitWait.waitFor(driver, 5);
    }

    @Test(priority = 0)
    public void login() throws Exception {
        test = Report.getInstance().getReportTest("AssignmentThree.login");

        ImplicitWait.sleepFor(10000);
        TouchAction act = new TouchAction(driver);
        for (int i = 0; i < 4; i++) {
            MobileLoginElement.PageSwipeLeft(driver, act);
            ImplicitWait.sleepFor(1000);
        }

        try {
            MobileLoginElement.firstLoginBtn(driver).click();
            ImplicitWait.sleepFor(5000);
            MobileLoginElement.usernameTxt(driver).click();
            ImplicitWait.waitFor(driver, 1);
            MobileLoginElement.usernameTxt(driver).sendKeys(TestData.getSafeString("AssignmentThree_username"));
            ImplicitWait.waitFor(driver, 1);
            MobileLoginElement.passwordTxt(driver).click();
            ImplicitWait.waitFor(driver, 1);
            MobileLoginElement.passwordTxt(driver).sendKeys(TestData.getSafeString("AssignmentThree_password"));
            driver.hideKeyboard();
            ImplicitWait.waitFor(driver, 1);
            MobileLoginElement.loginBtn(driver).click();
            ImplicitWait.sleepFor(3000);
            MobileLoginElement.firstNotNowBtn(driver).click();
            ImplicitWait.sleepFor(1000);
            MobileLoginElement.secondNotNowBtn(driver).click();
            ImplicitWait.sleepFor(1000);
            MobileLoginElement.gotItBtn(driver).click();
            ImplicitWait.sleepFor(3000);
            MobileLoginElement.agreeBtn(driver).click();
            ImplicitWait.sleepFor(1000);
            MobileLoginElement.poupClose(driver).click();
            ImplicitWait.sleepFor(1000);
            test.log(LogStatus.PASS, "login success");
        } catch (Exception e) {
            test.log(LogStatus.FAIL, "login");
            test.log(LogStatus.INFO, "Error in test login : "+ e.getMessage());
        }
        Report.getInstance().endReportTest(test);
    }

        @Test(priority = 1)
        public void selectSecondContent() throws Exception {
            test = Report.getInstance().getReportTest("AssignmentThree.selectSecondContent");
            try {
                MobileSelectSecondContentElement.pageScrollUp(driver);
                ImplicitWait.sleepFor(5000);
                if (MobileSelectSecondContentElement.secondItem(driver) != null) {
                    secondItemChanelId = MobileSelectSecondContentElement.secondItemChanelId(driver).getText();
                    MobileSelectSecondContentElement.secondItem(driver).click();

                } else {
                    //To loar items
                    ImplicitWait.sleepFor(1000);
                    MobileSelectSecondContentElement.searchBtn(driver).click();
                    ImplicitWait.sleepFor(1000);
                    MobileSelectSecondContentElement.cancelBtn(driver).click();
                    //Clcik on secon item
                    ImplicitWait.sleepFor(3000);
                    secondItemChanelId = MobileSelectSecondContentElement.secondItemChanelId(driver).getText();
                    MobileSelectSecondContentElement.secondItem(driver).click();
                }
                test.log(LogStatus.PASS, "SelectSecondContent success");
            } catch (Exception e) {
                test.log(LogStatus.FAIL, "SelectSecondContent failed");
                test.log(LogStatus.INFO, "Error in test SelectSecondContent : "+ e.getMessage());
            }
            Report.getInstance().endReportTest(test);
        }

    @Test(priority = 2)
    public void synopsisCharacterLength() throws Exception {
        test = Report.getInstance().getReportTest("AssignmentThree.synopsisCharacterLength");
        try {
            ImplicitWait.sleepFor(3000);
            MobileSelectSecondContentElement.expandArrow(driver).click();
            ImplicitWait.sleepFor(1000);

            String synopsis = MobileSelectSecondContentElement.synopsisTxt(driver).getText();
            synopsis = synopsis.trim();
            if (synopsis.length() > 50) {
                test.log(LogStatus.INFO, "Synopsis got more than 50 characters");
            } else {
                test.log(LogStatus.WARNING, "Synopsis got less than 50 characters");
            }
        } catch (Exception e) {
            test.log(LogStatus.FAIL, "synopsisCharacterLength check failed");
            test.log(LogStatus.INFO, "Error in test synopsisCharacterLength : " + e.getMessage());
        }

        Report.getInstance().endReportTest(test);
    }

    @Test(priority = 3)
    public void setReminderAndAddToFavourite() throws Exception {
        test = Report.getInstance().getReportTest("AssignmentThree.setReminderAndAddToFavourite");
        try {
            //Set reminder
            if (MobileSetReminderAndFavouriteElement.setReminderIcon(driver) != null){
                MobileSetReminderAndFavouriteElement.setReminderIcon(driver).click();
                ImplicitWait.sleepFor(1000);
                MobileSetReminderAndFavouriteElement.OkBtn(driver);
                test.log(LogStatus.PASS, "Set reminder pass");
            }else {
                test.log(LogStatus.FAIL, "Set reminder fail due to show time is past");
            }
            ImplicitWait.sleepFor(2000);

            //Add to favourite
            MobileSetReminderAndFavouriteElement.favouriteIcon(driver).click();
            ImplicitWait.sleepFor(1000);
            MobileSetReminderAndFavouriteElement.backBtn(driver).click();
            ImplicitWait.sleepFor(3000);

            //Go to favourite
            MobileSetReminderAndFavouriteElement.verifyFavouriteTab(driver).click();
            ImplicitWait.sleepFor(5000);

            //Verify favourite
            try {
                Assert.assertEquals(MobileSetReminderAndFavouriteElement.verifyFavouriteItemChanelId(driver).getText(),secondItemChanelId);
                test.log(LogStatus.PASS,"Add to favourite success. Show available in favourite");
            } catch (Exception e) {
                test.log(LogStatus.FAIL,"Add to favourite fail. Show not available in favourite");
            }

            //Remove from favourite
            MobileSetReminderAndFavouriteElement.verifyFavouriteItem(driver).click();
            MobileSetReminderAndFavouriteElement.favouriteIcon(driver).click();

            //Verify favourite that show is not available
            MobileSetReminderAndFavouriteElement.backBtn(driver).click();
            ImplicitWait.sleepFor(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Assert.assertEquals(MobileSetReminderAndFavouriteElement.verifyFavouriteEmpty(driver).getText(),"THERE ARE NO FAVOURITES");
            test.log(LogStatus.PASS,"Remove from favourite success. Show not available in favourite");
        } catch (Exception e) {
            test.log(LogStatus.FAIL,"Remove from favourite fail. Show available in favourite");
        }


        Report.getInstance().endReportTest(test);
    }



}
