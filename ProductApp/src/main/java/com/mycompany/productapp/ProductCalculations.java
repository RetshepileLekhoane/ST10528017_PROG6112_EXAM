package com.mycompany.productapp;

/**
 * Calculates the VAT, commission and total for a product price.
 * Implements IProductCalculations.
 */
public class ProductCalculations implements IProductCalculations {

    // Rates are constants so they are not repeated in the code
    private static final double VAT_RATE = 0.15;
    private static final double COMMISSION_RATE = 0.05;

    private double price; // the product price entered by the user

    public ProductCalculations(double price) {
        this.price = price;
    }

    // VAT is 15% of the product price
    @Override
    public double GetVat() {
        return price * VAT_RATE;
    }

    // Commission is 5% of the product price
    @Override
    public double GetCommission() {
        return price * COMMISSION_RATE;
    }

    // Total sale amount = price + VAT + commission
    @Override
    public double GetTotal() {
        return price + GetVat() + GetCommission();
    }
}