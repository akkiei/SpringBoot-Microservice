package com.akkiei.microservice.currencyexchangeservice.modal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ExCurrency {
    @Id
    private int id;
    private String fromCurrency;
    private String toCurrency;
    private float mulFactor;
    private String environment;

    public ExCurrency() {
    }

    public ExCurrency(int id, String fromCurrency, String toCurrency, float mulFactor, String environment) {
        this.id = id;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.mulFactor = mulFactor;
        this.environment = environment;

    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public float getMulFactor() {
        return mulFactor;
    }

    public void setMulFactor(float mulFactor) {
        this.mulFactor = mulFactor;
    }
}
