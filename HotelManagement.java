/**
 * HotelManagement.java
 * Main class with menu and ArrayList usage.
 */

import java.util.ArrayList; // Dynamic array implementation for storing collections
import java.util.Scanner;    // User input handling from console

public class HotelManagement {
    
    // ===== INSTANCE VARIABLES =====
    // ArrayLists to store different entities in the hotel system
    // Using ArrayList allows dynamic resizing and easy management of collections
    private final ArrayList<Guest> guests;     // Stores all registered guests
    private final ArrayList<Employee> employees; // Stores all hotel employees
    private final ArrayList<Room> rooms;       // Stores all hotel rooms
    private final ArrayList<Booking> bookings; // Stores all booking records
    private final Scanner scanner;             // Scanner for user input throughout the program
    
    /**
     * Default constructor - initializes all ArrayLists and creates a new Scanner
     * Sets up the hotel management system with empty collections
     */
    public HotelManagement() {
        // Initialize all ArrayLists as empty collections
        guests = new ArrayList<>();     // Empty list for guests
        employees = new ArrayList<>();  // Empty list for employees
        rooms = new ArrayList<>();      // Empty list for rooms
        bookings = new ArrayList<>();   // Empty list for bookings
        scanner = new Scanner(System.in); // Create scanner for console input
    }
    
    /**
     * Constructor with Scanner parameter - allows dependency injection
     * Useful for testing or when sharing a Scanner between multiple classes
     * @param scanner The Scanner object to use for user input
     */
    public HotelManagement(Scanner scanner) {
        // Initialize all ArrayLists as empty collections
        guests = new ArrayList<>();     // Empty list for guests
        employees = new ArrayList<>();  // Empty list for employees
        rooms = new ArrayList<>();      // Empty list for rooms
        bookings = new ArrayList<>();   // Empty list for bookings
        this.scanner = scanner;        // Use the provided scanner instead of creating new one
    }
    
    /**
     * Main method - entry point of the application
     * Creates the hotel management system and starts the main menu
     * Uses try-with-resources to ensure Scanner is properly closed
     * @param args Command line arguments (not used in this application)
     */
    public static void main(String[] args) {
        // Use try-with-resources to automatically close the Scanner when done
        try (Scanner scanner = new Scanner(System.in)) {
            HotelManagement hotel = new HotelManagement(scanner); // Create hotel system instance
            System.out.println("=== HOTEL MANAGEMENT SYSTEM ==="); // Display welcome message
            hotel.runMainMenu(); // Start the main menu loop
        } // Scanner is automatically closed here
    }
    
    /**
     * Main menu loop - displays options and handles user choices
     * Continues running until user chooses to exit (option 7)
     * Uses do-while loop to ensure menu displays at least once
     */
    public void runMainMenu() {
        int choice; // Stores user's menu selection
        
        do {
            // Display menu options
            System.out.println("\n=== MENU ===");
            System.out.println("1. Add Guest");      // Add new guest to system
            System.out.println("2. Add Employee");   // Add new employee to system
            System.out.println("3. Add Room");       // Add new room to system
            System.out.println("4. Make Booking");   // Create new booking
            System.out.println("5. Display All");    // Show all system data
            System.out.println("6. Cancel Booking"); // Cancel existing booking
            System.out.println("7. Exit");           // Exit the application
            System.out.print("Choice: ");
            
            // Get user input
            choice = scanner.nextInt();  // Read integer choice
            scanner.nextLine();          // Consume newline character left by nextInt()
            
            // Process user choice using switch statement with arrow syntax (Java 14+)
            switch (choice) {
                case 1 -> addGuest();       // Navigate to guest creation
                case 2 -> addEmployee();    // Navigate to employee creation
                case 3 -> addRoom();        // Navigate to room creation
                case 4 -> makeBooking();    // Navigate to booking creation
                case 5 -> displayAll();     // Display all system information
                case 6 -> cancelBooking();  // Navigate to booking cancellation
                case 7 -> System.out.println("Goodbye!"); // Exit message
                default -> System.out.println("Invalid choice!"); // Handle invalid input
            }
            
        } while (choice != 7); // Continue loop until user chooses to exit
    }
    
    /**
     * Add a new guest to the system
     * Collects guest information from user input and creates a Guest object
     */
    public void addGuest() {
        System.out.println("\n--- ADD GUEST ---");
        System.out.print("Name: ");
        String name = scanner.nextLine();      // Read guest's full name
        System.out.print("Phone: ");
        String phone = scanner.nextLine();     // Read contact phone number
        System.out.print("Age: ");
        int age = scanner.nextInt();           // Read age as integer
        scanner.nextLine();                    // Consume newline
        System.out.print("VIP (true/false): ");
        boolean isVIP = scanner.nextBoolean(); // Read VIP status as boolean
        scanner.nextLine();                    // Consume newline
        
        // Create new Guest object with collected information
        guests.add(new Guest(name, phone, age, isVIP));
        System.out.println("Guest added!"); // Confirm successful addition
    }
    
    /**
     * Add a new employee to the system
     * Collects employee information including position and salary
     */
    public void addEmployee() {
        System.out.println("\n--- ADD EMPLOYEE ---");
        System.out.print("Name: ");
        String name = scanner.nextLine();      // Read employee's full name
        System.out.print("Phone: ");
        String phone = scanner.nextLine();     // Read contact phone number
        System.out.print("Age: ");
        int age = scanner.nextInt();           // Read age as integer
        scanner.nextLine();                    // Consume newline
        System.out.print("Position: ");
        String position = scanner.nextLine();  // Read job position/title
        System.out.print("Salary: ");
        double salary = scanner.nextDouble();  // Read salary as double
        scanner.nextLine();                    // Consume newline
        
        // Create new Employee object with collected information
        employees.add(new Employee(name, phone, age, position, salary));
        System.out.println("Employee added!"); // Confirm successful addition
    }
    
    /**
     * Add a new room to the system
     * Collects room information including number, type, and pricing
     */
    public void addRoom() {
        System.out.println("\n--- ADD ROOM ---");
        System.out.print("Room Number: ");
        int roomNum = scanner.nextInt();      // Read room number as integer
        scanner.nextLine();                    // Consume newline
        System.out.print("Type: ");
        String roomType = scanner.nextLine(); // Read room type (e.g., Single, Double, Suite)
        System.out.print("Price per night: ");
        double price = scanner.nextDouble();  // Read nightly rate as double
        scanner.nextLine();                    // Consume newline
        
        // Create new Room object with collected information
        rooms.add(new Room(roomNum, roomType, price));
        System.out.println("Room added!"); // Confirm successful addition
    }
    
    /**
     * Create a new booking by selecting a guest, room, and number of nights
     * Validates that guests and rooms exist before proceeding
     */
    public void makeBooking() {
        System.out.println("\n--- MAKE BOOKING ---");
        
        // Validate that we have both guests and rooms to make a booking
        if (guests.isEmpty() || rooms.isEmpty()) {
            System.out.println("Add guests and rooms first!"); // Early validation
            return; // Exit method if prerequisites not met
        }
        
        // Display available guests for selection
        System.out.println("\nGuests:");
        for (int i = 0; i < guests.size(); i++) {
            System.out.println((i + 1) + ". " + guests.get(i).getName()); // Show guest names
        }
        System.out.print("Select guest: ");
        int guestIndex = scanner.nextInt() - 1; // Convert to 0-based index
        scanner.nextLine(); // Consume newline
        
        // Display only available rooms (not currently booked)
        System.out.println("\nAvailable Rooms:");
        for (int i = 0; i < rooms.size(); i++) {
            Room room = rooms.get(i);
            if (room.isAvailable()) { // Only show rooms that are free
                System.out.println((i + 1) + ". Room " + room.getRoomNumber() + 
                                   " - $" + room.getPricePerNight());
            }
        }
        System.out.print("Select room: ");
        int roomIndex = scanner.nextInt() - 1; // Convert to 0-based index
        scanner.nextLine(); // Consume newline
        
        // Get booking duration
        System.out.print("Nights: ");
        int nights = scanner.nextInt(); // Read number of nights
        scanner.nextLine(); // Consume newline
        
        // Create and confirm the booking
        Booking booking = new Booking(guests.get(guestIndex), rooms.get(roomIndex), nights);
        booking.confirmBooking(); // Mark booking as confirmed
        bookings.add(booking); // Add to bookings list
        System.out.println("Booking created!"); // Confirm success
    }
    
    /**
     * Display all information in the system
     * Shows guests, employees, rooms, and bookings in organized sections
     */
    public void displayAll() {
        // Display all guests with their information
        System.out.println("\n--- GUESTS ---");
        for (Guest guest : guests) {
            guest.displayInfo(); // Use polymorphic method to display guest details
            System.out.println(); // Add spacing between entries
        }
        
        // Display all employees with their information
        System.out.println("--- EMPLOYEES ---");
        for (Employee employee : employees) {
            employee.displayInfo(); // Use polymorphic method to display employee details
            System.out.println(); // Add spacing between entries
        }
        
        // Display all rooms with their current status
        System.out.println("--- ROOMS ---");
        for (Room room : rooms) {
            room.displayInfo(); // Display room details including availability
            System.out.println(); // Add spacing between entries
        }
        
        // Display all bookings with their details
        System.out.println("--- BOOKINGS ---");
        for (Booking booking : bookings) {
            booking.displayBookingDetails(); // Show comprehensive booking information
            System.out.println(); // Add spacing between entries
        }
    }
    
    /**
     * Cancel an existing booking
     * Shows only active bookings and allows user to select one for cancellation
     */
    public void cancelBooking() {
        System.out.println("\n--- CANCEL BOOKING ---");
        
        // Check if there are any bookings to cancel
        if (bookings.isEmpty()) {
            System.out.println("No bookings found."); // Inform user if no bookings exist
            return; // Exit method early
        }
        
        // Display only active (not cancelled) bookings
        for (int i = 0; i < bookings.size(); i++) {
            Booking booking = bookings.get(i);
            if (booking.isActive()) { // Only show bookings that are still active
                System.out.println((i + 1) + ". " + booking.getBookingId());
            }
        }
        
        // Get user selection for which booking to cancel
        System.out.print("Select booking: ");
        int index = scanner.nextInt() - 1; // Convert to 0-based index
        scanner.nextLine(); // Consume newline
        
        // Validate index and cancel the booking if valid
        if (index >= 0 && index < bookings.size()) {
            bookings.get(index).cancelBooking(); // Call the booking's cancel method
        }
    }
}
