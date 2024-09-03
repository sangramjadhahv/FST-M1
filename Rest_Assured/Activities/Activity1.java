package activities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Activity1 {

    // Set base URL
    final static String ROOT_URI = "https://petstore.swagger.io/v2/pet";

    @Test(priority=1)
    public void addNewPet() {
        // Create JSON request
        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("id", 2039);
        reqBody.put("name", "Shifu");
        reqBody.put("status", "alive");

        Response response =
                given().contentType(ContentType.JSON)
                        .body(reqBody)
                        .when().post(ROOT_URI);

        // Assertion
        response.then().body("id", equalTo(2039));
        response.then().body("name", equalTo("Shifu"));
        response.then().body("status", equalTo("alive"));
    }

    @Test(priority=2)
    public void getPetInfo() {
        Response response =
                given().contentType(ContentType.JSON)
                        .when().pathParam("petId", "2039")
                        .get(ROOT_URI + "/{petId}");

        // Assertion
        response.then().body("id", equalTo(2039));
        response.then().body("name", equalTo("Shifu"));
        response.then().body("status", equalTo("alive"));
    }

    @Test(priority=3)
    public void deletePet() {
        Response response =
                given().contentType(ContentType.JSON)
                        .when().pathParam("petId", 2039)
                        .delete(ROOT_URI + "/{petId}");

        // Assertion
        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("2039"));
    }
}
