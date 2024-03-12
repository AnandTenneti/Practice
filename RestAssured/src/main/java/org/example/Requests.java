package org.example;


import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import io.restassured.RestAssured;

import java.util.List;

import static io.restassured.RestAssured.*;

public class Requests {
    @Test
    public void getUsers() {
        baseURI = "https://api.trello.com";
        RequestSpecification httpRequest = RestAssured.given();

       Response response =  httpRequest.queryParam("key", "3334fd229d5a4a6848f8f698ec05c474")
                .queryParam("token", "ATTA94b809cbce9648a047ce0fbf8a343b924d924bc6218c37930b0b44bc5cd8e470DDB45E2F")
                .header("Content-Type", "application/json").when().get("/1/members/me/boards");
       String responseBody = response.asString();
        System.out.println(responseBody);

        int id = response.then().contentType(ContentType.JSON).extract().;
        System.out.println(id);
       // List<String> ids = jsonPathObj.get("namw");




         //  System.out.println(ids);


    }



}
