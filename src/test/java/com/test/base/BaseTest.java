package com.test.base;

import com.test.driver.DriverManager;
import com.test.reports.ExtentManager;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    protected Properties config;

    @BeforeSuite
    public void setupSuite() throws IOException {
        ExtentManager.initReports();
        config = new Properties();
        FileInputStream fis = new FileInputStream("src/main/resources/config.properties");
        config.load(fis);
    }

    @BeforeMethod
    public void setup(Object[] data, java.lang.reflect.Method method) {
        ExtentManager.createTest(method.getName());
        DriverManager.setDriver(config.getProperty("browser"));
        DriverManager.getDriver().get(config.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }

    @AfterSuite
    public void tearDownSuite() {
        ExtentManager.flushReports();
    }
}
