/**
 * Employee.java
 * Represents a hotel employee. Extends Person (Inheritance).
 */

public class Employee extends Person {
    
    private String position;       // Job position
    private double salary;         // Monthly salary
    
    /**
     * Default constructor
     */
    public Employee() {
        super();
        this.position = "Not assigned";
        this.salary = 0.0;
    }
    
    /**
     * Parameterized constructor
     */
    public Employee(String name, String phoneNumber, int age, String position, double salary) {
        super(name, phoneNumber, age);
        this.position = position;
        this.salary = salary;
    }
    
    /**
     * Override abstract method from Person
     */
    @Override
    public String getRole() {
        return "Employee (" + position + ")";
    }
    
    /**
     * Override displayInfo method
     */
    @Override
    public void displayInfo() {
        System.out.println("=== EMPLOYEE ===");
        super.displayInfo();
        System.out.println("Position: " + position);
        System.out.println("Salary: $" + salary);
        System.out.println("===============");
    }
    
    /**
     * Method overloading - calculate bonus
     */
    public double calculateBonus() {
        return salary * 0.05; // 5% of salary
    }
    
    /**
     * Method overloading - calculate bonus with rate
     */
    public double calculateBonus(double rate) {
        return salary * (rate / 100.0);
    }
    
    // Getters and Setters
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
}
