package ru.netology.postman;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;



public class PostmanEchoTest {

    @Test
    void shouldReturnSendData() {
        given()
                .baseUri("https://postman-echo.com")
                .body("some data")
                .when().log().all()
                .post("/post")
                .then().log().all()
                .statusCode(200)
                .body("data", org.hamcrest.Matchers.equalTo("Hi"));
    }
}