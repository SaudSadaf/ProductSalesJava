package com.mycompany.productsalesreport;

/**
 * Prints the different parts of the sales report (Q.1.3).
 */
public class PrintProduct {

    private final Product product;

    public PrintProduct(Product product) {
        this.product = product;
    }

    public void printHeading() {
        System.out.println("PRODUCT SALES REPORT - 2026");
        System.out.println();
        System.out.println("*".repeat(45));
    }

    public void printTotalSales() {
        System.out.println("TOTAL PRODUCT SALES: " + product.GetTotalProductsSold());
    }

    public void printAverageSales() {
        System.out.println("AVERAGE PRODUCT SALES: " + Math.round(product.GetAverageProductSold()));
    }

    public void printMostPopularProduct() {
        System.out.println("MOST POPULAR PRODUCT: " + product.GetMostPopularProduct()
                + "(" + product.getMostPopularBestMonth() + ")");
    }

    public void printReport() {
        printHeading();
        printTotalSales();
        printAverageSales();
        printMostPopularProduct();
    }
}
