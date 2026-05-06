/**
 * Room.java
 * This class represents a hotel room.
 * It contains information about the room type, price, and availability.
 */

public class Room {
    
    // Private attributes for encapsulation
    private int roomNumber;      // Unique room number
    private String roomType;     // Type of room (e.g., Single, Double, Suite)
    private double pricePerNight; // Price per night in dollars
    private boolean isAvailable;  // Availability status of the room
    private int capacity;        // Maximum number of guests allowed
    
    /**
     * Default constructor - initializes with default values
     */
    public Room() {
        this.roomNumber = 0;
        this.roomType = "Standard";
        this.pricePerNight = 100.0;
        this.isAvailable = true;
        this.capacity = 2;
    }
    
    /**
     * Parameterized constructor - initializes with given values
     * @param roomNumber The unique room number
     * @param roomType The type of room
     * @param pricePerNight The price per night
     * @param capacity The maximum capacity of guests
     */
    public Room(int roomNumber, String roomType, double pricePerNight, int capacity) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.capacity = capacity;
        this.isAvailable = true; // By default, room is available
    }
    
    /**
     * Method to display room information
     */
    public void displayInfo() {
        System.out.println("=== ROOM INFORMATION ===");
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Room Type: " + roomType);
        System.out.println("Price per Night: $" + pricePerNight);
        System.out.println("Capacity: " + capacity + " guests");
        System.out.println("Status: " + (isAvailable ? "Available" : "Booked"));
        System.out.println("========================");
    }
    
    /**
     * Method to book the room
     * @return true if booking successful, false if room is already booked
     */
    public boolean bookRoom() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Room " + roomNumber + " has been booked successfully!");
            return true;
        } else {
            System.out.println("Sorry, Room " + roomNumber + " is already booked.");
            return false;
        }
    }
    
    /**
     * Method to check out and make room available again
     */
    public void checkoutRoom() {
        isAvailable = true;
        System.out.println("Room " + roomNumber + " is now available for booking.");
    }
    
    /**
     * Method overloading example - calculate total price
     * This is the first version with nights parameter only
     * @param nights Number of nights to stay
     * @return Total price for the stay
     */
    public double calculateTotalPrice(int nights) {
        return pricePerNight * nights;
    }
    
    /**
     * Method overloading example - calculate total price with discount
     * This is the second version with nights and discount percentage
     * @param nights Number of nights to stay
     * @param discountPercentage Discount percentage to apply
     * @return Total price after discount
     */
    public double calculateTotalPrice(int nights, double discountPercentage) {
        double totalPrice = pricePerNight * nights;
        double discountAmount = totalPrice * (discountPercentage / 100.0);
        return totalPrice - discountAmount;
    }
    
    /**
     * Method to check if room is suitable for given number of guests
     * @param numberOfGuests Number of guests
     * @return true if room can accommodate the guests
     */
    public boolean canAccommodate(int numberOfGuests) {
        return capacity >= numberOfGuests;
    }
    
    // Getter and Setter methods
    
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
    
    public int getCapacity() {
        return capacity;
    }
    
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
