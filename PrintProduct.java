package com.mycompany.salesreport;

/**
 * PrintProduct is only responsible for displaying the report data.
 * It keeps printing separate from the calculations in Product.
 */
public class PrintProduct {

    // Uses the interface type so it works with any class that implements IProduct
    private IProduct product;

    /**
     * Constructor: receives the product whose data must be printed.
     */
    public PrintProduct(Product product) {
        this.product = product;
    }

    // Prints the total number of products sold
    public void PrintTotalProductSales() {
        System.out.println("TOTAL PRODUCT SALES: " + product.GetTotalProductsSold());
    }

    // Prints the average products sold, rounded to a whole number like the sample
    public void PrintAverageProductSales() {
        System.out.println("AVERAGE PRODUCT SALES: " + Math.round(product.GetAverageProductSold()));
    }

    // Prints the most popular product and its sales figure
    public void PrintMostPopularProduct() {
        System.out.println("MOST POPULAR PRODUCT: " + product.GetMostPopularProduct());
    }
}