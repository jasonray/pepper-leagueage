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
    private String URI_HOST = "localhost";
    private String URI_PORT = "8080";
    private ResponseEntity<String> response;

    public HelloWorldSteps() {
        this.requestUriBuilder = UriComponentsBuilder.newInstance().scheme("http").host(URI_HOST).port(URI_PORT);
    }

    @Given("the pepper app is running")
    public void checkAppRunning(String criteria, String value) {
        //TODO: check the metrics endpoint to ensure it is running
    }

    @When("I invoke the hello world API")
    public void invokeHelloWorldApp() throws Throwable {
        RestTemplate restTemplate = new RestTemplate();
        this.response = restTemplate.getForEntity(this.requestUriBuilder.build().toUriString(), String.class);
    }

    @Then("I get a successful HTTP status response")
    public void verifySuccessfulHttpStatus() throws Throwable {
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(200, response.getStatusCodeValue());    }

}
