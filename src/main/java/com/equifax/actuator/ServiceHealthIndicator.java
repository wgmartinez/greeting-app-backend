package com.equifax.actuator;

import com.equifax.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class ServiceHealthIndicator implements HealthIndicator {
    private final String message_key = "Greeting generation service";

    @Autowired
    private GreetingService greetingService;

    @Override
    public Health health() {
        if (!isRunningGreetGenerationService()) {
            return Health.down().withDetail(message_key, "Not Available").build();
        }
        return Health.up().withDetail(message_key, "Available").build();
    }

    private Boolean isRunningGreetGenerationService() {
        Boolean isRunning = false;
        // Logic Skipped
        ResponseEntity<String> ee = null;
        try {
            ee = greetingService.greet("EN", "Test");
        } catch (Exception e) {
            return isRunning;
        }

        if (ee != null && HttpStatus.OK == ee.getStatusCode()) {
            isRunning = true;
        }

        return isRunning;
    }
}
