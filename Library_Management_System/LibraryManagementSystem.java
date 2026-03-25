package Hexaware.Library_Management_System;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Book> books = new ArrayList<>();
        List<Member> members = new ArrayList<>();

        System.out.println("1. Create Member");
        System.out.println("2. Issue Book");
        System.out.println("3. Return Book");
        System.out.println("4. Add Book");
        System.out.println("5. Remove Book");
        System.out.println("6. Update Book");
        System.out.println("7. Show All Book");
        System.out.println("8. Remove Member");
        System.out.println("9. Exit");

        boolean isNotExit = true;

        while(isNotExit) {
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:{
                    System.out.print("Enter Member ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    if(findMember(members,id) != null){
                        System.out.println("Member Already exists in this ID");
                    }else {
                        Member m = new Member(id,name);
                        members.add(m);
                        System.out.println("Member Created Successfully");
                    }
                    break;
                }

                case 2:{

                    System.out.println("\nEnter Book ID: ");
                    int bookId = sc.nextInt();
                    sc.nextLine();

                    Book b = findBook(books,bookId);

                    if(b == null){
                        System.out.println("Book Not Found.");
                        break;
                    }
                    if(b.getIssuedStatus()){
                        System.out.println("Book Not Available");
                        break;
                    }

                    System.out.println("Enter Member ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    Member m = findMember(members,id);

                    if (m == null) {
                        System.out.println("Member Not Found.");
                        break;
                    }

                    if(m.getIssuedBook() != null){
                        System.out.println("Memer already have a book.");
                        break;
                    }

                    LocalDate issuedDate = LocalDate.now();
                    LocalDate dueDate = issuedDate.plusDays(7);

                    m.setIssuedBook(b);
                    m.setIssueDate(issuedDate);
                    m.setDueDate(dueDate);

                    b.setIssuedStatus(true);

                    System.out.println("Book Issued Successfully");

                    break;
                }

                case 3:{

                    System.out.println("\nReturning the Book: ");

                    System.out.println("Enter Member ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    Member m = findMember(members,id);

                    if (m == null || m.getIssuedBook() == null) {
                        System.out.println("Member not found or has no book issued.");
                    }else{
                        Book b = m.getIssuedBook();

                        long daysKept = ChronoUnit.DAYS.between(m.getIssueDate(),LocalDate.now());
                        long daysToKeep = ChronoUnit.DAYS.between(m.getIssueDate(), m.getDueDate());
                        long due = daysKept - daysToKeep;

                        if(due > 0){
                            System.out.println("Fine : " + (10 * (daysKept - daysToKeep)) + " rupees" );
                        }else {
                            System.out.println("No Fine.");
                        }

                        m.setIssueDate(null);
                        m.setDueDate(null);
                        m.setIssuedBook(null);
                        b.setIssuedStatus(false);
                    }
                    break;
                }

                case 4:{
                    System.out.println("\nEnter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.println("Enter Author: ");
                    String author = sc.nextLine();

                    if(findBook(books,id) != null){
                        System.out.println("Book Already exists in this ID");
                    }else {
                        Book b = new Book(id,title,author);
                        books.add(b);
                        System.out.println("Book Added Successfully");
                    }
                    break;
                }

                case 5:{
                    System.out.println("\nEnter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    Book b = findBook(books,id);
                    if(b != null){
                        books.remove(b);
                        System.out.println("Book removed Successully");
                    }else {
                        System.out.println("Book Not Found");
                    }
                    break;
                }

                case 6:{

                    System.out.println("\nEnter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    Book b = findBook(books,id);

                    if (b == null) {
                        System.out.println("Book Not Found.");
                        break;
                    }

                    System.out.print("Enter Book Title (Click Enter to Skip): ");
                    String title = sc.nextLine();
                    if(!title.trim().isEmpty())  b.setTitle(title);

                    System.out.print("Enter Author Title (Click Enter to Skip): ");
                    String author = sc.nextLine();
                    if(!author.trim().isEmpty())  b.setAuthor(author);

                    System.out.println("Updated Successfully.");

                    break;

                }

                case 7:{
                    if(books.isEmpty()){
                        System.out.println("No Books Available");
                    }else {
                        System.out.println("\nBook Details");
                        for (Book b : books){
                            System.out.printf("\n%-5d %-20s %-20s %-10s\n",b.getBookId(),b.getTitle(),b.getAuthor(),(b.getIssuedStatus() ? "Not Available" : "Available"));
                        }
                    }
                    break;
                }

                case 8:{
                    System.out.println("\nEnter Member ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    Member m = findMember(members,id);
                    if(m != null){
                        members.remove(m);
                        System.out.println("Member removed Successully");
                    }else {
                        System.out.println("Member Not Found");
                    }
                    break;
                }

                case 9:{
                    isNotExit = false;
                    break;
                }
            }
        }
    }

    private static Book findBook(List<Book> books,int id) {
        for (Book b : books){
            if (b.getBookId() == id) return b;
        }
        return null;
    }
    private static Member findMember(List<Member> members, int id) {
        for (Member m : members){
            if (m.getMemberId() == id) return m;
        }
        return null;
    }
}
