package com.qa.app;

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
        Main main = new Main();
        main.startTest();
    }

    public void startTest(){

        TestNG testng = new TestNG();
        List<String> suites = Lists.newArrayList();

        //Load configuration data in to memory
        Configuration.Load("src"+ "/"+"main"+"/"+"resources"+"/"+"conf.ini");
        //Load data required for testing in to memory
        TestData.Load("src"+ "/"+"main"+"/"+"resources"+"/"+"test_data.ini");
        //Load element identification values in to memory
        ElementData.Load("src"+ "/"+"main"+"/"+"resources"+"/"+"element_data.ini");
        //Load testcase senarios
        String testFile = "src"+ "/"+"main"+"/"+"resources"+"/"+"testng.xml";

        //Run test scripts
        suites.add(testFile);
        testng.setTestSuites(suites);
        testng.run();
    }
}
