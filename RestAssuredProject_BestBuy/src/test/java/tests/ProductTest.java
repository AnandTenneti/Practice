package tests;

import com.aventstack.extentreports.Status;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.ITest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import request.RequestFactory;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ProductTest extends BaseTest {


    @Test
    public void verifyGetRequest() {
        extentReportUtils.createTestCase("Verify Get Product");
        Response response = requestFactory.getAllProducts();
        extentReportUtils.addLog(Status.INFO, response.asPrettyString());
                response.then().log().all().statusCode(200);
    }

    @Test
    public void verifyAddProduct() {
        extentReportUtils.createTestCase("Verify Add Product");
        String requestPayload = "{\n"
                + " \"name\":\"Samsung Mobile\",\n"
                + " \"type\":\"Mobile\",\n"
                + " \"price\":100,\n"
                + " \"shipping\":10,\n"
                + " \"upc\":\"Mobile\",\n"
                + " \"description\":\"Mobile\",\n"
                + " \"manufacturer\":\"Mobile\",\n"
                + " \"model\":\"Mobile\",\n"
                + " \"url\":\"string\",\n"
                + " \"image\":\"string\"\n"
                + "}";
       ValidatableResponse valResponse =  requestFactory.addProducts(requestPayload).then();
               extentReportUtils.addLog(Status.INFO,valResponse.log().all().toString());
                valResponse.statusCode(201);
    }

    @Test
    public void verifyAddProductWithRequestPayloadAsMap() {
        extentReportUtils.createTestCase("Verify Add Property using Map");
        Map<String, Object> requestPayLoad = new HashMap<>();
        requestPayLoad.put("name", "Samsung Mobile");
        requestPayLoad.put("type", "Mobile");
        requestPayLoad.put("price", 100);
        requestPayLoad.put("shipping", 10);
        requestPayLoad.put("upc", "string");
        requestPayLoad.put("description", "string");
        requestPayLoad.put("manufacturer", "string");
        requestPayLoad.put("model", "string");
        requestPayLoad.put("url", "string");
        requestPayLoad.put("image", "string");
        requestFactory.addProducts(requestPayLoad).then().log().all().statusCode(201);
//        int productId = given().contentType("application/json")
//                .body(request)
//                .when()
//                .post(uri + "/movie")
//                .then()
//                .assertThat()
//                .statusCode(HttpStatus.CREATED.value())
//                .extract()
    }

   // @Test
    public void verifyEndToEndCallFlow() {
        //Step 1: Create a Post request
        Map<String, Object> requestPayLoad = new HashMap<>();
        requestPayLoad.put("name", "Samsung Mobile");
        requestPayLoad.put("type", "Mobile");
        requestPayLoad.put("price", 100);
        requestPayLoad.put("shipping", 10);
        requestPayLoad.put("upc", "string");
        requestPayLoad.put("description", "string");
        requestPayLoad.put("manufacturer", "string");
        requestPayLoad.put("model", "string");
        requestPayLoad.put("url", "string");
        requestPayLoad.put("image", "string");
        Response response = requestFactory.addProducts(requestPayLoad);

        response.then().log().all().statusCode(201);

    }
}
