package com.qa.support;


import com.qa.utils.Configuration;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Created by sulari.dulsara on 27/6/2018 .
 */
public class Report {

    private String reportName;
    private String reportPath;
    private ExtentReports extent;
    private static Report self;

    private  Report (){
       String datapattern = new SimpleDateFormat("yyyy_MM_dd-hh_mm_ss").format(new Date());
       reportName = Configuration.getSafeString("reportName")+"_"+datapattern+".html";
       reportPath = "./Reports/"+reportName;
       extent = new ExtentReports(reportPath);
       extent.addSystemInfo("Environment", Configuration.getSafeString("reportEnvironment"));
       extent.addSystemInfo("Created By", Configuration.getSafeString("reportOwner"));
    }

    public static Report getInstance() {
        if (self == null){
            self = new Report();
        }

        return (self);

    }

    public ExtentTest getReportTest(String name) {
        ExtentTest test;
        test = extent.startTest(name);
        return test;
    }

    public void endReportTest(ExtentTest test){
        extent.endTest(test);
    }

    public void flushReport(){

        extent.flush();
    }

    public String getReportName(){
        return reportName ;
    }

    public String getReportPath() {
        return reportPath;
    }
}
