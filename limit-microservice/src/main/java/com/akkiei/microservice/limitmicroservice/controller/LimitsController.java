package com.akkiei.microservice.limitmicroservice.controller;

import com.akkiei.microservice.limitmicroservice.bean.Limits;
import com.akkiei.microservice.limitmicroservice.configuration.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {
    @Autowired
    Configuration configuration;

    @RequestMapping(method = RequestMethod.GET, path = "/limits")
    public Limits retrieveLimits() {

        return new Limits(configuration.getMinimum(), configuration.getMaximum());
    }

}
