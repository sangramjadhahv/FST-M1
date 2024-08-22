package Project;

import static io.restassured.RestAssured.given;
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

public class RestAssuresProject {
	RequestSpecification RequestSpec;
	ResponseSpecification ResponseSpec;
	String SSH_Key = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIFCcNUKmH83DWh/HpdRIgMMze1oq4/hY6qRW1gMdcoJ0";
	int SSH_Key_id;

	@BeforeClass
	public void setUp() {
		// Request Specification
		RequestSpec = new RequestSpecBuilder()
				.setBaseUri("https://api.github.com/")
				.addHeader("Content-Type", "application/json")
				.addHeader("Authorization", "token <token value>")
				.build();
		// Response Specification
		ResponseSpec = new ResponseSpecBuilder().
				expectResponseTime(lessThanOrEqualTo(3000L))
				.build();
	}

	// POST https://api.github.com/user/keys
	@Test(priority = 1)
	public void postRequest() {
		Map<String, Object> reqBody = new HashMap<String,Object>();
		reqBody.put("title", "TestAPIKey");
		reqBody.put("key", SSH_Key);

		Response response = given().spec(RequestSpec).
				            body(reqBody).when().post("/user/keys");
		
		SSH_Key_id = response.then().extract().path("id");
		int response_code = response.getStatusCode();
		// Assertion
		Assert.assertEquals(response_code, 201);
	}

	// GET https://api.github.com/user/keys/{keyId}
	@Test(priority = 2)
	public void getRequest() {

		Response response = given().spec(RequestSpec).pathParam("keyId", SSH_Key_id).log().all().when().get("/user/keys/{keyId}");
		int response_code = response.getStatusCode();
		Assert.assertEquals(response_code, 200);
	}

	// DELETE https://api.github.com/user/keys/{keyId}
	@Test(priority = 3)
	public void deleteRequest() {
		given().spec(RequestSpec).pathParam("keyId", SSH_Key_id).
		when().delete("/user/keys/{keyId}").then()
		.spec(ResponseSpec).assertThat().statusCode(204).log().all();
	}
}
