/**
 * Person.java
 * This is an abstract class that represents a person in the hotel system.
 * It serves as a base class for Guest and Employee classes (Inheritance).
 * Abstract class is used for bonus points.
 */

public abstract class Person {
    
    // Protected attributes that can be accessed by child classes
    protected String name;        // Name of the person
    protected String phoneNumber; // Phone number of the person
    protected int age;            // Age of the person
    
    /**
     * Default constructor - initializes with default values
     */
    public Person() {
        this.name = "Unknown";
        this.phoneNumber = "Not provided";
        this.age = 0;
    }
    
    /**
     * Parameterized constructor - initializes with given values
     * @param name The name of the person
     * @param phoneNumber The phone number of the person
     * @param age The age of the person
     */
    public Person(String name, String phoneNumber, int age) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }
    
    /**
     * Abstract method - must be implemented by child classes
     * This demonstrates abstract class usage (bonus points)
     * @return A string describing the person's role
     */
    public abstract String getRole();
    
    /**
     * Method to display person information
     * This method can be overridden by child classes (demonstrates override)
     */
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Age: " + age);
        System.out.println("Role: " + getRole());
    }
    
    /**
     * Method overloading example - same method name with different parameters
     * This is the first version of getDetails with no parameters
     * @return Basic details string
     */
    public String getDetails() {
        return "Name: " + name + ", Age: " + age;
    }
    
    /**
     * Method overloading example - same method name with different parameters
     * This is the second version of getDetails with a boolean parameter
     * @param includePhone Whether to include phone number in details
     * @return Detailed string with or without phone number
     */
    public String getDetails(boolean includePhone) {
        if (includePhone) {
            return "Name: " + name + ", Age: " + age + ", Phone: " + phoneNumber;
        } else {
            return getDetails();
        }
    }
    
    // Getter and Setter methods for encapsulation
    
    /**
     * Getter for name
     * @return The name of the person
     */
    public String getName() {
        return name;
    }
    
    /**
     * Setter for name
     * @param name The new name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Getter for phone number
     * @return The phone number of the person
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    /**
     * Setter for phone number
     * @param phoneNumber The new phone number to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    /**
     * Getter for age
     * @return The age of the person
     */
    public int getAge() {
        return age;
    }
    
    /**
     * Setter for age
     * @param age The new age to set
     */
    public void setAge(int age) {
        this.age = age;
    }
}
