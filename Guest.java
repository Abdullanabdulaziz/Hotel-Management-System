/**
 * Guest.java
 * This class represents a guest in the hotel.
 * It extends the Person class, demonstrating inheritance.
 * A guest is a specific type of person who stays at the hotel.
 */

public class Guest extends Person {
    
    // Private attributes specific to Guest class
    private String email;          // Email address of the guest
    private String address;        // Home address of the guest
    private boolean isVIP;         // VIP status of the guest
    
    /**
     * Default constructor - initializes with default values
     */
    public Guest() {
        super(); // Call the default constructor of parent class Person
        this.email = "Not provided";
        this.address = "Not provided";
        this.isVIP = false;
    }
    
    /**
     * Parameterized constructor - initializes with given values
     * @param name The name of the guest
     * @param phoneNumber The phone number of the guest
     * @param age The age of the guest
     * @param email The email of the guest
     * @param address The address of the guest
     * @param isVIP The VIP status of the guest
     */
    public Guest(String name, String phoneNumber, int age, String email, String address, boolean isVIP) {
        super(name, phoneNumber, age); // Call the parameterized constructor of parent class Person
        this.email = email;
        this.address = address;
        this.isVIP = isVIP;
    }
    
    /**
     * Implementation of the abstract method from Person class
     * This demonstrates method override (implementing abstract method)
     * @return The role of this person as a string
     */
    @Override
    public String getRole() {
        return "Guest";
    }
    
    /**
     * Override the displayInfo method from Person class
     * This demonstrates method override - providing specific implementation for Guest
     */
    @Override
    public void displayInfo() {
        System.out.println("=== GUEST INFORMATION ===");
        super.displayInfo(); // Call the parent class displayInfo method
        System.out.println("Email: " + email);
        System.out.println("Address: " + address);
        System.out.println("VIP Status: " + (isVIP ? "Yes" : "No"));
        System.out.println("==========================");
    }
    
    /**
     * Method to check if the guest is a VIP
     * @return true if VIP, false otherwise
     */
    public boolean isVIP() {
        return isVIP;
    }
    
    /**
     * Method to set VIP status
     * @param isVIP The new VIP status
     */
    public void setVIP(boolean isVIP) {
        this.isVIP = isVIP;
    }
    
    /**
     * Method overloading example - calculate discount for guest
     * This is the first version with no parameters (default discount)
     * @return The discount percentage
     */
    public double calculateDiscount() {
        if (isVIP) {
            return 10.0; // 10% discount for VIP
        } else {
            return 0.0; // No discount for regular guests
        }
    }
    
    /**
     * Method overloading example - calculate discount with custom rate
     * This is the second version with a parameter
     * @param baseDiscount The base discount to apply
     * @return The final discount percentage
     */
    public double calculateDiscount(double baseDiscount) {
        if (isVIP) {
            return baseDiscount + 10.0; // Extra 10% for VIP on top of base
        } else {
            return baseDiscount;
        }
    }
    
    // Getter and Setter methods
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
}
