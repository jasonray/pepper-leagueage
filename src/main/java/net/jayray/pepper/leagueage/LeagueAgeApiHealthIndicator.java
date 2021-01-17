package net.jayray.pepper.leagueage;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;


@Component
public class LeagueAgeApiHealthIndicator implements HealthIndicator {

    public LeagueAgeApiHealthIndicator() {
    }

    @Override
    public Health health() {
        Health.Builder builder = new Health.Builder();
        return builder.up().build();
    }



}
