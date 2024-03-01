package org.example;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class Test {
    @Test
    public void getUsers() {
        Response response = RestAssured.given()..request(Method.GET)
        
    }
}
