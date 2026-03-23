package com.android.base;

import com.android.utils.PropertyUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

@Listeners(com.android.utils.TestListener.class)
public class BaseTest {
    protected AppiumDriver driver;

    public AppiumDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void setup() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName(PropertyUtils.getProperty("platform.name"))
                .setAutomationName(PropertyUtils.getProperty("automation.name"))
                .setDeviceName(PropertyUtils.getProperty("device.name"))
                .setApp(System.getProperty("user.dir") + "/" + PropertyUtils.getProperty("app.path"))
                .setAppPackage(PropertyUtils.getProperty("app.package"))
                .setAppActivity(PropertyUtils.getProperty("app.activity"))
                .setNoReset(false);

        driver = new AndroidDriver(new URL(PropertyUtils.getProperty("appium.url")), options);
        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(Long.parseLong(PropertyUtils.getProperty("implicit.wait"))));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
