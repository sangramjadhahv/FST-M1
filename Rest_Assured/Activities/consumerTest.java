package project;


import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(PactConsumerTestExt.class)
public class ConsumerTest {


    Map<String, String> headers = new HashMap<>();


    @Pact(consumer = "UserConsumer", provider = "UserProvider")
    public RequestResponsePact createPact(PactDslWithProvider builder){

        headers.put("Content-Type", "application/json");


        DslPart reqAndRes = new PactDslJsonBody()
                .numberType("id")
                .stringType("firstName")
                .stringType("lastName")
                .stringType("email");


        return builder.given("POST Request").uponReceiving("a request to create a user")
                .method("POST")
                .path("/api/users")
                .headers(headers)
                .body(reqAndRes)
                .willRespondWith()
                .status(201)
                .body(reqAndRes)
                .toPact();
    }

    @Test
    @PactTestFor(providerName = "UserProvider", port = "8282")
    public void postRequestTest(){
        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("id", 1616);
        reqBody.put("firstName", "sanchit");
        reqBody.put("lastName", "raut");
        reqBody.put("email", "sanchit279@gmail.com");

        given().baseUri("http://localhost:8282").headers(headers).body(reqBody).when()


                .post("/api/users").then().statusCode(201).body("email", equalTo("sanchit279@gmail.com"))
                .log().all();
    }

}
