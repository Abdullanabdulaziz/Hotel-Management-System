/**
 * Booking.java
 * Represents a booking connecting Guest and Room (Association).
 */

public class Booking {
    
    private final String bookingId; // Unique booking ID
    private final Guest guest;            // The guest
    private final Room room;              // The room
    private final int numberOfNights;     // Number of nights
    private final double totalPrice;      // Total price
    private boolean isActive;       // Status
    
    private static int bookingCounter = 1;
    
    /**
     * Default constructor
     */
    public Booking() {
        this.bookingId = "B" + String.format("%04d", bookingCounter++);
        this.guest = new Guest();
        this.room = new Room();
        this.numberOfNights = 1;
        this.totalPrice = 0.0;
        this.isActive = false;
    }
    
    /**
     * Parameterized constructor
     */
    public Booking(Guest guest, Room room, int numberOfNights) {
        this.bookingId = "B" + String.format("%04d", bookingCounter++);
        this.guest = guest;
        this.room = room;
        this.numberOfNights = numberOfNights;
        this.isActive = true;
        
        // Calculate price with discount
        double discount = guest.calculateDiscount();
        this.totalPrice = room.calculatePrice(numberOfNights, discount);
    }
    
    /**
     * Display booking details
     */
    public void displayBookingDetails() {
        System.out.println("=== BOOKING ===");
        System.out.println("ID: " + bookingId);
        System.out.println("Guest: " + guest.getName());
        System.out.println("Room: " + room.getRoomNumber());
        System.out.println("Nights: " + numberOfNights);
        System.out.println("Total: $" + totalPrice);
        System.out.println("Status: " + (isActive ? "Active" : "Cancelled"));
        System.out.println("==============");
    }
    
    /**
     * Cancel booking
     */
    public void cancelBooking() {
        if (isActive) {
            isActive = false;
            room.checkoutRoom();
            System.out.println("Booking " + bookingId + " cancelled.");
        }
    }
    
    /**
     * Method overloading - confirm booking
     */
    public void confirmBooking() {
        if (isActive && room.bookRoom()) {
            System.out.println("Booking " + bookingId + " confirmed!");
        }
    }
    
    /**
     * Method overloading - confirm with message
     */
    public void confirmBooking(String message) {
        confirmBooking();
        System.out.println("Message: " + message);
    }
    
    // Getters and Setters
    public String getBookingId() {
        return bookingId;
    }
    
    public Guest getGuest() {
        return guest;
    }
    
    public Room getRoom() {
        return room;
    }
    
    public int getNumberOfNights() {
        return numberOfNights;
    }
    
    public double getTotalPrice() {
        return totalPrice;
    }
    
    public boolean isActive() {
        return isActive;
    }
}
