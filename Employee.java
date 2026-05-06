/**
 * Employee.java
 * This class represents an employee in the hotel.
 * It extends the Person class, demonstrating inheritance.
 * An employee is a specific type of person who works at the hotel.
 */

public class Employee extends Person {
    
    // Private attributes specific to Employee class
    private String employeeId;     // Unique ID for the employee
    private String position;       // Job position (e.g., Receptionist, Housekeeper)
    private double salary;         // Monthly salary of the employee
    private int yearsOfExperience; // Years of experience at the hotel
    
    /**
     * Default constructor - initializes with default values
     */
    public Employee() {
        super(); // Call the default constructor of parent class Person
        this.employeeId = "EMP000";
        this.position = "Not assigned";
        this.salary = 0.0;
        this.yearsOfExperience = 0;
    }
    
    /**
     * Parameterized constructor - initializes with given values
     * @param name The name of the employee
     * @param phoneNumber The phone number of the employee
     * @param age The age of the employee
     * @param employeeId The employee ID
     * @param position The job position
     * @param salary The monthly salary
     * @param yearsOfExperience Years of experience
     */
    public Employee(String name, String phoneNumber, int age, String employeeId, 
                    String position, double salary, int yearsOfExperience) {
        super(name, phoneNumber, age); // Call the parameterized constructor of parent class Person
        this.employeeId = employeeId;
        this.position = position;
        this.salary = salary;
        this.yearsOfExperience = yearsOfExperience;
    }
    
    /**
     * Implementation of the abstract method from Person class
     * This demonstrates method override (implementing abstract method)
     * @return The role of this person as a string
     */
    @Override
    public String getRole() {
        return "Employee (" + position + ")";
    }
    
    /**
     * Override the displayInfo method from Person class
     * This demonstrates method override - providing specific implementation for Employee
     */
    @Override
    public void displayInfo() {
        System.out.println("=== EMPLOYEE INFORMATION ===");
        super.displayInfo(); // Call the parent class displayInfo method
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Position: " + position);
        System.out.println("Salary: $" + salary);
        System.out.println("Years of Experience: " + yearsOfExperience);
        System.out.println("============================");
    }
    
    /**
     * Method to calculate annual salary
     * @return The annual salary (monthly salary * 12)
     */
    public double calculateAnnualSalary() {
        return salary * 12;
    }
    
    /**
     * Method overloading example - calculate bonus
     * This is the first version with no parameters (standard bonus calculation)
     * @return The bonus amount based on years of experience
     */
    public double calculateBonus() {
        // Standard bonus: $100 for each year of experience
        return yearsOfExperience * 100;
    }
    
    /**
     * Method overloading example - calculate bonus with custom rate
     * This is the second version with a parameter for custom bonus rate
     * @param bonusPerYear The bonus amount per year of experience
     * @return The bonus amount based on custom rate
     */
    public double calculateBonus(double bonusPerYear) {
        return yearsOfExperience * bonusPerYear;
    }
    
    /**
     * Method to give a raise to the employee
     * @param percentage The percentage increase (e.g., 10 for 10%)
     */
    public void giveRaise(double percentage) {
        double increase = salary * (percentage / 100.0);
        salary = salary + increase;
        System.out.println(name + " received a " + percentage + "% raise!");
        System.out.println("New salary: $" + salary);
    }
    
    // Getter and Setter methods
    
    public String getEmployeeId() {
        return employeeId;
    }
    
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    
    public String getPosition() {
        return position;
    }
    
    public void setPosition(String position) {
        this.position = position;
    }
    
    public double getSalary() {
        return salary;
    }
    
    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    public int getYearsOfExperience() {
        return yearsOfExperience;
    }
    
    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
}
