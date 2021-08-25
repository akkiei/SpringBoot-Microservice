package com.akkiei.microservice.currencyconversionservice.controller;

import com.akkiei.microservice.currencyconversionservice.modal.ConvertedCurrency;
import com.akkiei.microservice.currencyconversionservice.proxy.CurrencyExProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@RestController
public class CurrencyConverter {
    @Autowired
    Environment environment;

    @Autowired
    CurrencyExProxy proxy;

    @RequestMapping(method = RequestMethod.GET, path = "/from/{fromCurrency}/to/{toCurrency}/quantity/{quantity}")
    public ConvertedCurrency getExchangeRates(@PathVariable String fromCurrency,
                                              @PathVariable String toCurrency,
                                              @PathVariable int quantity) {

//        float rate = 65F;
        HashMap<String, String> uriVariables = new HashMap<>();
        uriVariables.put("fromCurrency", fromCurrency);
        uriVariables.put("toCurrency", toCurrency);

        ResponseEntity<ConvertedCurrency> convertedCurrencyResponseEntity = new RestTemplate().getForEntity("http://localhost:8000/from/{fromCurrency}/to/{toCurrency}",
                ConvertedCurrency.class,
                uriVariables
        );

        ConvertedCurrency currencyConverter = convertedCurrencyResponseEntity.getBody();
        System.out.println(currencyConverter.getMulFactor());
        System.out.println(uriVariables);

        return new ConvertedCurrency(currencyConverter.getId(), currencyConverter.getFromCurrency(),
                currencyConverter.getToCurrency(), currencyConverter.getMulFactor(),
                quantity, currencyConverter.getEnvironment());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/fromFeign/{fromCurrency}/to/{toCurrency}/quantity/{quantity}")
    public ConvertedCurrency getExchangeRatesFeign(@PathVariable String fromCurrency,
                                                   @PathVariable String toCurrency,
                                                   @PathVariable int quantity) {

        ConvertedCurrency currencyConverter = proxy.getCurrencyExchangeRate(fromCurrency, toCurrency);

        return new ConvertedCurrency(currencyConverter.getId(), currencyConverter.getFromCurrency(),
                currencyConverter.getToCurrency(), currencyConverter.getMulFactor(),
                quantity, currencyConverter.getEnvironment());
    }

}
