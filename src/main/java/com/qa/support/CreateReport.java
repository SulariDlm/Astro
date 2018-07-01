package com.qa.support;

import com.qa.app.WebDvr;
import org.testng.annotations.AfterSuite;

public class CreateReport {
    @AfterSuite
    public void flushReport() {
        try {
            Report.getInstance().flushReport();
            ImplicitWait.sleepFor(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
