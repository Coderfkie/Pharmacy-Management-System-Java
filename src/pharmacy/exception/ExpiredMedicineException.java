package pharmacy.exception;

//Thrown when medicine quantity is insufficient

public class ExpiredMedicineException extends Exception {
    public ExpiredMedicineException(String message) {
        super(message);
    }
}
