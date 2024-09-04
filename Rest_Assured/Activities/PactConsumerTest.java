package Activities;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

@ExtendWith(PactConsumerTestExt.class)

public class PactConsumerTest {
	
	
	
	    Map<String, String> headers = new HashMap<String, String>();
	    
	
	    @Pact(consumer = "UserConsumer",provider = "UserProvider")
	    public RequestResponsePact createPact(PactDslWithProvider builder) {
	    
	    	
	        headers.put("Content-Type", "application/json");
	    
	        DslPart requestResponseBody =new PactDslJsonBody().
	                 numberType("id",158871).
	                 stringType("firstName","Sangram").
	                 stringType("lastName","Jadhav").
	                 stringType("email","sangram.jadhav@gmail.com");
	      
	        return builder.given("POST Request").
	                 uponReceiving("A request to create a user").
	                 method("POST").
	                 path("/api/users").
	                 headers(headers).
	                 body(requestResponseBody).
	                 willRespondWith().
	                 status(201).
	                 body(requestResponseBody).
	                 toPact();

	    }
	 
	    @Test
	    @PactTestFor(providerName = "UserProvider",port="8282")
	    public void PactConsumerTest(){
	    	
	    	 Map<String, Object> reqBody = new HashMap<String, Object>();
	       	    	 reqBody.put("id", 128991);
	    	 reqBody.put("firstName","Sangram");
	    	 reqBody.put("lastName","Jadhav");
		     reqBody.put("email","sangram@example.com");
	    	 
	    
	      
		     given().baseUri("http://localhost:8282/api/users").
		     headers(headers).body(reqBody).log().all().when().post().
		     then().statusCode(201).body("email",equalTo("sangram@example.com")).log().all();
	   

	    }


}
