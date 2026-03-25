package Hexaware.StreamAPI;

import QSpider_Phase_2.OOP.TypeCasting.instanceOf.B;
import QSpider_Phase_2.OOP.TypeCasting.instanceOf.E;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

//        List<Integer> marks = Arrays.asList(50, 25, 86, 71, 99, 63);
//        marks.stream()
//                .filter(n -> n >= 50)
//                .forEach(n -> System.out.print(n + " "));
//
//        long count = marks.stream()
//                    .filter(n -> n >= 50)
//                    .count();
//        System.out.println(count);
//

//        marks.stream()
//                .sorted()
//                .forEach(n -> System.out.print(n + " "));
//
//        List<String> users = Arrays.asList("kavita","jatin","ajay","ram","arti");
//
//        users.stream()
//                .sorted()
//                .forEach(System.out::println);
//
//        users.stream()
//                .filter(i -> i.startsWith("a"))
//                .forEach(System.out::println);
//
//        marks.stream()
//                .filter(n -> n < 30)
//                .map(n -> n + 5)
//                .forEach(System.out::println);


//        List<Employee> employees = new ArrayList<>();
//        employees.add(new Employee(1,"ms1",10000));
//        employees.add(new Employee(2,"ms2",20000));
//        employees.add(new Employee(3,"ms3",30000));
//        employees.add(new Employee(4,"ms4",40000));
//        employees.add(new Employee(5,"ms5",50000));
//
//        employees.stream()
//                .filter(e -> e.getSalary() >= 30000)
//                .forEach(System.out::println);


        List<Book> books = Arrays.asList(
                new Book(1, "Java Basics", "James", 500, "Programming"),
                new Book(2, "Spring Boot", "Rod", 800, "Programming"),
                new Book(3, "Python Guide", "Guido", 600, "Programming"),
                new Book(4, "History India", "Ram", 300, "History"),
                new Book(5, "Maths 101", "Shyam", 200, "Education"),
                new Book(6, "Data Structures", "Mark", 700, "Programming"),
                new Book(7, "English Grammar", "John", 250, "Education"),
                new Book(8, "AI Basics", "Andrew", 900, "Technology"),
                new Book(9, "Machine Learning", "Andrew", 1200, "Technology"),
                new Book(10, "World War", "Alex", 400, "History")
        );

        books.stream()
                .forEach(System.out::println);

        books.stream()
                .filter(b -> b.getPrice() > 500)
                .forEach(System.out::println);

        long count = books.stream().count();
        System.out.println(count);

        Book bmax = books.stream()
                .max((b1, b2) -> Double.compare(b1.getPrice(), b2.getPrice()))
                .orElse(null);

        Book bmin = books.stream()
                .min((b1, b2) -> Double.compare(b1.getPrice(), b2.getPrice()))
                .orElse(null);

        List<String> authors = books.stream()
                .map(b -> b.getAuthor())
                .distinct()
                .toList();

        books.stream()
                .sorted((b1, b2) -> Double.compare(b1.getPrice(), b2.getPrice()))
                .forEach(System.out::println);

        books.stream()
                .sorted((b1, b2) -> b2.getTitle().compareTo(b1.getTitle()))
                .forEach(System.out::println);

        books.stream()
                .filter(b -> b.getCategory().equals("Programming"))
                .forEach(System.out::println);

        Double avgPrice = books.stream()
                .mapToDouble(b -> b.getPrice())
                .average()
                .orElse(0.0);

        Map<String, List<Book>> booksByCategory = books.stream()
                .collect(Collectors.groupingBy(b -> b.getCategory()));

        Map<String, Long> countsByCategory = books.stream()
                .collect(Collectors.groupingBy(b -> b.getCategory(), Collectors.counting()));

        Map<String,Optional<Book>> maxPriceByCategory = books.stream()
                .collect(Collectors.groupingBy(b -> b.getCategory(), Collectors.maxBy((b1,b2) -> Double.compare(b1.getPrice(),b2.getPrice()))));

        Map<Integer, List<Book>> booksById = books.stream()
                .collect(Collectors.groupingBy(b -> b.getId()));

        List<Book> booksByAndrew = books.stream()
                .filter(b -> b.getAuthor().equals("Andrew"))
                .toList();

        books.stream()
                .filter(b -> b.getPrice() > 1000)
                .forEach(System.out::println);

        List<Book> first3Cheapest = books.stream()
                .sorted((b1,b2) -> Double.compare(b2.getPrice(),b1.getPrice()))
                .limit(3)
                .toList();

        books.stream()
                .skip(2)
                .forEach(System.out::println);

        double total = books.stream()
                .mapToDouble(b -> b.getPrice())
                .sum();

        Map<Boolean, List<Book>> partitionedBooks = books.stream()
                .collect(Collectors.partitioningBy(b -> b.getPrice() > 500));


;    }
}