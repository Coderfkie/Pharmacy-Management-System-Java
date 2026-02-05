package pharmacy.model;

import java.time.LocalDate;
import pharmacy.util.MedicineCategory;
/**
 * Medicine entity class
 * Demonstrates encapsulation, constructors, interface implementation
 * exception handling.
 */

public class Medicine {
    
     // Encapsulated data members
    private int medicineId;
    private String name;
    private MedicineCategory category;
    private double price;
    private int quantity;
    private LocalDate expiryDate;
    
   // Default constructor
    public Medicine() {}
    

    //  Parameterized constructor

    public Medicine(int id, String name, double price) {
        this.medicineId = id;
        this.name = name;
        this.price = price;
    }
    
     // Overloaded constructor
     
    public Medicine(int id, String name, MedicineCategory category,
                    double price, int quantity, LocalDate expiryDate) {
        this.medicineId = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
    }

    public int getMedicineId() { return medicineId; }
    public String getName() { return name; }
    public MedicineCategory getCategory() { return category; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public LocalDate getExpiryDate() { return expiryDate; }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Display info (used in polymorphism)
    
    public void display() {
        System.out.println("Medicine ID "+medicineId + " | " + "Medicine Name  "+name + " | " + category +
                " | " + "Price "+price +" Birr"+ " | Qantity: " + quantity + " | Expire date: " + expiryDate);
    }
}
