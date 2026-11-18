package com.mycompany.productsalesreport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for Question 1 (Q.1.4), using the data from the sample screenshot.
 */
public class ProductTest {

    private final String[] productNames = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
    private final int[][] sales = {
        {25, 18, 20},
        {15, 10, 12},
        {18, 15, 20}
    };
    private final Product product = new Product(productNames, sales);

    @Test
    public void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {
        assertEquals(153, product.GetTotalProductsSold());
    }

    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        assertEquals(17.0, product.GetAverageProductSold(), 0.001);
    }
}
