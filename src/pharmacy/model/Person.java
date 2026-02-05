package pharmacy.model;
/**
 * Abstract parent class
 * We use abstraction and inheritance
 */
public abstract class Person {
    
    // Protected fields accessible by subclasses

    protected String name;
    protected String phone;
    /**
     * Parameterized constructor
     */
    public Person(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
 
   //Abstract method to be overridden by child classes
    public abstract void displayInfo();
}

