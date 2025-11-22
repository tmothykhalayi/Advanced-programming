import java.io.*;
import java.util.*;

// ===== Base Employee Class =====
abstract class Employee implements Serializable {
    protected String name;
    protected int id;
    protected Address address;
    protected static int counter = 1000;

    public Employee(String name, String city, String state) {
        this.name = name;
        this.id = counter++;
        this.address = new Address(city, state);
    }

    // Abstract method for polymorphic salary calculation
    public abstract double calculateSalary();

    // Print employee details
    public void printDetails() {
        System.out.println("\nEmployee ID   : " + id);
        System.out.println("Name          : " + name);
        System.out.println("Address       : " + address.city + ", " + address.state);
        System.out.printf("Salary        : %.2f\n", calculateSalary());
    }

    // ===== Inner Class for Address =====
    class Address implements Serializable {
        String city, state;
        Address(String city, String state) {
            this.city = city;
            this.state = state;
        }
    }
}

// ===== Subclasses =====
class FullTimeEmployee extends Employee {
    private double baseSalary, bonus;

    public FullTimeEmployee(String name, double baseSalary, double bonus, String city, String state) {
        super(name, city, state);
        this.baseSalary = baseSalary;
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() { return baseSalary + bonus; }
}

class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public PartTimeEmployee(String name, double hourlyRate, int hoursWorked, String city, String state) {
        super(name, city, state);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() { return hourlyRate * hoursWorked; }
}

class ContractEmployee extends Employee {
    private double contractAmount;

    public ContractEmployee(String name, double contractAmount, String city, String state) {
        super(name, city, state);
        this.contractAmount = contractAmount;
    }

    @Override
    public double calculateSalary() { return contractAmount; }
}

// ===== Manager Class =====
class EmployeeManager {
    private ArrayList<Employee> employees = new ArrayList<>();
    private final String fileName = "employees.dat";

    // Add employee
    public void addEmployee(Employee e) { employees.add(e); }

    // Save to file
    public void saveToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(employees);
            System.out.println("Employees saved successfully!");
        } catch (Exception e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    // Load from file
    public void loadFromFile() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            employees = (ArrayList<Employee>) in.readObject();
            System.out.println("Employees loaded successfully!");
        } catch (Exception e) {
            System.out.println("No saved data found.");
        }
    }

    // Print all employees
    public void printAll() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }
        for (Employee e : employees) e.printDetails();
    }

    // Search by ID
    public void searchByID(int id) {
        boolean found = false;
        for (Employee e : employees) {
            if (e.id == id) {
                e.printDetails();
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Employee with ID " + id + " not found.");
    }

    // Search by Name
    public void searchByName(String name) {
        boolean found = false;
        for (Employee e : employees) {
            if (e.name.equalsIgnoreCase(name)) {
                e.printDetails();
                found = true;
            }
        }
        if (!found) System.out.println("No employees found with name: " + name);
    }

    // Sort by salary
    public void sortBySalary() {
        employees.sort(Comparator.comparingDouble(Employee::calculateSalary));
        System.out.println("Employees sorted by salary.");
    }
}

// ===== Main Program =====
public class EmployeePayrollSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeManager manager = new EmployeeManager();
        manager.loadFromFile();

        while (true) {
            System.out.println("\n===== ADVANCED EMPLOYEE PAYROLL SYSTEM =====");
            System.out.println("1. Add Full-Time Employee");
            System.out.println("2. Add Part-Time Employee");
            System.out.println("3. Add Contract Employee");
            System.out.println("4. View All Employees");
            System.out.println("5. Search Employee by ID");
            System.out.println("6. Search Employee by Name");
            System.out.println("7. Sort Employees by Salary");
            System.out.println("8. Save & Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Name: "); String name = sc.nextLine();
                    System.out.print("Base Salary: "); double base = sc.nextDouble();
                    System.out.print("Bonus: "); double bonus = sc.nextDouble(); sc.nextLine();
                    System.out.print("City: "); String city = sc.nextLine();
                    System.out.print("State: "); String state = sc.nextLine();
                    manager.addEmployee(new FullTimeEmployee(name, base, bonus, city, state));
                }
                case 2 -> {
                    System.out.print("Name: "); String name = sc.nextLine();
                    System.out.print("Hourly Rate: "); double rate = sc.nextDouble();
                    System.out.print("Hours Worked: "); int hours = sc.nextInt(); sc.nextLine();
                    System.out.print("City: "); String city = sc.nextLine();
                    System.out.print("State: "); String state = sc.nextLine();
                    manager.addEmployee(new PartTimeEmployee(name, rate, hours, city, state));
                }
                case 3 -> {
                    System.out.print("Name: "); String name = sc.nextLine();
                    System.out.print("Contract Amount: "); double amount = sc.nextDouble(); sc.nextLine();
                    System.out.print("City: "); String city = sc.nextLine();
                    System.out.print("State: "); String state = sc.nextLine();
                    manager.addEmployee(new ContractEmployee(name, amount, city, state));
                }
                case 4 -> manager.printAll();
                case 5 -> {
                    System.out.print("Enter Employee ID: "); int id = sc.nextInt();
                    manager.searchByID(id);
                }
                case 6 -> {
                    System.out.print("Enter Employee Name: "); String name = sc.nextLine();
                    manager.searchByName(name);
                }
                case 7 -> manager.sortBySalary();
                case 8 -> {
                    manager.saveToFile();
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice! Try again.");
            }
            sc.close();
        }
        

    }
    
}
