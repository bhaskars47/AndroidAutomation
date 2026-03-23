package com.android.tests;

import com.android.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ConnectionTest extends BaseTest {

    @Test
    public void testDeviceConnection() {
        System.out.println("Verifying Device Connection...");
        Assert.assertNotNull(driver, "Driver should not be null after setup!");
        String platform = driver.getCapabilities().getCapability("platformName").toString();
        System.out.println("Connected to Platform: " + platform);
        Assert.assertEquals(platform.equalsIgnoreCase("android"), true, "Should be connected to an Android device");
    }
}
