/**
 * Room.java
 * Represents a hotel room.
 */

public class Room {
    
    private int roomNumber;      // Unique room number
    private String roomType;     // Type of room
    private double pricePerNight; // Price per night
    private boolean isAvailable;  // Availability status
    
    /**
     * Default constructor
     */
    public Room() {
        this.roomNumber = 0;
        this.roomType = "Standard";
        this.pricePerNight = 100.0;
        this.isAvailable = true;
    }
    
    /**
     * Parameterized constructor
     */
    public Room(int roomNumber, String roomType, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.isAvailable = true;
    }
    
    /**
     * Display room information
     */
    public void displayInfo() {
        System.out.println("=== ROOM ===");
        System.out.println("Number: " + roomNumber);
        System.out.println("Type: " + roomType);
        System.out.println("Price: $" + pricePerNight + "/night");
        System.out.println("Status: " + (isAvailable ? "Available" : "Booked"));
        System.out.println("==========");
    }
    
    /**
     * Book the room
     */
    public boolean bookRoom() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Room " + roomNumber + " booked!");
            return true;
        }
        System.out.println("Room " + roomNumber + " is already booked.");
        return false;
    }
    
    /**
     * Make room available
     */
    public void checkoutRoom() {
        isAvailable = true;
        System.out.println("Room " + roomNumber + " is now available.");
    }
    
    /**
     * Method overloading - calculate price
     */
    public double calculatePrice(int nights) {
        return pricePerNight * nights;
    }
    
    /**
     * Method overloading - calculate price with discount
     */
    public double calculatePrice(int nights, double discount) {
        return pricePerNight * nights * (1 - discount / 100.0);
    }
    
    // Getters and Setters
    public int getRoomNumber() {
        return roomNumber;
    }
    
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
    
    public String getRoomType() {
        return roomType;
    }
    
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
    
    public double getPricePerNight() {
        return pricePerNight;
    }
    
    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }
    
    public boolean isAvailable() {
        return isAvailable;
    }
    
    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
