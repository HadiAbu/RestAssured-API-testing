package com.example;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;


public class NegativeTestCases {
    @Test
    public void testNotFound() {
        given()
            .baseUri("https://jsonplaceholder.typicode.com")
        .when()
            .get("/posts/9999999") // invalid ID
        .then()
            .statusCode(404);
    }
    @Test
    public void testServerError() {
        given()
            .baseUri("https://the-internet.herokuapp.com/status_codes")
            .header("Content-Type", "application/json")
            .body("{ \"badField\": \"invalidData\" }")
        .when()
            .get("/500")
        .then()
            .statusCode(500);
    }

    
}
