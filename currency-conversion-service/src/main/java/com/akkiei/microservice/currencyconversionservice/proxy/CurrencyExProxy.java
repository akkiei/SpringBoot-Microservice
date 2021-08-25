package com.akkiei.microservice.currencyconversionservice.proxy;


import com.akkiei.microservice.currencyconversionservice.controller.CurrencyConverter;
import com.akkiei.microservice.currencyconversionservice.modal.ConvertedCurrency;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@FeignClient(name = "currency-exchange", url = "localhost:8000")
@FeignClient(name = "currency-exchange") // this one automatically load balances
public interface CurrencyExProxy {

    @RequestMapping(method = RequestMethod.GET, path = "/from/{fromCurrency}/to/{toCurrency}")
    ConvertedCurrency getCurrencyExchangeRate(@PathVariable String fromCurrency,
                                              @PathVariable String toCurrency);


}
