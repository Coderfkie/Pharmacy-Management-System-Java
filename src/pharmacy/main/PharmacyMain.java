package pharmacy.main;

import pharmacy.model.*;
import pharmacy.service.*;
import pharmacy.util.MedicineCategory;
import pharmacy.exception.*;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * Main execution class
 */
public class PharmacyMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MedicineService service = new MedicineService();

        Person p = new Pharmacist("Efrata", "0912345978");
        p.displayInfo();

        int choice;
      do {
    System.out.println("\n--- Pharmacy Management System ---");
    System.out.println("1. Add Medicine");
    System.out.println("2. View Medicines");
    System.out.println("3. Search Medicine");
    System.out.println("4. Update Medicine");
    System.out.println("5. Sell Medicine");
    System.out.println("6. Exit");
    System.out.print("Enter your choice: ");

    choice = sc.nextInt();


            try {
                switch (choice) {

    case 1:
        System.out.print("Medicine ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Medicine Name: ");
        String name = sc.nextLine();
        System.out.print("Category (TABLET/SYRUP/INJECTION/OINTMENT): ");
        MedicineCategory cat =
                MedicineCategory.valueOf(sc.next().toUpperCase());
        System.out.print("Price: ");
        double price = sc.nextDouble();
        System.out.print("Quantity: ");
        int qty = sc.nextInt();
        System.out.print("Expiry Year: ");
        int y = sc.nextInt();
        System.out.print("Expiry Month: ");
        int m = sc.nextInt();
        System.out.print("Expiry Day: ");
        int d = sc.nextInt();

        Medicine med = new Medicine(id, name, cat, price,
                qty, LocalDate.of(y, m, d));
        service.addMedicine(med);
        break;

    case 2:
        service.viewMedicines();
        break;

    case 3:
        System.out.print("Enter Medicine ID: ");
        int sid = sc.nextInt();
        Medicine found = service.searchMedicine(sid);
        if (found != null) found.display();
        else System.out.println("Medicine not found.");
        break;

    case 4:
        System.out.print("Enter Medicine ID to update: ");
        int uid = sc.nextInt();
        System.out.print("Enter new price: ");
        double newPrice = sc.nextDouble();
        System.out.print("Enter new quantity: ");
        int newQty = sc.nextInt();

        service.updateMedicine(uid, newPrice, newQty);
        break;

    case 5:
        System.out.print("Medicine ID: ");
        int mid = sc.nextInt();
        System.out.print("Quantity: ");
        int q = sc.nextInt();
        service.sellMedicine(mid, q);
        break;

    case 6:
        System.out.println("Thank you for using this console !!");
        break;

    default:
        System.out.println("You Enter Invalid choice.");
}

            } catch (OutOfStockException | ExpiredMedicineException e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                
            }

        } while (choice != 6);


        sc.close();
    }
}
