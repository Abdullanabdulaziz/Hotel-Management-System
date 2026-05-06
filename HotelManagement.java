/**
 * HotelManagement.java
 * Main class with menu and ArrayList usage.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class HotelManagement {
    
    private final ArrayList<Guest> guests;
    private final ArrayList<Employee> employees;
    private final ArrayList<Room> rooms;
    private final ArrayList<Booking> bookings;
    private final Scanner scanner;
    
    /**
     * Constructor
     */
    public HotelManagement() {
        guests = new ArrayList<>();
        employees = new ArrayList<>();
        rooms = new ArrayList<>();
        bookings = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    
    /**
     * Constructor with Scanner
     */
    public HotelManagement(Scanner scanner) {
        guests = new ArrayList<>();
        employees = new ArrayList<>();
        rooms = new ArrayList<>();
        bookings = new ArrayList<>();
        this.scanner = scanner;
    }
    
    /**
     * Main method
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            HotelManagement hotel = new HotelManagement(scanner);
            System.out.println("=== HOTEL MANAGEMENT SYSTEM ===");
            hotel.runMainMenu();
        }
    }
    
    /**
     * Run main menu
     */
    public void runMainMenu() {
        int choice;
        
        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Add Guest");
            System.out.println("2. Add Employee");
            System.out.println("3. Add Room");
            System.out.println("4. Make Booking");
            System.out.println("5. Display All");
            System.out.println("6. Cancel Booking");
            System.out.println("7. Exit");
            System.out.print("Choice: ");
            
            choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1 -> addGuest();
                case 2 -> addEmployee();
                case 3 -> addRoom();
                case 4 -> makeBooking();
                case 5 -> displayAll();
                case 6 -> cancelBooking();
                case 7 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid choice!");
            }
            
        } while (choice != 7);
    }
    
    /**
     * Add guest
     */
    public void addGuest() {
        System.out.println("\n--- ADD GUEST ---");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("VIP (true/false): ");
        boolean isVIP = scanner.nextBoolean();
        scanner.nextLine();
        
        guests.add(new Guest(name, phone, age, isVIP));
        System.out.println("Guest added!");
    }
    
    /**
     * Add employee
     */
    public void addEmployee() {
        System.out.println("\n--- ADD EMPLOYEE ---");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Position: ");
        String position = scanner.nextLine();
        System.out.print("Salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine();
        
        employees.add(new Employee(name, phone, age, position, salary));
        System.out.println("Employee added!");
    }
    
    /**
     * Add room
     */
    public void addRoom() {
        System.out.println("\n--- ADD ROOM ---");
        System.out.print("Room Number: ");
        int roomNum = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Type: ");
        String roomType = scanner.nextLine();
        System.out.print("Price per night: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        
        rooms.add(new Room(roomNum, roomType, price));
        System.out.println("Room added!");
    }
    
    /**
     * Make booking
     */
    public void makeBooking() {
        System.out.println("\n--- MAKE BOOKING ---");
        
        if (guests.isEmpty() || rooms.isEmpty()) {
            System.out.println("Add guests and rooms first!");
            return;
        }
        
        System.out.println("\nGuests:");
        for (int i = 0; i < guests.size(); i++) {
            System.out.println((i + 1) + ". " + guests.get(i).getName());
        }
        System.out.print("Select guest: ");
        int guestIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        
        System.out.println("\nAvailable Rooms:");
        for (int i = 0; i < rooms.size(); i++) {
            Room room = rooms.get(i);
            if (room.isAvailable()) {
                System.out.println((i + 1) + ". Room " + room.getRoomNumber() + 
                                   " - $" + room.getPricePerNight());
            }
        }
        System.out.print("Select room: ");
        int roomIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        
        System.out.print("Nights: ");
        int nights = scanner.nextInt();
        scanner.nextLine();
        
        Booking booking = new Booking(guests.get(guestIndex), rooms.get(roomIndex), nights);
        booking.confirmBooking();
        bookings.add(booking);
        System.out.println("Booking created!");
    }
    
    /**
     * Display all
     */
    public void displayAll() {
        System.out.println("\n--- GUESTS ---");
        for (Guest guest : guests) {
            guest.displayInfo();
            System.out.println();
        }
        
        System.out.println("--- EMPLOYEES ---");
        for (Employee employee : employees) {
            employee.displayInfo();
            System.out.println();
        }
        
        System.out.println("--- ROOMS ---");
        for (Room room : rooms) {
            room.displayInfo();
            System.out.println();
        }
        
        System.out.println("--- BOOKINGS ---");
        for (Booking booking : bookings) {
            booking.displayBookingDetails();
            System.out.println();
        }
    }
    
    /**
     * Cancel booking
     */
    public void cancelBooking() {
        System.out.println("\n--- CANCEL BOOKING ---");
        
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }
        
        for (int i = 0; i < bookings.size(); i++) {
            Booking booking = bookings.get(i);
            if (booking.isActive()) {
                System.out.println((i + 1) + ". " + booking.getBookingId());
            }
        }
        
        System.out.print("Select booking: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();
        
        if (index >= 0 && index < bookings.size()) {
            bookings.get(index).cancelBooking();
        }
    }
}
