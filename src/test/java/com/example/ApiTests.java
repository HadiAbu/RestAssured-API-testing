package com.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiTests {

    @Test
    public void testGetPost() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        Response response = RestAssured.given()
                .when().get("/posts/1")
                .then().extract().response();

        // Validate status code
        Assert.assertEquals(response.statusCode(), 200);

        // Validate header
        Assert.assertEquals(response.header("Content-Type"), "application/json; charset=utf-8");

        // Validate JSON field
        String title = response.jsonPath().getString("title");
        Assert.assertTrue(title.contains("sunt aut facere"));
    }
}
