package com.mycompany.productapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for Question 2 (Q.2.6), using the R3500 price from the sample.
 */
public class ProductCalculationsTest {

    private final ProductCalculations calculations = new ProductCalculations(3500);

    @Test
    public void GetVat_WithValidData_ReturnsCorrectValue() {
        // 15% of R3500
        assertEquals(525.0, calculations.GetVat(), 0.001);
    }

    @Test
    public void GetTotal_WithValidData_ReturnsCorrectValue() {
        // R3500 + R525 VAT + R175 commission
        assertEquals(4200.0, calculations.GetTotal(), 0.001);
    }

    @Test
    public void GetCommission_WithValidData_ReturnsCorrectValue() {
        // 5% of R3500
        assertEquals(175.0, calculations.GetCommission(), 0.001);
    }
}
