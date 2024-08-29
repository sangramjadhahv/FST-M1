package projects;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GitHubRestAssuredAPI {

	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	int sshID;
	String sshKey;
	
	@BeforeClass
	public void setUp()
	{
		//RequestSpecification
		requestSpec = new RequestSpecBuilder().
				        setBaseUri("https://api.github.com").
				        addHeader("Content-Type","application/json").
				        addHeader("Authorization","token").
				        build();
		
		responseSpec=new ResponseSpecBuilder().
			     expectResponseTime(lessThanOrEqualTo(3000L)).
			     build();
	}
	@Test(priority = 1)
	public void postReq()
	{
		Map<String, Object> reqBody=new HashMap<String,Object>();
		reqBody.put("title","TestAPIKey");
		reqBody.put("key","ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIPNsCi6yAvQrhujIXIiXMqfeNTegOT2/JGKKJZdWoAjl");
		
		Response response =given().spec(requestSpec).body(reqBody).
				           when().post("/user/keys");
		response.prettyPrint();
		//Reporter.log(response.asPrettyString());
		
		sshID=response.then().extract().path("id");
		
		response.then().spec(responseSpec).assertThat().statusCode(201).log().all();
	}
	
	@Test(priority=2)
	public void getReq()
	{
		given().spec(requestSpec).pathParam("keyId",sshID).log().all().
		when().get("/user/keys/{keyId}").
		then().spec(responseSpec).assertThat().statusCode(200).log().all();
	}
	
	@Test(dependsOnMethods = "postReq",priority = 3)
	  public void deletReq() 
	  {
	  given().spec(requestSpec).pathParam("keyId", sshID).log().all().
	  when().delete("/user/keys/{keyId}").
	  then().spec(responseSpec).assertThat().statusCode(204).log().all();
	  }
	 
	  
	
}
