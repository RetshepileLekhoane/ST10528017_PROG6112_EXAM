package com.mycompany.salesreport;

/**
 * Product stores the sales data and calculates the report values.
 * It implements IProduct, so it must contain all three interface methods.
 */
public class Product implements IProduct {

    // Single array: stores the names of the products
    private String[] names;

    // Two-dimensional array: each row is a product, each column is a month
    // e.g. sales[0][1] = sales of the first product in month 2
    private int[][] sales;

    /**
     * Constructor: receives the product names and the sales figures
     * and stores them in the class fields.
     */
    public Product(String[] names, int[][] sales) {
        this.names = names;
        this.sales = sales;
    }

    /**
     * Adds up the sales of every product for every month.
     * @return the total number of products sold
     */
    @Override
    public int GetTotalProductsSold() {
        int total = 0;

        // Outer loop goes through each product (each row)
        for (int[] productSales : sales) {
            // Inner loop goes through each month for that product
            for (int monthSales : productSales) {
                total += monthSales; // add this month's sales to the running total
            }
        }
        return total;
    }

    /**
     * Calculates the average number of products sold per entry.
     * @return the total divided by the number of entries (products x months)
     */
    @Override
    public double GetAverageProductSold() {
        // Number of entries = number of rows x number of columns (3 x 3 = 9)
        int entries = sales.length * sales[0].length;

        // Cast to double so the division keeps its decimal part
        return (double) GetTotalProductsSold() / entries;
    }

    /**
     * Finds the highest single sales figure and the product it belongs to.
     * @return the product name and its figure, e.g. Cozy Nights Monarch(25)
     */
    @Override
    public String GetMostPopularProduct() {
        int bestProduct = 0;          // index of the best product found so far
        int highest = sales[0][0];    // start with the first figure as the highest

        // Go through every product (row)
        for (int p = 0; p < sales.length; p++) {
            // Go through every month (column) for that product
            for (int m = 0; m < sales[p].length; m++) {
                // If this figure is higher, remember it and its product
                if (sales[p][m] > highest) {
                    highest = sales[p][m];
                    bestProduct = p;
                }
            }
        }
        // Build the text using the product's name and its highest figure
        return names[bestProduct] + "(" + highest + ")";
    }
}