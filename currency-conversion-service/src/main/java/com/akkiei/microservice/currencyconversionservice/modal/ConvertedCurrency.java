package com.akkiei.microservice.currencyconversionservice.modal;

public class ConvertedCurrency {

    private int id;
    private String fromCurrency;
    private String toCurrency;
    private float mulFactor;
    private float quantity;
    private float totalAmount;
    private String environment;

    public ConvertedCurrency(int id, String fromCurrency, String toCurrency, float mulFactor, float quantity, String environment) {
        this.id = id;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.mulFactor = mulFactor;
        this.quantity = quantity;
        this.totalAmount = mulFactor * quantity;
        this.environment = environment;
    }

    public ConvertedCurrency() {
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

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
