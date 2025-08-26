package core.oop;

// Superclass: Employee
class Employee {
    private String name;
    private double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    // Method tính tổng lương, có thể override
    public double calculateSalary() {
        return baseSalary; // chỉ lương cơ bản
    }
}

// Subclass: Manager
class Manager extends Employee {
    private double bonus;

    public Manager(String name, double baseSalary, double bonus) {
        super(name, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        // Override: tính tổng lương = baseSalary + bonus
        return super.getBaseSalary() + bonus;
    }
}

// Subclass: Developer
class Developer extends Employee {
    private double overtimePay;

    public Developer(String name, double baseSalary, double overtimePay) {
        super(name, baseSalary);
        this.overtimePay = overtimePay;
    }

    @Override
    public double calculateSalary() {
        // Override: baseSalary + overtimePay
        return super.getBaseSalary() + overtimePay;
    }
}

// Demo
public class DemoOverride {
    public static void main(String[] args) {
        Employee emp = new Employee("Alice", 3000);
        Manager mgr = new Manager("Bob", 5000, 2000);
        Developer dev = new Developer("Charlie", 4000, 500);

        System.out.println(emp.getName() + " salary: " + emp.calculateSalary());
        System.out.println(mgr.getName() + " salary: " + mgr.calculateSalary());
        System.out.println(dev.getName() + " salary: " + dev.calculateSalary());
    }
}
