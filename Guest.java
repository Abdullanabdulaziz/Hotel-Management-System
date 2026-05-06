/**
 * Guest.java
 * Represents a hotel guest. Extends Person (Inheritance).
 */

public class Guest extends Person {
    
    private boolean isVIP; // VIP status
    
    /**
     * Default constructor
     */
    public Guest() {
        super();
        this.isVIP = false;
    }
    
    /**
     * Parameterized constructor
     */
    public Guest(String name, String phoneNumber, int age, boolean isVIP) {
        super(name, phoneNumber, age);
        this.isVIP = isVIP;
    }
    
    /**
     * Override abstract method from Person
     */
    @Override
    public String getRole() {
        return "Guest";
    }
    
    /**
     * Override displayInfo method
     */
    @Override
    public void displayInfo() {
        System.out.println("=== GUEST ===");
        super.displayInfo();
        System.out.println("VIP: " + (isVIP ? "Yes" : "No"));
        System.out.println("============");
    }
    
    /**
     * Method overloading - calculate discount
     */
    public double calculateDiscount() {
        return isVIP ? 10.0 : 0.0;
    }
    
    /**
     * Method overloading - calculate discount with base
     */
    public double calculateDiscount(double baseDiscount) {
        return isVIP ? baseDiscount + 10.0 : baseDiscount;
    }
    
    // Getters and Setters
    public boolean isVIP() {
        return isVIP;
    }
    
    public void setVIP(boolean isVIP) {
        this.isVIP = isVIP;
    }
}
