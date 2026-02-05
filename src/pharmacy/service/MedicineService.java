package pharmacy.service;

import pharmacy.model.Medicine;
import pharmacy.exception.*;
import java.time.LocalDate;
import java.util.*;

/**
 * Business logic class
 */
public class MedicineService implements Sellable {
    
// Data structures 
    // List to store medicines
    private ArrayList<Medicine> medicines = new ArrayList<>();
    // Map for fast searching
    private HashMap<Integer, Medicine> medicineMap = new HashMap<>();
    
    private Set<Integer> medicineIds = new HashSet<>();
    // Queue to process sales
    private Queue<String> salesQueue = new LinkedList<>();

    // ADD medicine
    public void addMedicine(Medicine m) {
        if (medicineIds.contains(m.getMedicineId())) {
            System.out.println("Duplicate Medicine ID not allowed.");
            return;
        }
        medicines.add(m);
        medicineMap.put(m.getMedicineId(), m);
        medicineIds.add(m.getMedicineId());
        System.out.println("Medicine added successfully.");
    }
 
    // VIEW medicines
    public void viewMedicines() {
        if (medicines.isEmpty()) {
            System.out.println("No medicines available.");
            return;
        }
        for (Medicine m : medicines) {
            m.display();
        }
    }
    
  // SEARCH medicine
    public Medicine searchMedicine(int id) {
        return medicineMap.get(id);
    }
    
    // UPDATE medicine
   
    public void updateMedicine(int id, double newPrice, int newQuantity) {
    Medicine m = medicineMap.get(id);

    if (m == null) {
        System.out.println("Medicine not found.");
        return;
    }

    m.setQuantity(newQuantity);
    System.out.println("Medicine updated successfully.");
}
   // SELL medicine
    
     
    public void sellMedicine(int id, int qty)
            throws OutOfStockException, ExpiredMedicineException {

        Medicine m = medicineMap.get(id);
        if (m == null) {
            System.out.println("Medicine not found.");
            return;
        }

        if (m.getExpiryDate().isBefore(LocalDate.now())) {
            throw new ExpiredMedicineException("Medicine is expired.");
        }

        if (m.getQuantity() < qty) {
            throw new OutOfStockException("Not enough stock available.");
        }

        m.setQuantity(m.getQuantity() - qty);
        salesQueue.add("Sold " + qty + " of " + m.getName());
        System.out.println("Medicine sold successfully.");
    }

    @Override
    public void sell(int id, int quantity) throws OutOfStockException, ExpiredMedicineException {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

}