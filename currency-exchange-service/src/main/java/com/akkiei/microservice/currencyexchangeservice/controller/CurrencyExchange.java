package com.akkiei.microservice.currencyexchangeservice.controller;

import com.akkiei.microservice.currencyexchangeservice.modal.ExCurrency;
import com.akkiei.microservice.currencyexchangeservice.repository.CurrExchanger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchange {
    @Autowired
    private Environment environment;
    @Autowired
    private CurrExchanger repository;

    @RequestMapping(method = RequestMethod.GET, path = "/from/{fromCurrency}/to/{toCurrency}")
    public ExCurrency getCurrencyExchangeRate(@PathVariable String fromCurrency, @PathVariable String toCurrency) {
        ExCurrency exCurrency = repository.findByFromCurrencyAndToCurrency(fromCurrency, toCurrency);

        if( exCurrency == null){

            throw new RuntimeException("Currency " + fromCurrency + " and " + toCurrency + " not found !");
        }

        exCurrency.setEnvironment(environment.getProperty("local.server.port"));
        return exCurrency;
    }
}
