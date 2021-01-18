package integration.test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.springframework.http.HttpStatus;

import static org.junit.Assert.assertEquals;

public class CommonSteps {

    private final ApiContext context;

    public CommonSteps(ApiContext context) {
        this.context = context;
    }

    @Given("the pepper app is running")
    public void checkAppRunning() {
        //TODO: check the metrics endpoint to ensure it is running
    }

    @Then("I get a successful HTTP status response")
    public void verifySuccessfulHttpStatus() {
        assertEquals(HttpStatus.OK, context.response.getStatusCode());
        assertEquals(200, context.response.getStatusCodeValue());
    }
}
