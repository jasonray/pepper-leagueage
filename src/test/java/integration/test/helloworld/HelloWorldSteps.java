package integration.test.helloworld;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import static org.junit.Assert.assertEquals;

public class HelloWorldSteps {
    public UriComponentsBuilder requestUriBuilder;
    private final String URI_HOST = "localhost";
    private final String URI_PORT = "9080";
    private ResponseEntity<String> response;

    public HelloWorldSteps() {
        this.requestUriBuilder = UriComponentsBuilder.newInstance().scheme("http").host(URI_HOST).port(URI_PORT).path("hello-world");
    }

    @Given("the pepper app is running")
    public void checkAppRunning() {
        //TODO: check the metrics endpoint to ensure it is running
    }

    @When("I invoke the hello world API")
    public void invokeHelloWorldApp() {
        RestTemplate restTemplate = new RestTemplate();
        this.response = restTemplate.getForEntity(this.requestUriBuilder.build().toUriString(), String.class);
    }

    @When("I invoke the hello world API with name of {string}")
    public void invokeHelloWorldApp(String name) {
        RestTemplate restTemplate = new RestTemplate();
        this.response = restTemplate.getForEntity(this.requestUriBuilder.queryParam("name", name).build().toUriString(), String.class);
    }

    @Then("I get a successful HTTP status response")
    public void verifySuccessfulHttpStatus() {
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(200, response.getStatusCodeValue());
    }

    @Then("I receive a response of {string}")
    public void verifyResponse(String expectedResponse) {
        assertEquals(expectedResponse, response.getBody());
    }

}
