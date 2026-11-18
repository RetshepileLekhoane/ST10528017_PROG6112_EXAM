package com.mycompany.productapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the ProductCalculations class using the sample price of R3500.
 */
public class ProductCalculationsTest {

    // Test 1: 15% of 3500 should be 525
    @Test
    public void GetVat_WithValidData_ReturnsCorrectValue() {
        IProductCalculations calc = new ProductCalculations(3500);
        assertEquals(525.0, calc.GetVat(), 0.01);
    }

    // Test 2: 3500 + 525 VAT + 175 commission should be 4200
    @Test
    public void GetTotal_WithValidData_ReturnsCorrectValue() {
        IProductCalculations calc = new ProductCalculations(3500);
        assertEquals(4200.0, calc.GetTotal(), 0.01);
    }
}