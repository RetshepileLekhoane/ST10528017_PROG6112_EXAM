package com.mycompany.productapp;

// Defines the calculations every product sale must provide
public interface IProductCalculations {
    double GetVat();         // 15% of the price
    double GetCommission();  // 5% of the price
    double GetTotal();       // price + VAT + commission
}