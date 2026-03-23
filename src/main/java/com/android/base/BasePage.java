package com.android.base;

import com.android.utils.CommonActions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class BasePage {
    protected AppiumDriver driver;
    protected CommonActions actions;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        this.actions = new CommonActions(driver);
        // Initialize Appium Elements with PageFactory
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }
}
