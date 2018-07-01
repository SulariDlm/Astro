package com.qa.app;

import com.qa.support.ImplicitWait;
import com.qa.utils.Configuration;
import com.qa.utils.ElementData;
import com.qa.utils.TestData;
import org.testng.TestNG;
import org.testng.collections.Lists;

import java.util.List;

/**
 * Created by sulari.dulsara on 27/6/2018 .
 */
public class Main {
    public static void main(String[] args) {
        //Test starting point
        boolean keepRunning = true;
        while (keepRunning) {
            try {
                Main main = new Main();
                main.startTest();
                //pause the program for 1 hour
                ImplicitWait.sleepFor(1000 * 60 * 60);
            } catch (Exception e) {
                keepRunning = false;
            }
        }
    }

    public void startTest() {

        TestNG testng = new TestNG();
        List<String> suites = Lists.newArrayList();

        //Load configuration data in to memory
        Configuration.Load("src" + "/" + "main" + "/" + "resources" + "/" + "conf.ini");
        //Load data required for testing in to memory
        TestData.Load("src" + "/" + "main" + "/" + "resources" + "/" + "test_data.ini");
        //Load element identification values in to memory
        ElementData.Load("src" + "/" + "main" + "/" + "resources" + "/" + "element_data.ini");
        //Load testcase senarios
        String testFile = "src" + "/" + "main" + "/" + "resources" + "/" + "testng.xml";

        //Run test scripts
        suites.add(testFile);
        testng.setTestSuites(suites);
        testng.run();
    }
}
