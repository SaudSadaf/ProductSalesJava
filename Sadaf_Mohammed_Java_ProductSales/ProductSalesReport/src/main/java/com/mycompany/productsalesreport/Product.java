package com.mycompany.productsalesreport;

/**
 * Works out the totals for the sales report (Q.1.2).
 * The product names are kept in a single dimensional array and the
 * monthly sales in a two dimensional array (one row per product,
 * one column per month).
 */
public class Product implements IProduct {

    private final String[] productNames;
    private final int[][] sales;

    public Product(String[] productNames, int[][] sales) {
        this.productNames = productNames;
        this.sales = sales;
    }

    /**
     * Adds up every sale for every product and month.
     */
    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int[] productSales : sales) {
            for (int sale : productSales) {
                total += sale;
            }
        }
        return total;
    }

    /**
     * Average number of products sold per entry (each product for each month).
     * For the sample data: 153 / 9 = 17.
     */
    @Override
    public double GetAverageProductSold() {
        int entries = 0;
        for (int[] productSales : sales) {
            entries += productSales.length;
        }
        return entries == 0 ? 0 : (double) GetTotalProductsSold() / entries;
    }

    /**
     * The product with the highest total sales over the three months.
     * If two products tie, the first one entered wins.
     */
    @Override
    public String GetMostPopularProduct() {
        return productNames[getMostPopularIndex()];
    }

    /**
     * Total sales for one product across all the months.
     */
    public int getProductTotal(int productIndex) {
        int total = 0;
        for (int sale : sales[productIndex]) {
            total += sale;
        }
        return total;
    }

    /**
     * Highest single month of sales for the most popular product. This is
     * the number shown in brackets in the sample report, e.g. (25).
     */
    public int getMostPopularBestMonth() {
        int best = 0;
        for (int sale : sales[getMostPopularIndex()]) {
            if (sale > best) {
                best = sale;
            }
        }
        return best;
    }

    private int getMostPopularIndex() {
        int topIndex = 0;
        for (int i = 1; i < productNames.length; i++) {
            if (getProductTotal(i) > getProductTotal(topIndex)) {
                topIndex = i;
            }
        }
        return topIndex;
    }
}
