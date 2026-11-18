/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.salesreport;

/**
 *
 * @author Student
 */

import java.util.Scanner;

public class SalesReport {



    public static void main(String[] args) {
        // Scanner reads the numbers typed in by the user
        Scanner input = new Scanner(System.in);

        // Single array: the names of the three top-performing products
        String[] names = {
            "Cozy Nights Monarch mattress",
            "Restonic Barbados mattress",
            "Sealy Phuket mattress"
        };

        // 2D array: 3 products (rows) x 3 months (columns)
        int[][] sales = new int[names.length][3];

        // Outer loop: one pass for each product
        for (int p = 0; p < names.length; p++) {
            // Inner loop: one pass for each month, so the prompt is written only once
            for (int m = 0; m < 3; m++) {
                System.out.print("Enter number of sales for month " + (m + 1)
                        + " for " + names[p] + ": ");
                sales[p][m] = input.nextInt(); // store the value in the correct cell
            }
            System.out.println(); // blank line between products
        }

        // Create the Product object that holds the data and does the calculations
        Product product = new Product(names, sales);

        // Create the PrintProduct object that prints the results
        PrintProduct printer = new PrintProduct(product);

        // Display the report
        System.out.println("PRODUCT SALES REPORT - 2026");
        System.out.println("*****************************************************");
        printer.PrintTotalProductSales();
        printer.PrintAverageProductSales();
        printer.PrintMostPopularProduct();
    }
}