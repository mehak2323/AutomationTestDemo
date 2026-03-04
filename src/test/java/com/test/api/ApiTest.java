package com.test.api;

import com.test.base.BaseTest;
import com.test.reports.ExtentManager;
import com.test.utils.ApiUtils;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiTest extends BaseTest {
    @Test
    public void testGetPosts() {
        Response response = ApiUtils.getRequest(config.getProperty("api_base_url") + "/posts/1", null);
        ExtentManager.getTest().info("Response Body: " + response.asString());
        Assert.assertEquals(response.getStatusCode(), 200, "Status code is not 200");
    }
}
