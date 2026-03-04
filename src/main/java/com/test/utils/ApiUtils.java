package com.test.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.Map;

public class ApiUtils {
    public static Response getRequest(String endpoint, Map<String, String> headers) {
        RequestSpecification request = RestAssured.given();
        if (headers != null) {
            request.headers(headers);
        }
        return request.get(endpoint);
    }

    public static Response postRequest(String endpoint, Object body, Map<String, String> headers) {
        RequestSpecification request = RestAssured.given();
        if (headers != null) {
            request.headers(headers);
        }
        return request.body(body).post(endpoint);
    }
}
