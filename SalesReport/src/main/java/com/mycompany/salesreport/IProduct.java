package com.mycompany.salesreport;

/**
 * IProduct is an interface that defines the methods every product
 * sales class must provide. Any class that implements it must write
 * the code for all three methods.
 */
public interface IProduct {

    // Returns the total number of products sold across all products and months
    int GetTotalProductsSold();

    // Returns the average number of products sold per entry
    double GetAverageProductSold();

    // Returns the name and sales figure of the most popular product
    String GetMostPopularProduct();
}