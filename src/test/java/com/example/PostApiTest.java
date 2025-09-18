package com.example;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

public class PostApiTest {

    @Test
    public void testCreatePost() {
        RestAssured.given()
            .baseUri("https://jsonplaceholder.typicode.com")
            .header("Content-Type", "application/json")
            .body("{ \"title\": \"Automation Test\", \"body\": \"RestAssured Rocks!\", \"userId\": 1 }")
        .when()
            .post("/posts")
        .then()
            .statusCode(201)
            .body("title", equalTo("Automation Test"))
            .body("userId", equalTo(1));
    }
}
