package me.sibalnirbhay.classes;

public abstract class Price {
    private int _priceCode;

    public Price(int priceCode) {
        _priceCode = priceCode;
    }

    public int priceCode() {
        return _priceCode;
    }

    abstract double amount(int daysRented);
}
