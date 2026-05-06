/**
 * Person.java
 * Abstract class that represents a person in the hotel system.
 * Serves as base class for Guest and Employee (Inheritance).
 * Abstract class is used for bonus points.
 */

public abstract class Person {
    
    // Instance variables to store person's basic information
    // These are protected to allow direct access by child classes (Guest, Employee)
    protected String name;        // Full name of the person
    protected String phoneNumber; // Contact phone number for communication
    protected int age;            // Age of the person in years
    
    /**
     * Default constructor - creates a Person with default/placeholder values
     * Used when specific person information is not available at creation time
     */
    public Person() {
        // Initialize with default placeholder values
        this.name = "Unknown";           // Default name when not specified
        this.phoneNumber = "Not provided"; // Default phone when not provided
        this.age = 0;                    // Default age (0 indicates not set)
    }
    
    /**
     * Parameterized constructor - creates a Person with specific information
     * @param name The full name of the person
     * @param phoneNumber The contact phone number
     * @param age The age of the person in years
     */
    public Person(String name, String phoneNumber, int age) {
        // Assign provided parameters to instance variables using 'this' keyword
        this.name = name;              // Set the person's name
        this.phoneNumber = phoneNumber; // Set the contact phone number
        this.age = age;                // Set the person's age
    }
    
    /**
     * Abstract method - must be implemented by all child classes
     * This enforces that every person type (Guest, Employee) has a specific role
     * @return A string representing the person's role in the hotel system
     */
    public abstract String getRole();
    
    /**
     * Displays all basic information about the person
     * Calls the abstract getRole() method to show the specific role
     */
    public void displayInfo() {
        System.out.println("Name: " + name);              // Display person's name
        System.out.println("Phone: " + phoneNumber);       // Display contact phone
        System.out.println("Age: " + age);                 // Display person's age
        System.out.println("Role: " + getRole());          // Display role (polymorphic call)
    }
    
    /**
     * Method overloading example - get basic person details
     * @return A formatted string containing name and age
     */
    public String getDetails() {
        return "Name: " + name + ", Age: " + age;  // Concatenate name and age info
    }
    
    /**
     * Method overloading example - get details with optional phone number
     * Demonstrates method overloading with different parameter lists
     * @param includePhone If true, includes phone number in the output
     * @return A formatted string with name, age, and optionally phone number
     */
    public String getDetails(boolean includePhone) {
        if (includePhone) {
            // Return detailed information including phone number
            return "Name: " + name + ", Age: " + age + ", Phone: " + phoneNumber;
        }
        // If phone not requested, call the simpler version of this method
        return getDetails();
    }
    
    // ===== GETTER AND SETTER METHODS =====
    // These methods provide controlled access to the protected instance variables
    // Following encapsulation principle - direct access is restricted
    
    /**
     * Getter method for name
     * @return The person's name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Setter method for name
     * @param name The new name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Getter method for phone number
     * @return The person's phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    /**
     * Setter method for phone number
     * @param phoneNumber The new phone number to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    /**
     * Getter method for age
     * @return The person's age
     */
    public int getAge() {
        return age;
    }
    
    /**
     * Setter method for age
     * @param age The new age to set
     */
    public void setAge(int age) {
        this.age = age;
    }
}
