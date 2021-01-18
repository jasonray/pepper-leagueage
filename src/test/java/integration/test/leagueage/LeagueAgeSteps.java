package integration.test.leagueage;

import integration.test.ApiContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

public class LeagueAgeSteps {
    private final ApiContext<Integer> context;

    private final Logger logger = LoggerFactory.getLogger(LeagueAgeSteps.class);

    public LeagueAgeSteps(ApiContext<Integer> context) {
        logger.trace("init LeagueAgeSteps; context: [{}]; context.requestUriBuilder: [{}]", context, context.requestUriBuilder);
        this.context = context;
        this.context.requestUriBuilder = this.context.requestUriBuilder.path("league-age");
    }

    @When("I invoke the league age API, on {string}, for a player with {string}")
    public void invokeLeagueAgiApi(String referenceDate, String dob) {
        logger.trace("invokeLeagueAgiApi [{}][{}]", referenceDate, dob);
        context.requestUriBuilder = context.requestUriBuilder.queryParam("reference", referenceDate).queryParam("dob", dob);
        context.executeGetRequest(Integer.class);
    }

    @Then("I receive a response that the player's league age is {int}")
    public void verifyLeagueAge(Integer expectedLeagueAge) {
        int actualAge = context.response.getBody().intValue();
        logger.trace("verifyLeagueAge [{}][{}]", expectedLeagueAge, actualAge);
        assertEquals(expectedLeagueAge.intValue(), actualAge);
    }

}
