package com.qa.app;

import com.qa.utils.Configuration;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by sulari.dulsara on 30/6/2018 .
 */
public class AndroidDvr {
    private static AndroidDvr self;
    private AndroidDriver<AndroidElement> driver;

    private AndroidDvr() throws Exception {
        DesiredCapabilities ceps = new DesiredCapabilities();
        File apkDir = new File(Configuration.getSafeString("APK_PATH"));

        //Change resources/conf.ini accordingly
        ceps.setCapability(MobileCapabilityType.PLATFORM, Configuration.getSafeString("PLATFORM"));
        ceps.setCapability(MobileCapabilityType.PLATFORM_NAME, Configuration.getSafeString("PLATFORM_NAME"));
        ceps.setCapability(MobileCapabilityType.DEVICE_NAME, Configuration.getSafeString("DEVICE_NAME"));
        ceps.setCapability(MobileCapabilityType.VERSION, Configuration.getSafeString("VERSION"));
        ceps.setCapability(MobileCapabilityType.APP, apkDir.getAbsolutePath());
        ceps.setCapability("noReset", Configuration.getSafeString("NO_REST"));
        ceps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, Configuration.getSafeString("APP_PACKAGE"));
        ceps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, Configuration.getSafeString("APP_ACTIVITY"));
        ceps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, Configuration.getIntSafe("NEW_COMMAND_TIMEOUT"));
        ceps.setCapability(MobileCapabilityType.AUTOMATION_NAME, Configuration.getSafeString("AUTOMATION_NAME"));

        URL url = new URL(Configuration.getSafeString("APPIUM_URL"));
        driver = new AndroidDriver<AndroidElement>(url,ceps);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public static AndroidDvr getInstance() throws Exception {
        if (self == null){
            self = new AndroidDvr();
        }
        return self;
    }

    public AndroidDriver<AndroidElement> getDriver() {
        return driver;
    }

}
