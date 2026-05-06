/**
 * Person.java
 * Abstract class that represents a person in the hotel system.
 * Serves as base class for Guest and Employee (Inheritance).
 * Abstract class is used for bonus points.
 */

public abstract class Person {
    
    protected String name;        // Name of the person
    protected String phoneNumber; // Phone number of the person
    protected int age;            // Age of the person
    
    /**
     * Default constructor
     */
    public Person() {
        this.name = "Unknown";
        this.phoneNumber = "Not provided";
        this.age = 0;
    }
    
    /**
     * Parameterized constructor
     */
    public Person(String name, String phoneNumber, int age) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }
    
    /**
     * Abstract method - must be implemented by child classes
     */
    public abstract String getRole();
    
    /**
     * Display person information
     */
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Age: " + age);
        System.out.println("Role: " + getRole());
    }
    
    /**
     * Method overloading example - get details
     */
    public String getDetails() {
        return "Name: " + name + ", Age: " + age;
    }
    
    /**
     * Method overloading example - get details with phone
     */
    public String getDetails(boolean includePhone) {
        if (includePhone) {
            return "Name: " + name + ", Age: " + age + ", Phone: " + phoneNumber;
        }
        return getDetails();
    }
    
    // Getters and Setters
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
}
