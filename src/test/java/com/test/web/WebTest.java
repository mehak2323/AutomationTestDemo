package com.test.web;

import com.test.base.BaseTest;
import com.test.driver.DriverManager;
import com.test.reports.ExtentManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebTest extends BaseTest {
    @Test
    public void testGoogleSearch() {
        String title = DriverManager.getDriver().getTitle();
        ExtentManager.getTest().info("Page title is: " + title);
        Assert.assertTrue(title.contains("Google"), "Title does not contain Google");
    }
}
