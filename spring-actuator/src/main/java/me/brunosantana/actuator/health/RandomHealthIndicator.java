package me.brunosantana.actuator.health;

import org.springframework.boot.actuate.autoconfigure.health.ConditionalOnEnabledHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
@ConditionalOnEnabledHealthIndicator("random")
public class RandomHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        double chance = ThreadLocalRandom.current().nextDouble();
        Health.Builder status = Health.up(); // http status 200
        //Health.Builder status = Health.unknown(); // http status 200
        if (chance > 0.9) {
            status = Health.down(); // http status 503
            //status = Health.outOfService(); // http status 503
        }
        /*boolean x = chance > 0.5;
        if (x) {
            throw new RuntimeException("unexpected error"); // http status 500 when accessing http://localhost:8080/actuator/health or http://localhost:8080/actuator/health/random
        }*/
        return status.build();
    }
}
