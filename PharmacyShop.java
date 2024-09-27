import java.util.ArrayList;
public class PharmacyShop {
    private Person owner;
    private Address address;
    private ArrayList<Medicine> medicines = new ArrayList<>();
    private double totalRevenue = 0.0;
    public PharmacyShop(Person owner, Address address) {
        this.owner = owner;
        this.address = address;
    }
    public void addMedicine(Medicine medicine) {
        medicines.add(medicine);
    }
    public void removeMedicine(String medicineId) {
        medicines.removeIf(medicine -> medicine.getMedicineId().equals(medicineId));
    }
    public void displayMedicines() {
        for (Medicine medicine : medicines) {
            medicine.displayMedicineInfo();
        }
    }
    public void sellMedicine(String medicineId, int quantity) {
        for (Medicine medicine : medicines) {
            if (medicine.getMedicineId().equals(medicineId)) {
                if (medicine.getQuantity() >= quantity) {
                    medicine.setQuantity(medicine.getQuantity() - quantity);
                    totalRevenue += quantity * medicine.getPrice();
                    System.out.println("Medicine sold: " + quantity + " units.");
                } else {
                    System.out.println("Insufficient stock!");
                }
                return;
            }
        }
        System.out.println("Medicine not found!");
    }
    public void printTotalRevenue() {
        System.out.println("Total Revenue: " + totalRevenue);
    }
    public void listExpiredMedicines(Date currentDate) {
        for (Medicine medicine : medicines) {
            if (medicine.isExpired(currentDate)) {
                medicine.displayMedicineInfo();
            }
        }
    }
}
