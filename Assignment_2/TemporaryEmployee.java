package Hexaware.Assignment_2;

public class TemporaryEmployee extends Employee{
    int hoursWorked;
    double ratePerHour;

    public TemporaryEmployee(int empId, String name, double ratePerHour) {
        super(empId, name);
        this.ratePerHour = ratePerHour;
    }

    double calculateSalary(){
        return hoursWorked * ratePerHour;
    }

    public void setHoursWorked(int hw) { this.hoursWorked = hw; }

    public void setRatePerHour(double ratePerHour) {
        this.ratePerHour = ratePerHour;
    }
}
