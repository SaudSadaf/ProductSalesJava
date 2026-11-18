package com.mycompany.productapp;

/**
 * Calculates the VAT, commission and total sale amount for one product
 * price (Q.2.5).
 */
public class ProductCalculations implements IProductCalculations {

    public static final double VAT_RATE = 0.15;
    public static final double COMMISSION_RATE = 0.05;

    private final double productPrice;

    public ProductCalculations(double productPrice) {
        this.productPrice = productPrice;
    }

    public double getProductPrice() {
        return productPrice;
    }

    /** VAT is 15% of the product price. */
    @Override
    public double GetVat() {
        return round(productPrice * VAT_RATE);
    }

    /** Commission is 5% of the product price. */
    @Override
    public double GetCommission() {
        return round(productPrice * COMMISSION_RATE);
    }

    /** Total sale amount = price + VAT + commission. */
    @Override
    public double GetTotal() {
        return round(productPrice + GetVat() + GetCommission());
    }

    // Rounds to two decimals so the amounts show cleanly, e.g. R 4200.0
    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
