public class Medicine {
    private String medicineId;
    private String name;
    private double price;
    private int quantity;
    private String manufacturer;
    private String batchNumber;
    private Date expiryDate;
    public Medicine(String medicineId, String name, double price, int quantity, String manufacturer, String batchNumber, Date expiryDate) {
        this.medicineId = medicineId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.manufacturer = manufacturer;
        this.batchNumber = batchNumber;
        this.expiryDate = expiryDate;
    }
    public String getMedicineId() {
        return medicineId;
    }
    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void displayMedicineInfo() {
        System.out.println("ID: " + medicineId + ", Name: " + name + ", Price: " + price +
                ", Quantity: " + quantity + ", Manufacturer: " + manufacturer +
                ", Batch Number: " + batchNumber + ", Expiry Date: " + expiryDate);
    }
    public boolean isExpired(Date currentDate) {
        if (expiryDate.getYear() < currentDate.getYear()) return true;
        if (expiryDate.getYear() == currentDate.getYear() && expiryDate.getMonth() < currentDate.getMonth()) return true;
        return expiryDate.getYear() == currentDate.getYear() && expiryDate.getMonth() == currentDate.getMonth() && expiryDate.getDay() < currentDate.getDay();
    }
}
