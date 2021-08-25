package com.akkiei.microservice.currencyexchangeservice.repository;

import com.akkiei.microservice.currencyexchangeservice.controller.CurrencyExchange;
import com.akkiei.microservice.currencyexchangeservice.modal.ExCurrency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrExchanger extends JpaRepository<ExCurrency, Integer> {

    ExCurrency findByFromCurrencyAndToCurrency(String fromCurrency,String toCurrency);


}
