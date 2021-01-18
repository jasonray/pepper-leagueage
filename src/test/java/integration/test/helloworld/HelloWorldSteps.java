package integration.test.helloworld;

import integration.test.ApiContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class HelloWorldSteps {
    private final ApiContext<String> context;

    public HelloWorldSteps(ApiContext<String> context) {
        this.context = context;
        this.context.requestUriBuilder = this.context.requestUriBuilder.path("hello-world");
    }

    @When("I invoke the hello world API")
    public void invokeHelloWorldApp() {
        context.executeGetRequest(String.class);
    }

    @When("I invoke the hello world API with name of {string}")
    public void invokeHelloWorldApp(String name) {
        context.requestUriBuilder = context.requestUriBuilder.queryParam("name", name);
        context.executeGetRequest(String.class);
    }

    @Then("I receive a response of {string}")
    public void verifyResponse(String expectedResponse) {
        assertEquals(expectedResponse, context.response.getBody());
    }
}
