package pharmacy.gui;

import javax.swing.*;
import java.time.LocalDate;
import pharmacy.model.Medicine;
import pharmacy.service.MedicineService;
import pharmacy.util.MedicineCategory;

/**
 * PharmacyFrame is the main GUI dashboard
 * for pharmacy operations.
 */
public class PharmacyFrame extends JFrame {

    private MedicineService service = new MedicineService();
    private JTextArea outputArea;

    public PharmacyFrame() {
        setTitle("Pharmacy Management System");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JButton addBtn = new JButton("Add Medicine");
        addBtn.setBounds(30, 30, 150, 30);
        add(addBtn);

        JButton viewBtn = new JButton("View Medicines");
        viewBtn.setBounds(30, 70, 150, 30);
        add(viewBtn);

        JButton sellBtn = new JButton("Sell Medicine");
        sellBtn.setBounds(30, 110, 150, 30);
        add(sellBtn);

        outputArea = new JTextArea();
        outputArea.setBounds(200, 30, 260, 280);
        outputArea.setEditable(false);
        add(outputArea);

        addBtn.addActionListener(e -> addMedicine());
        viewBtn.addActionListener(e -> viewMedicines());
        sellBtn.addActionListener(e -> sellMedicine());

        setVisible(true);
        
    }

    /**
     * Adds a sample medicine
     */
    private void addMedicine() {
        Medicine med = new Medicine(
                101,
                "Paracetamol",
                MedicineCategory.TABLET,
                10.5,
                50,
                LocalDate.of(2027, 5, 1));
                
              Medicine med1 = new Medicine(
                102,
                "surup",
                MedicineCategory.SYRUP,
                190.5,
                70,
                LocalDate.of(2029, 12, 13)

        );
        service.addMedicine(med);
         service.addMedicine(med1);

        outputArea.setText("Medicine added successfully.\n");
    }

    /**
     * Displays all medicines
     */
    private void viewMedicines() {
        outputArea.setText("");
        service.viewMedicines(); // console
        outputArea.append("Check console output.\n");
    }

/**
 * Sells medicine and handles possible exceptions
 */
private void sellMedicine() {
    try {
        service.sellMedicine(101, 5);
        outputArea.append("Medicine sold successfully.\n");
    } catch (Exception e) {
        // Handles OutOfStockException or ExpiredMedicineException
        outputArea.append("Error: " + e.getMessage() + "\n");
    }
}}

