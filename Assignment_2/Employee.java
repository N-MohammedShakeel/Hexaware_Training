package Hexaware.Assignment_2;

public abstract class Employee {
    int empId;
    String name;

    public Employee(int empId, String name) {
        this.empId = empId;
        this.name = name;
    }

    public int getEmpId() { return empId; }
    abstract double calculateSalary();
    public void displayDetails() {
        System.out.println("ID: " + empId + " | Name: " + name + " | Salary: " + calculateSalary());
    }
}
