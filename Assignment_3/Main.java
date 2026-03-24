package Hexaware.Assignment_3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try{
            int age = sc.nextInt();
            if (age < 0 || age > 100) throw new InvalidAgeException("Age is Invalid");
        }catch (InvalidAgeException e){
            System.out.println(e.getMessage());
        }
    }
}
