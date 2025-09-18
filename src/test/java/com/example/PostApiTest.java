package com.example;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostApiTest {

    @Test
    public void testCreatePost() {
        given()
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
