package Hexaware.Assignment_2;

public class PermanentEmployee extends Employee {

    double basicSalary;
    double bonus;

    double calculateSalary(){
        return basicSalary + bonus;
    }

    public PermanentEmployee(int empId, String name, double basicSalary) {
        super(empId, name);
        this.basicSalary = basicSalary;
    }


    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }
}
