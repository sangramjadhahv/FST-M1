package liveProject;

import static org.hamcrest.Matchers.lessThanOrEqualTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GitHub_RestAssured_Project_Test {

	String sshKey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAICRFWmGg4sWPjhG4h19cEDEcNJqsvDYnzMTiLYQ6karM";
	int sshKeyId;
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	
	@BeforeClass
	public void setup() {
		
		//RequestSpecification
		requestSpec = new RequestSpecBuilder().
				setBaseUri("https://api.github.com").
				addHeader("Authorization","token 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").
				addHeader("Content-Type","application/json").
				build();
		
		//Response Specification
		responseSpec = new ResponseSpecBuilder().
				expectResponseTime(lessThanOrEqualTo(4000L)).
				build();
		
	}
	
	@Test(priority=1)
	public void postRequest() {
		
		//Create request body
				Map<String,Object> reqBody = new HashMap<String,Object>();
				reqBody.put("title", "TestAPIKey");
				reqBody.put("key",sshKey);
				Response response = given().spec(requestSpec).body(reqBody).when().post("/user/keys");
				response.prettyPrint();
			//extract the key 
				sshKeyId = response.then().extract().path("id");
				int responseCode = response.getStatusCode();
				//assertion
				Assert.assertEquals(responseCode, 201);
	}
	
	@Test(priority = 2)
	public void getRequest() {
		Response  response = given().spec(requestSpec).pathParam("keyId", sshKeyId).log().all()
				.when().get("/user/keys/{keyId}");
		int responseCode = response.getStatusCode();
		Assert.assertEquals(responseCode,200);
	}
	
	@Test(priority = 3)
	public void deleteRequest() {
		given().spec(requestSpec).pathParam("keyId",sshKeyId).when().delete("/user/keys/{keyId}").
		then().spec(responseSpec).body("message",equalTo("" + sshKeyId));
	}
}