package pact;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

@ExtendWith(PactConsumerTestExt.class)
public class PactConsumerTest {
	// Create Map for the headers
	Map<String, String> headers = new HashMap<String, String>();
	// Set resource URI
	String createUser = "/api/users";

	@Pact(provider = "UserProvider", consumer = "UserConsumer")
	public RequestResponsePact createPact(PactDslWithProvider builder) throws ParseException {

		// Add headers
		headers.put("Content-Type", "application/json");
		headers.put("Accept", "application/json");

		// Create request JSON
		DslPart requestResponseBody = new PactDslJsonBody().
				numberType("id", 11).
				stringType("firstName", "Justin").
				stringType("lastName", "Case").
				stringType("email", "justincase@mail.com");

		// Create rules for request and response
		return builder.given("POST Request").
				       uponReceiving("A request to create a user").
				       path("/api/users").
				       method("POST").headers(headers).
				       body(requestResponseBody).
				     willRespondWith().
				        status(201).
				        body(requestResponseBody).
				        toPact();

	}

	@Test
	@PactTestFor(providerName = "UserProvider", port = "8282")
	public void consumerTest() {
		// Create request body
		Map<String, Object> reqBody = new HashMap<String, Object>();
		reqBody.put("id", 11);
		reqBody.put("firstName", "Justin");
		reqBody.put("lastName", "Case");
		reqBody.put("email", "justincase@mail.com");
		// Send POST request
		
		given().baseUri("http://localhost:8282/api/users").headers(headers).body(reqBody).log().all().when().post()
				.then().statusCode(201).body("email", equalTo("justincase@mail.com")).log().all();

	}

}
