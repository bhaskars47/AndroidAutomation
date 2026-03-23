package com.android.tests;

import com.android.base.BaseTest;
import com.android.pages.AppStartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppStartTest extends BaseTest {

    @Test
    public void testAppLaunchAndVisibility() {
        System.out.println("Starting test: testAppLaunchAndVisibility");

        // Initialize Page Object
        AppStartPage startPage = new AppStartPage(driver);

        // Validation logic
        boolean isVisible = startPage.isHeaderVisible();
        Assert.assertTrue(isVisible, "The onboarding header subtitle should be visible on app launch.");

        // Test Interaction
        startPage.enterMobileNumber("9999999999");

        System.out.println("App launched successfully and interactions are working!");
    }
}
