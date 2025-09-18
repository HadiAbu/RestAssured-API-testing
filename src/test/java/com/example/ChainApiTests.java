package com.example;

import io.restassured.RestAssured;
import io.restassured.response.Response;
// import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ChainApiTests {

    @Test(enabled = false)
    public void testChainRequests() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Step 1: Create a new post
        Response postResponse =
            given()
                .header("Content-Type", "application/json")
                .body("{ \"title\": \"Chained Test\", \"body\": \"Hello World\", \"userId\": 10 }")
            .when()
                .post("/posts")
            .then()
                .statusCode(201)
                .extract().response();

        int newId = postResponse.jsonPath().getInt("id");
        System.out.println("Created post with ID: " + newId);

        // Step 2: Use the ID in a GET request
        given()
            .when().get("/posts/" + newId)
            .then()
            .statusCode(200)
            .body("id", equalTo(newId))
            .body("title", equalTo("Chained Test"));
    }
}
