package com.resiliencia.padroes.config;

import org.springframework.stereotype.Component;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import jakarta.annotation.PostConstruct;

@Component
public class CircuitBreakerEventsListener {

    private final CircuitBreaker circuitBreaker;

    public CircuitBreakerEventsListener(CircuitBreakerRegistry registry) {
        this.circuitBreaker = registry.circuitBreaker("precoCB");
    }

    @PostConstruct
    public void subscribe() {
        circuitBreaker.getEventPublisher()
                .onStateTransition(event -> System.out.printf(
                        "[CB %s] %s -> %s%n",
                        event.getCircuitBreakerName(),
                        event.getStateTransition().getFromState(),
                        event.getStateTransition().getToState()))
                .onError(event -> System.out.printf(
                        "[CB %s] erro: %s%n",
                        event.getCircuitBreakerName(),
                        event.getThrowable() != null ? event.getThrowable() : "n/a"));
    }
}
