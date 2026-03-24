package Hexaware.Banking_OOPs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Customer> accounts = new ArrayList<>();

        System.out.println("Account Creation:");
        System.out.println("1. Create account");
        System.out.println("2. Deposit amount");
        System.out.println("3. Withdraw amount");
        System.out.println("4. Enquiry balance");
        System.out.println("5. Transfer amount");
        System.out.println("6. Search customer");
        System.out.println("7. Display all customers");
        System.out.println("8. Exit");

        boolean isNotExit = true;

        while(isNotExit) {
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: {
                    System.out.print("\nEnter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Account Type: ");
                    String acc_type = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter Account Number: ");
                    int acc_no = sc.nextInt();
                    System.out.print("Enter Balance: ");
                    double balance = sc.nextDouble();

                    boolean exists = false;
                    for (Customer c : accounts) {
                        if (c.getAccountNumber() == acc_no) {
                            exists = true;
                            break;
                        }
                    }

                    if (exists) {
                        System.out.println("Account number already exists!");
                    } else {
                        Customer acc = new Customer(acc_no, name, balance, acc_type, email);
                        accounts.add(acc);
                    }

                    break;
                }

                case 2: {
                    System.out.print("\nEnter Account Number: ");
                    int acc_no = sc.nextInt();
                    System.out.print("\nEnter Amount to Deposit: ");
                    double amt = sc.nextDouble();

                    boolean isAccountExist = false;
                    for (Customer c : accounts) {
                        if (c.getAccountNumber() == acc_no) {
                            c.deposit(amt);
                            isAccountExist = true;
                            break;
                        }
                    }

                    if (!isAccountExist) System.out.println("Account Not Found.");
                    break;
                }

                case 3: {
                    System.out.print("\nEnter Account Number: ");
                    int acc_no = sc.nextInt();
                    System.out.print("\nEnter Amount to Withdraw: ");
                    double amt = sc.nextDouble();

                    boolean isAccountExist = false;
                    for (Customer c : accounts) {
                        if (c.getAccountNumber() == acc_no) {
                            c.withdraw(amt);
                            isAccountExist = true;
                            break;
                        }
                    }

                    if (!isAccountExist) System.out.println("Account Not Found.");
                    break;
                }

                case 4: {

                    System.out.print("\nEnter Account Number: ");
                    int acc_no = sc.nextInt();

                    boolean isAccountExist = false;
                    for (Customer c : accounts) {
                        if (c.getAccountNumber() == acc_no) {
                            System.out.println("Balance: " + c.getBalance());
                            isAccountExist = true;
                            break;
                        }
                    }

                    if (!isAccountExist) System.out.println("Account Not Found.");
                    break;
                }

                case 5: {

                    System.out.print("\nEnter (From) Account Number : ");
                    int acc_no1 = sc.nextInt();
                    System.out.print("\nEnter (To) Account Number: ");
                    int acc_no2 = sc.nextInt();
                    System.out.print("\nEnter Amount to Transfer: ");
                    double amt = sc.nextDouble();

                    Customer c1 = null;
                    Customer c2 = null;

                    for (Customer c : accounts) {
                        if (c.getAccountNumber() == acc_no1) c1 = c;
                        if (c.getAccountNumber() == acc_no2) c2 = c;
                    }

                    if (c1 == null) {
                        System.out.println("Account 1 Not Found.");
                    } else if (c2 == null) {
                        System.out.println("Account 2 Not Found.");
                    } else if (c1.getBalance() < amt) {
                        System.out.println("Insufficient funds in account " + acc_no1);
                    } else {
                        c1.withdraw(amt);
                        c2.deposit(amt);
                        System.out.println("Successfully transferred " + amt + " from " + acc_no1 + " to " + acc_no2);
                    }
                    break;
                }

                case 6: {
                    System.out.print("\nEnter Account Number to Search: ");
                    int acc_no = sc.nextInt();
                    Customer c1 = null;

                    System.out.println("\nAccount Details");
                    for (Customer c : accounts) {
                        if (c.getAccountNumber() == acc_no) {
                            c1 = c;
                            break;
                        }
                    }

                    display(c1);
                    break;
                }

                case 7: {
                    System.out.println("\nAccount Details");
                    if (accounts.isEmpty()) {
                        System.out.println("No accounts available.");
                    } else {
                        for (Customer c : accounts) {
                            display(c);
                        }
                    }
                    break;
                }

                case 8: {
                    isNotExit = false;
                    break;
                }

                default: {
                    System.out.println("Enter correct choice");
                }
            }

        }

    }

    public static void display(Customer c1){
        if (c1 != null) {
            System.out.printf("\n%-15s %-10s %-20s %-10s %-10s\n", "Name", "Type", "Email", "Acc No", "Balance");
            System.out.printf("%-15s %-10s %-20s %-10d %-10.2f\n",
                    c1.getName(), c1.getAccountType(), c1.getEmail(), c1.getAccountNumber(), c1.getBalance());
        } else {
            System.out.println("Account not found.");
        }

    }
}
