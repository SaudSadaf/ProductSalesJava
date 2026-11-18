package com.mycompany.productapp;

import java.awt.Component;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Handles the Process and Clear actions, so the button and the menu items
 * on the form can each call the same logic in one line.
 */
public class ProductAppController {

    /**
     * Q.2.3: captures the customer name, product and price, calculates the
     * VAT, commission and total, shows them and saves them to data.txt.
     */
    public void process(Component parent, JTextField txtCustomerName, JComboBox<String> cmbProduct,
            JTextField txtPrice) {

        String customerName = txtCustomerName.getText().trim();
        String productName = cmbProduct.getSelectedItem() == null ? "" : cmbProduct.getSelectedItem().toString();

        if (customerName.isEmpty()) {
            showError(parent, "Please enter the customer's name.");
            txtCustomerName.requestFocus();
            return;
        }
        if (productName.isEmpty()) {
            showError(parent, "Please select a product.");
            return;
        }

        double price;
        try {
            price = Double.parseDouble(txtPrice.getText().trim());
        } catch (NumberFormatException e) {
            showError(parent, "Please enter a valid number for the price.");
            txtPrice.requestFocus();
            return;
        }
        if (price <= 0) {
            showError(parent, "The price must be greater than zero.");
            txtPrice.requestFocus();
            return;
        }

        ProductCalculations calculations = new ProductCalculations(price);

        String details = "Customer Name: " + customerName + "\n"
                + "Product: " + productName + "\n"
                + "VAT: R " + calculations.GetVat() + "\n"
                + "COMMISSION: R " + calculations.GetCommission() + "\n"
                + "TOTAL: R " + calculations.GetTotal();

        saveData(parent, details);
        JOptionPane.showMessageDialog(parent, details);
    }

    /**
     * Q.2.4: clears the text boxes and sets the combo box back to index 0.
     */
    public void clear(JTextField txtCustomerName, JComboBox<String> cmbProduct, JTextField txtPrice) {
        txtCustomerName.setText("");
        txtPrice.setText("");
        cmbProduct.setSelectedIndex(0);
        txtCustomerName.requestFocus();
    }

    /**
     * Q.2.3: writes the details to data.txt in the project folder, in the
     * same layout as the sample screenshot.
     */
    private void saveData(Component parent, String details) {
        String stars = "*".repeat(31);
        try (PrintWriter writer = new PrintWriter(new FileWriter("data.txt"))) {
            writer.println("DATA LOG");
            writer.println(stars);
            writer.println(details);
            writer.println(stars);
        } catch (IOException e) {
            showError(parent, "The data could not be saved: " + e.getMessage());
        }
    }

    private void showError(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, "Invalid input", JOptionPane.ERROR_MESSAGE);
    }
}
