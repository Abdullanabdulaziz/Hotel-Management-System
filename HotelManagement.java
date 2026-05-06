/**
 * HotelManagement.java
 * This is the main class of the Hotel Management System.
 * It uses ArrayList to store guests, employees, rooms, and bookings.
 * This class demonstrates the use of ArrayList as required.
 * It provides a console-based menu for user interaction using Scanner.
 */

import java.util.ArrayList; // Import ArrayList class
import java.util.Scanner;   // Import Scanner class for user input

public class HotelManagement {
    
    // ArrayList to store all guests in the hotel
    // ArrayList is a dynamic array that can grow as needed
    private final ArrayList<Guest> guests;
    
    // ArrayList to store all employees in the hotel
    private final ArrayList<Employee> employees;
    
    // ArrayList to store all rooms in the hotel
    private final ArrayList<Room> rooms;
    
    // ArrayList to store all bookings
    private final ArrayList<Booking> bookings;
    
    // Scanner object for reading user input
    private final Scanner scanner;
    
    /**
     * Constructor - initializes all ArrayLists and Scanner
     */
    public HotelManagement() {
        // Initialize all ArrayLists
        guests = new ArrayList<>();
        employees = new ArrayList<>();
        rooms = new ArrayList<>();
        bookings = new ArrayList<>();
        
        // Initialize Scanner for user input
        scanner = new Scanner(System.in);
    }
    
    /**
     * Constructor that accepts a Scanner parameter
     * Used for try-with-resources pattern
     * @param scanner The Scanner object to use for input
     */
    public HotelManagement(Scanner scanner) {
        // Initialize all ArrayLists
        guests = new ArrayList<>();
        employees = new ArrayList<>();
        rooms = new ArrayList<>();
        bookings = new ArrayList<>();
        
        // Use the provided Scanner
        this.scanner = scanner;
    }
    
    /**
     * Main method - entry point of the program
     * This is where the program starts execution
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Use try-with-resources to automatically close the Scanner
        try (Scanner scanner = new Scanner(System.in)) {
            // Create an instance of HotelManagement
            HotelManagement hotel = new HotelManagement(scanner);
            
            // Display welcome message
            System.out.println("===========================================");
            System.out.println("   WELCOME TO HOTEL MANAGEMENT SYSTEM");
            System.out.println("===========================================");
            System.out.println();
            
            // Run the main menu
            hotel.runMainMenu();
        }
    }
    
    /**
     * Method to display and handle the main menu
     * This is the main loop of the program
     */
    public void runMainMenu() {
        int choice;
        
        do {
            // Display menu options
            System.out.println("\n====== MAIN MENU ======");
            System.out.println("1. Add Guest");
            System.out.println("2. Add Employee");
            System.out.println("3. Add Room");
            System.out.println("4. Make Booking");
            System.out.println("5. Display All Guests");
            System.out.println("6. Display All Employees");
            System.out.println("7. Display All Rooms");
            System.out.println("8. Display All Bookings");
            System.out.println("9. Cancel Booking");
            System.out.println("10. Exit");
            System.out.println("========================");
            System.out.print("Enter your choice: ");
            
            // Read user choice
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
            
            // Handle user choice using enhanced switch statement
            switch (choice) {
                case 1 -> addGuest();
                case 2 -> addEmployee();
                case 3 -> addRoom();
                case 4 -> makeBooking();
                case 5 -> displayAllGuests();
                case 6 -> displayAllEmployees();
                case 7 -> displayAllRooms();
                case 8 -> displayAllBookings();
                case 9 -> cancelBooking();
                case 10 -> System.out.println("Thank you for using Hotel Management System!");
                default -> System.out.println("Invalid choice! Please try again.");
            }
            
        } while (choice != 10); // Loop until user chooses to exit
    }
    
    /**
     * Method to add a new guest
     * Demonstrates adding objects to ArrayList
     */
    public void addGuest() {
        System.out.println("\n--- ADD NEW GUEST ---");
        
        System.out.print("Enter guest name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();
        
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        
        System.out.print("Is VIP guest? (true/false): ");
        boolean isVIP = scanner.nextBoolean();
        scanner.nextLine(); // Consume newline
        
        // Create new Guest object
        Guest guest = new Guest(name, phone, age, email, address, isVIP);
        
        // Add guest to ArrayList
        guests.add(guest);
        
        System.out.println("\nGuest added successfully!");
        System.out.println("Total guests: " + guests.size());
    }
    
    /**
     * Method to add a new employee
     * Demonstrates adding objects to ArrayList
     */
    public void addEmployee() {
        System.out.println("\n--- ADD NEW EMPLOYEE ---");
        
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();
        
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        System.out.print("Enter employee ID: ");
        String empId = scanner.nextLine();
        
        System.out.print("Enter position: ");
        String position = scanner.nextLine();
        
        System.out.print("Enter salary: ");
        double salary = scanner.nextDouble();
        
        System.out.print("Enter years of experience: ");
        int years = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        // Create new Employee object
        Employee employee = new Employee(name, phone, age, empId, position, salary, years);
        
        // Add employee to ArrayList
        employees.add(employee);
        
        System.out.println("\nEmployee added successfully!");
        System.out.println("Total employees: " + employees.size());
    }
    
    /**
     * Method to add a new room
     * Demonstrates adding objects to ArrayList
     */
    public void addRoom() {
        System.out.println("\n--- ADD NEW ROOM ---");
        
        System.out.print("Enter room number: ");
        int roomNum = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        System.out.print("Enter room type (Single/Double/Suite): ");
        String roomType = scanner.nextLine();
        
        System.out.print("Enter price per night: ");
        double price = scanner.nextDouble();
        
        System.out.print("Enter capacity (number of guests): ");
        int capacity = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        // Create new Room object
        Room room = new Room(roomNum, roomType, price, capacity);
        
        // Add room to ArrayList
        rooms.add(room);
        
        System.out.println("\nRoom added successfully!");
        System.out.println("Total rooms: " + rooms.size());
    }
    
    /**
     * Method to make a booking
     * Demonstrates relationship between Guest and Room through Booking
     */
    public void makeBooking() {
        System.out.println("\n--- MAKE BOOKING ---");
        
        // Check if we have guests and rooms
        if (guests.isEmpty()) {
            System.out.println("No guests available! Please add a guest first.");
            return;
        }
        
        if (rooms.isEmpty()) {
            System.out.println("No rooms available! Please add a room first.");
            return;
        }
        
        // Display available guests
        System.out.println("\nAvailable Guests:");
        for (int i = 0; i < guests.size(); i++) {
            System.out.println((i + 1) + ". " + guests.get(i).getName());
        }
        
        System.out.print("\nSelect guest (enter number): ");
        int guestIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline
        
        if (guestIndex < 0 || guestIndex >= guests.size()) {
            System.out.println("Invalid guest selection!");
            return;
        }
        
        // Display available rooms
        System.out.println("\nAvailable Rooms:");
        for (int i = 0; i < rooms.size(); i++) {
            Room room = rooms.get(i);
            if (room.isAvailable()) {
                System.out.println((i + 1) + ". Room " + room.getRoomNumber() + 
                                   " - " + room.getRoomType() + 
                                   " - $" + room.getPricePerNight() + "/night");
            }
        }
        
        System.out.print("\nSelect room (enter number): ");
        int roomIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline
        
        if (roomIndex < 0 || roomIndex >= rooms.size()) {
            System.out.println("Invalid room selection!");
            return;
        }
        
        if (!rooms.get(roomIndex).isAvailable()) {
            System.out.println("Selected room is not available!");
            return;
        }
        
        System.out.print("Enter number of nights: ");
        int nights = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        System.out.print("Enter check-in date: ");
        String checkIn = scanner.nextLine();
        
        System.out.print("Enter check-out date: ");
        String checkOut = scanner.nextLine();
        
        // Create new Booking object
        Booking booking = new Booking(guests.get(guestIndex), 
                                       rooms.get(roomIndex), 
                                       nights, checkIn, checkOut);
        
        // Confirm the booking
        booking.confirmBooking();
        
        // Add booking to ArrayList
        bookings.add(booking);
        
        System.out.println("\nBooking created successfully!");
        System.out.println("Total bookings: " + bookings.size());
    }
    
    /**
     * Method to display all guests
     * Demonstrates iterating through ArrayList
     */
    public void displayAllGuests() {
        System.out.println("\n--- ALL GUESTS ---");
        
        if (guests.isEmpty()) {
            System.out.println("No guests found.");
            return;
        }
        
        // Loop through ArrayList using for-each loop
        for (Guest guest : guests) {
            guest.displayInfo();
            System.out.println();
        }
    }
    
    /**
     * Method to display all employees
     * Demonstrates iterating through ArrayList
     */
    public void displayAllEmployees() {
        System.out.println("\n--- ALL EMPLOYEES ---");
        
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        
        // Loop through ArrayList using for-each loop
        for (Employee employee : employees) {
            employee.displayInfo();
            System.out.println();
        }
    }
    
    /**
     * Method to display all rooms
     * Demonstrates iterating through ArrayList
     */
    public void displayAllRooms() {
        System.out.println("\n--- ALL ROOMS ---");
        
        if (rooms.isEmpty()) {
            System.out.println("No rooms found.");
            return;
        }
        
        // Loop through ArrayList using for-each loop
        for (Room room : rooms) {
            room.displayInfo();
            System.out.println();
        }
    }
    
    /**
     * Method to display all bookings
     * Demonstrates iterating through ArrayList
     */
    public void displayAllBookings() {
        System.out.println("\n--- ALL BOOKINGS ---");
        
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }
        
        // Loop through ArrayList using for-each loop
        for (Booking booking : bookings) {
            booking.displayBookingDetails();
            System.out.println();
        }
    }
    
    /**
     * Method to cancel a booking
     * Demonstrates removing objects from ArrayList
     */
    public void cancelBooking() {
        System.out.println("\n--- CANCEL BOOKING ---");
        
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }
        
        // Display active bookings
        System.out.println("Active Bookings:");
        for (int i = 0; i < bookings.size(); i++) {
            Booking booking = bookings.get(i);
            if (booking.isActive()) {
                System.out.println((i + 1) + ". " + booking.getBookingId() + 
                                   " - " + booking.getGuest().getName() + 
                                   " - Room " + booking.getRoom().getRoomNumber());
            }
        }
        
        System.out.print("\nSelect booking to cancel (enter number): ");
        int bookingIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline
        
        if (bookingIndex < 0 || bookingIndex >= bookings.size()) {
            System.out.println("Invalid booking selection!");
            return;
        }
        
        // Cancel the booking
        bookings.get(bookingIndex).cancelBooking();
    }
}
