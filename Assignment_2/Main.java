package Hexaware.Assignment_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Employee> list = new ArrayList<>();

        System.out.println("1. Add Temporary Employee");
        System.out.println("2. Add Permanent Employee");
        System.out.println("3. Calculate Salary");
        System.out.println("4. Display Details");
        System.out.println("5. Search Employee by ID");
        System.out.println("6. Update Employee Salary");
        System.out.println("7. Exit");

        boolean isNotExit = true;

        while(isNotExit) {
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:{
                    System.out.print("Enter Employee Id: ");
                    int empId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("\nEnter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter ratePerHour: ");
                    double rph = sc.nextDouble();

                    boolean exists = false;
                    for (Employee e : list) {
                        if (e.getEmpId() == empId) {
                            exists = true;
                            break;
                        }
                    }

                    if(!exists){
                        list.add(new TemporaryEmployee(empId, name, rph));
                    }else{
                        System.out.println("Employee Already Exists in this ID");
                    }

                    break;
                }

                case 2:{
                    System.out.print("Enter Employee Id: ");
                    int empId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("\nEnter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Basic Salary: ");
                    double bs = sc.nextDouble();

                    boolean exists = false;
                    for (Employee e : list) {
                        if (e.getEmpId() == empId) {
                            exists = true;
                            break;
                        }
                    }

                    if(!exists){
                        list.add(new PermanentEmployee(empId, name, bs));
                    }else{
                        System.out.println("Employee Already Exists in this ID");
                    }

                    break;
                }

                case 3:{
                    System.out.print("Enter Employee Id: ");
                    int empId = sc.nextInt();
                    sc.nextLine();

                    boolean exists = false;
                    for (Employee e : list) {
                        if (e.getEmpId() == empId) {
                            exists = true;
                            if (e instanceof TemporaryEmployee t) {
                                System.out.print("Enter Hours Worked: ");
                                int hw = sc.nextInt();
                                sc.nextLine();
                                t.setHoursWorked(hw);
                                System.out.println("Salary : " + t.calculateSalary());
                            } else if (e instanceof PermanentEmployee p) {
                                System.out.print("Enter Bonus: ");
                                double b = sc.nextDouble();
                                p.setBonus(b);
                                System.out.println("Salary : " + p.calculateSalary());
                            }
                            break;
                        }
                    }

                    if(!exists) System.out.println("Employee Not Found.");

                    break;
                }



                case 4:{
                    for (Employee e : list) e.displayDetails();
                    break;
                }

                case 5:{
                    System.out.print("Enter Employee Id: ");
                    int empId = sc.nextInt();

                    boolean exists = false;
                    Employee emp = null;
                    for (Employee e : list) {
                        if (e.getEmpId() == empId) {
                            exists = true;
                            break;
                        }
                    }

                    if(!exists){
                        if(emp != null) emp.displayDetails();
                    }else{
                        System.out.println("Employee Already Exists in this ID");
                    }

                    break;
                }

                case 6:{
                    System.out.print("Enter ID to update: ");
                    int empId = sc.nextInt();
                    for (Employee e : list) {
                        if (e.getEmpId() == empId) {
                            if (e instanceof TemporaryEmployee t) {
                                System.out.print("New RatePerHour: ");
                                t.setRatePerHour(sc.nextDouble());
                            } else if (e instanceof PermanentEmployee p) {
                                System.out.print("New Basic Salary: ");
                                p.setBasicSalary(sc.nextDouble());
                            }
                            System.out.println("Updated!");
                        }
                    }
                    break;
                }

                case 7: {
                    isNotExit = false;
                    break;
                }
            }
        }
    }
}
