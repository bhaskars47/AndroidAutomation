package com.android.pages;

import com.android.base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class AppStartPage extends BasePage {

    // Locators - Extracted from actual app source
    @AndroidFindBy(xpath = "//*[@resource-id='onboarding_header_subtitle']")
    private WebElement headerSubtitle;

    @AndroidFindBy(xpath = "//*[@resource-id='text_inputField']")
    private WebElement mobileNumberInput;

    @AndroidFindBy(accessibility = "Sign in")
    private WebElement signInButton;

    public AppStartPage(AppiumDriver driver) {
        super(driver);
    }

    // Page Actions
    public boolean isHeaderVisible() {
        return actions.isElementDisplayed(headerSubtitle);
    }

    public void enterMobileNumber(String number) {
        System.out.println("Entering mobile number...");
        actions.type(mobileNumberInput, number);
    }

    public void clickSignIn() {
        System.out.println("Clicking 'Sign in' button...");
        actions.click(signInButton);
    }
}
