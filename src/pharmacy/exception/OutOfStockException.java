package pharmacy.exception;

// Thrown when medicine is expired
 
public class OutOfStockException extends Exception {
    public OutOfStockException(String message) {
        super(message);
    }
}
