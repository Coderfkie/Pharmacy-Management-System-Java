package pharmacy.model;
/**
 * pharmacist is Child class of Person
 * We use inheritance & method overriding
 */
public class Pharmacist extends Person {

    public Pharmacist(String name, String phone) {
        super(name, phone);
    }
   //Overridden method to display pharmacist details
    @Override
    public void displayInfo() {
        System.out.println("Pharmacist Name: " + name);
        System.out.println("Phone: " + phone);
    }
    
}
