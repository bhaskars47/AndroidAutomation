package com.android.utils;

import com.android.base.BaseTest;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Attachment(value = "Page Screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(AppiumDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public String saveTextLog(String message) {
        return message;
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed. Capturing screenshot for Allure...");
        Object testClass = result.getInstance();
        if (testClass instanceof BaseTest) {
            AppiumDriver driver = ((BaseTest) testClass).getDriver();
            if (driver != null) {
                saveScreenshotPNG(driver);
                saveTextLog(result.getMethod().getConstructorOrMethod().getName() + " failed.");
            }
        }
    }
}
