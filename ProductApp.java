package com.mycompany.productapp;

import java.awt.GridLayout;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.*;

/**
 * ProductApp is the GUI for processing mattress sales.
 * It captures the customer, product and price, calculates the amounts,
 * shows them in a message box and saves them to data.txt.
 */
public class ProductApp extends JFrame {

    // Form components
    private JTextField txtCustomer = new JTextField();
    private JComboBox<String> cboProduct = new JComboBox<>(new String[]{
        "Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"});
    private JTextField txtPrice = new JTextField();
    private JButton btnProcess = new JButton("PROCESS");

    public ProductApp() {
        setTitle("Product App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(450, 300);
        setLocationRelativeTo(null); // centre the window

        buildMenu();
        buildForm();
    }

    // Creates the File and Tools menus
    private void buildMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0)); // close the application
        fileMenu.add(exitItem);

        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem processItem = new JMenuItem("Process");
        JMenuItem clearItem = new JMenuItem("Clear");
        processItem.addActionListener(e -> processSale()); // same logic as the button
        clearItem.addActionListener(e -> clearForm());
        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);

        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);
    }

    // Lays out the labels, input controls and button
    private void buildForm() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("Customer Name:"));
        panel.add(txtCustomer);
        panel.add(new JLabel("Select Product:"));
        panel.add(cboProduct);
        panel.add(new JLabel("Enter Price:"));
        panel.add(txtPrice);
        panel.add(new JLabel("")); // empty cell so the button sits under the inputs
        panel.add(btnProcess);

        btnProcess.addActionListener(e -> processSale());
        add(panel);
    }

    /**
     * Validates the input, calculates VAT, commission and total,
     * displays the result and saves it to data.txt.
     * Used by both the Process button and the Process menu item.
     */
    private void processSale() {
        String customer = txtCustomer.getText().trim();
        String product = (String) cboProduct.getSelectedItem();

        // Validation: the customer name must not be empty
        if (customer.isEmpty()) {
            showError("Please enter the customer name.");
            return;
        }

        // Validation: the price must be a positive number
        double price;
        try {
            price = Double.parseDouble(txtPrice.getText().trim());
        } catch (NumberFormatException ex) {
            showError("Please enter a valid price.");
            return;
        }
        if (price <= 0) {
            showError("The price must be greater than 0.");
            return;
        }

        // Use the calculation class (through its interface) to get the amounts
        IProductCalculations calc = new ProductCalculations(price);

        // Build the text once and use it for both the message box and the file
        String details = "Customer Name: " + customer
                + "\nProduct: " + product
                + "\nVAT: R " + calc.GetVat()
                + "\nCOMMISSION: R " + calc.GetCommission()
                + "\nTOTAL: R " + calc.GetTotal();

        JOptionPane.showMessageDialog(this, details);
        saveToFile(details);
    }

    // Appends the sale details to data.txt in the format shown on the paper
    private void saveToFile(String details) {
        String stars = "*****************************************************";

        // try-with-resources closes the file automatically
        // true = append, so earlier sales are kept (use false to overwrite)
        try (PrintWriter out = new PrintWriter(new FileWriter("data.txt", true))) {
            out.println("DATA LOG");
            out.println(stars);
            out.println();
            out.println(details);
            out.println(stars);
            out.println();
        } catch (IOException ex) {
            showError("Could not save to data.txt.");
        }
    }

    // Clears the text boxes and resets the combo box to the first item
    private void clearForm() {
        txtCustomer.setText("");
        txtPrice.setText("");
        cboProduct.setSelectedIndex(0);
    }

    // Shows an error message box (avoids repeating this code)
    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Program entry point: creates and shows the window
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ProductApp().setVisible(true));
    }
}