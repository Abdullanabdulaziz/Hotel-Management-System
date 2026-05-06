/**
 * Booking.java
 * This class represents a booking in the hotel.
 * It establishes a relationship between a Guest and a Room (Association).
 * A booking connects a guest to a room for a specific duration.
 */

public class Booking {
    
    // Private attributes for encapsulation
    private final String bookingId;      // Unique booking ID
    private Guest guest;           // The guest who made the booking (Association with Guest class)
    private Room room;             // The room being booked (Association with Room class)
    private int numberOfNights;    // Number of nights for the stay
    private double totalPrice;     // Total price for the booking
    private String checkInDate;    // Check-in date
    private String checkOutDate;   // Check-out date
    private boolean isActive;      // Status of the booking
    
    // Static counter to generate unique booking IDs
    private static int bookingCounter = 1;
    
    /**
     * Default constructor - initializes with default values
     */
    public Booking() {
        this.bookingId = "B" + String.format("%04d", bookingCounter++);
        this.guest = new Guest();
        this.room = new Room();
        this.numberOfNights = 1;
        this.totalPrice = 0.0;
        this.checkInDate = "Not set";
        this.checkOutDate = "Not set";
        this.isActive = false;
        // Calculate total price after all fields are initialized
        // Not calling calculateTotalPrice() here to avoid overridable method call in constructor
    }
    
    /**
     * Parameterized constructor - initializes with given values
     * This demonstrates the relationship between Guest and Room classes through Booking
     * @param guest The guest making the booking
     * @param room The room to be booked
     * @param numberOfNights Number of nights
     * @param checkInDate Check-in date
     * @param checkOutDate Check-out date
     */
    public Booking(Guest guest, Room room, int numberOfNights, String checkInDate, String checkOutDate) {
        this.bookingId = "B" + String.format("%04d", bookingCounter++);
        this.guest = guest;
        this.room = room;
        this.numberOfNights = numberOfNights;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.isActive = true;
        
        // Calculate total price based on room price and guest discount
        // Calculate directly here to avoid overridable method call in constructor
        double discount = guest.calculateDiscount();
        this.totalPrice = room.calculateTotalPrice(numberOfNights, discount);
    }
    
    /**
     * Method to calculate total price for the booking
     * Takes into account guest VIP discount
     */
    public void calculateTotalPrice() {
        double discount = guest.calculateDiscount();
        totalPrice = room.calculateTotalPrice(numberOfNights, discount);
    }
    
    /**
     * Method to display booking information
     */
    public void displayBookingDetails() {
        System.out.println("=== BOOKING DETAILS ===");
        System.out.println("Booking ID: " + bookingId);
        System.out.println("Status: " + (isActive ? "Active" : "Cancelled/Completed"));
        System.out.println("\n--- Guest Information ---");
        System.out.println("Guest Name: " + guest.getName());
        System.out.println("Guest Phone: " + guest.getPhoneNumber());
        System.out.println("VIP Status: " + (guest.isVIP() ? "Yes" : "No"));
        System.out.println("\n--- Room Information ---");
        System.out.println("Room Number: " + room.getRoomNumber());
        System.out.println("Room Type: " + room.getRoomType());
        System.out.println("Price per Night: $" + room.getPricePerNight());
        System.out.println("\n--- Stay Details ---");
        System.out.println("Check-in Date: " + checkInDate);
        System.out.println("Check-out Date: " + checkOutDate);
        System.out.println("Number of Nights: " + numberOfNights);
        System.out.println("Total Price: $" + totalPrice);
        System.out.println("========================");
    }
    
    /**
     * Method to cancel the booking
     */
    public void cancelBooking() {
        if (isActive) {
            isActive = false;
            room.checkoutRoom(); // Make the room available again
            System.out.println("Booking " + bookingId + " has been cancelled.");
        } else {
            System.out.println("Booking " + bookingId + " is already cancelled/completed.");
        }
    }
    
    /**
     * Method overloading example - confirm booking
     * This is the first version with no parameters
     */
    public void confirmBooking() {
        if (isActive && room.bookRoom()) {
            System.out.println("Booking " + bookingId + " confirmed successfully!");
            System.out.println("Room " + room.getRoomNumber() + " reserved for " + guest.getName());
        } else {
            System.out.println("Could not confirm booking. Room may not be available.");
        }
    }
    
    /**
     * Method overloading example - confirm booking with special notes
     * This is the second version with a parameter for special notes
     * @param specialNotes Any special requests or notes
     */
    public void confirmBooking(String specialNotes) {
        confirmBooking(); // Call the first version
        if (!specialNotes.isEmpty()) {
            System.out.println("Special Notes: " + specialNotes);
        }
    }
    
    /**
     * Method to update booking dates
     * @param newCheckInDate New check-in date
     * @param newCheckOutDate New check-out date
     */
    public void updateDates(String newCheckInDate, String newCheckOutDate) {
        this.checkInDate = newCheckInDate;
        this.checkOutDate = newCheckOutDate;
        System.out.println("Booking dates updated for " + bookingId);
    }
    
    // Getter and Setter methods
    
    public String getBookingId() {
        return bookingId;
    }
    
    public Guest getGuest() {
        return guest;
    }
    
    public void setGuest(Guest guest) {
        this.guest = guest;
    }
    
    public Room getRoom() {
        return room;
    }
    
    public void setRoom(Room room) {
        this.room = room;
    }
    
    public int getNumberOfNights() {
        return numberOfNights;
    }
    
    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
        calculateTotalPrice(); // Recalculate price when nights change
    }
    
    public double getTotalPrice() {
        return totalPrice;
    }
    
    public String getCheckInDate() {
        return checkInDate;
    }
    
    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }
    
    public String getCheckOutDate() {
        return checkOutDate;
    }
    
    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
    
    public boolean isActive() {
        return isActive;
    }
    
    public void setActive(boolean active) {
        isActive = active;
    }
}
