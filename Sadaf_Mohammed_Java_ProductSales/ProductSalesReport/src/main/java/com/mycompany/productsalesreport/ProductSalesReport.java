package com.mycompany.productsalesreport;

import java.util.Scanner;

/**
 * Question 1: captures three months of sales for the three top mattresses
 * and prints the product sales report.
 */
public class ProductSalesReport {

    public static void main(String[] args) {
        // Single dimensional array of product names
        String[] productNames = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        final int MONTHS = 3;

        // Two dimensional array: one row per product, one column per month
        int[][] sales = new int[productNames.length][MONTHS];

        Scanner input = new Scanner(System.in);
        for (int p = 0; p < productNames.length; p++) {
            for (int m = 0; m < MONTHS; m++) {
                sales[p][m] = readSales(input, "Enter number of sales for month " + (m + 1)
                        + " for " + productNames[p] + " mattress: ");
            }
            System.out.println();
        }
        System.out.println();

        Product product = new Product(productNames, sales);
        PrintProduct printer = new PrintProduct(product);
        printer.printReport();
    }

    /**
     * Keeps asking until the user enters a whole number of 0 or more.
     */
    private static int readSales(Scanner input, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = input.nextLine().trim();
            try {
                int value = Integer.parseInt(line);
                if (value >= 0) {
                    return value;
                }
                System.out.println("Sales cannot be negative. Please try again.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a whole number.");
            }
        }
    }
}
