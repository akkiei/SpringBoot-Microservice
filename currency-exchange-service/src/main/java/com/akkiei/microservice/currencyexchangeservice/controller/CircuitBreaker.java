package com.akkiei.microservice.currencyexchangeservice.controller;

import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class CircuitBreaker {
    Logger logger = LoggerFactory.getLogger(CircuitBreaker.class);

    @RequestMapping(method = RequestMethod.GET, path = "/get")
    @Retry(name = "sample", fallbackMethod = "fallbackMethod")
    public String sampleAPI() {
        logger.info(" LOGGER FAILED");
        ResponseEntity<String> forEntity =
                new RestTemplate().getForEntity("http://localhost:8080/not-working", String.class);


        return forEntity.getBody();
    }

    public String fallbackMethod(Exception exception){

        return "This is a fallback response";
    }

}
