package com.mycompany.salesreport;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Unit tests for the Product class, using the sample data from the question paper.
 */
public class ProductTest {

    /**
     * Helper method that builds a Product with the sample data.
     * Used by both tests so the data is not repeated.
     */
    private Product createProduct() {
        String[] names = {"Cozy Nights Monarch mattress",
                          "Restonic Barbados mattress",
                          "Sealy Phuket mattress"};
        int[][] sales = {{25, 18, 20}, {15, 10, 12}, {18, 15, 20}};
        return new Product(names, sales);
    }

    // Test 1: checks that GetTotalProductsSold returns the correct total (153)
    @Test
    public void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {
        assertEquals(153, createProduct().GetTotalProductsSold());
    }

    // Test 2: checks that GetAverageProductSold returns the correct average (17)
    // The 0.01 is the allowed difference, because doubles can have tiny rounding errors
    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        assertEquals(17.0, createProduct().GetAverageProductSold(), 0.01);
    }
}