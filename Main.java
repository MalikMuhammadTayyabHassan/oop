import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Person owner = new Person("Ahmed Khan", "03001234567");
        Address address = new Address("123 Street", "Karachi", "75000");
        PharmacyShop shop = new PharmacyShop(owner, address);
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nPharmacy Menu");
            System.out.println("1. Add Medicine");
            System.out.println("2. Remove Medicine");
            System.out.println("3. Sell Medicine");
            System.out.println("4. Display Medicines");
            System.out.println("5. Display Total Revenue");
            System.out.println("6. List Expired Medicines");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    
                    System.out.print("Enter Medicine ID: ");
                    String id = scanner.nextLine();

                    System.out.print("Enter Medicine Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Medicine Price: ");
                    double price = scanner.nextDouble();

                    System.out.print("Enter Medicine Quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    System.out.print("Enter Manufacturer: ");
                    String manufacturer = scanner.nextLine();

                    System.out.print("Enter Batch Number: ");
                    String batchNumber = scanner.nextLine();

                    System.out.print("Enter Expiry Date (dd mm yyyy): ");
                    int day = scanner.nextInt();
                    int month = scanner.nextInt();
                    int year = scanner.nextInt();

                    
                    Date expiryDate = new Date(day, month, year);

                   
                    Medicine newMedicine = new Medicine(id, name, price, quantity, manufacturer, batchNumber, expiryDate);

                    shop.addMedicine(newMedicine);

                    System.out.println("Medicine added successfully!");
                    break;

                case 2:
                   
                    System.out.print("Enter Medicine ID to remove: ");
                    String removeId = scanner.nextLine();
                    shop.removeMedicine(removeId);
                    System.out.println("Medicine removed successfully!");
                    break;

                case 3:
                    
                    System.out.print("Enter Medicine ID to sell: ");
                    String sellId = scanner.nextLine();
                    System.out.print("Enter quantity to sell: ");
                    int sellQuantity = scanner.nextInt();
                    shop.sellMedicine(sellId, sellQuantity);
                    break;

                case 4:
                    
                    shop.displayMedicines();
                    break;

                case 5:
                   
                    shop.printTotalRevenue();
                    break;

                case 6:
                   
                    System.out.print("Enter today's date (dd mm yyyy): ");
                    int currentDay = scanner.nextInt();
                    int currentMonth = scanner.nextInt();
                    int currentYear = scanner.nextInt();
                    Date currentDate = new Date(currentDay, currentMonth, currentYear);

                    
                    shop.listExpiredMedicines(currentDate);
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
