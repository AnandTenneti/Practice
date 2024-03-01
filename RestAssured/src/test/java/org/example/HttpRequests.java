package org.example;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class HttpRequests {

    int id;

    @Test
    public void getRequest() {
        RestAssured.baseURI = "https://reqres.in/api";
        basePath = "/users/2";
        RequestSpecification request = RestAssured.given();


        ////
        request.log().all()
                .queryParam("page",2)
                .header("Content-Type", "application/json")
                //When
                .when().log().all().get()
                // Then
                .then().log().all().assertThat().statusCode(200);
        JsonPath jsonPathObj = resp
    }

    @Test
    public void createNewUser() {
        RestAssured.baseURI = "https://reqres.in/api";
        basePath = "/users";
        HashMap<String, String> map = new HashMap<>();
        map.put("name","Anand");
        map.put("job","manager");
        RequestSpecification request = RestAssured.given();
        Response response = request.log().all()
                .contentType("application/json").body(map)
                .when().log().all().post();
        String responseBody = response.body().asString();
        System.out.println(responseBody);
        Integer statusCode = response.statusCode();
         id = response.jsonPath().getInt("id");
        System.out.println(id);
        //Assert.assertTrue(statusCode.equals(201));
        //Assert.assertTrue(responseBody.contains("Anand"));
    }
    @Test(priority=3, dependsOnMethods = {"createNewUser"})
    void updateUser() {
        RestAssured.baseURI = "https://reqres.in/api";
        basePath = "/users/";
        HashMap<String, String> map = new HashMap<>();
        map.put("name","Kiran2");
        map.put("job","manager-3");

                given().log().all()
                .contentType("application/json").body(map)
                .when().log().all().put(baseURI + basePath +id)
                        .then().log().all().assertThat().statusCode(200);
    }

    @Test(priority=4)
    void deleteUser() {
        RestAssured.baseURI = "https://reqres.in/api";
        basePath = "/users/";
                when().delete(baseURI + basePath +id)
                .then().log().all().assertThat().statusCode(204);
    }
}
