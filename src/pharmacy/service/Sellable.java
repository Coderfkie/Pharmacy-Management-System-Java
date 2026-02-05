package pharmacy.service;

import pharmacy.exception.OutOfStockException;
import pharmacy.exception.ExpiredMedicineException;
/**
 * selleable is Interface for selling medicines
 */
public interface Sellable {
    void sell(int id, int quantity)
            throws OutOfStockException, ExpiredMedicineException;
}
