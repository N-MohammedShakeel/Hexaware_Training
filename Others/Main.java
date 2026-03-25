package Hexaware.Others;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int a = 10;
        Integer aa = Integer.valueOf(a);
        int num = aa.intValue();


        List<Double> cart = new ArrayList<>();
        cart.add(50.3);
        cart.add(200.00);

        double total = 0.0;
        for (double p : cart){
            total += p;
        }

        System.out.println(total);

        Calendar cal = Calendar.getInstance();

        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);

        System.out.println(year);
        System.out.println(month);

        LocalDate today = LocalDate.now();

        System.out.println(today);
        System.out.println(today.getDayOfMonth());
        System.out.println(today.getDayOfWeek());
        System.out.println(today.getYear());
        System.out.println(today.getMonth());

        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime modifiedLdt = ldt.plusDays(5).minusHours(3);
        System.out.println("Original: " + ldt.format(dtf));
        System.out.println("After +5 days, -3 hours: " + modifiedLdt.format(dtf));



        List<Student> list = new ArrayList<>();

        list.add(new Student(1,"ms1"));
        list.add(new Student(3,"as1"));
        list.add(new Student(2,"ds1"));
        list.add(new Student(4,"cs1"));

        for (Student s : list){
            System.out.println(s);
        }

        list.sort((s1, s2) -> s1.name.compareTo(s2.name));

        for (Student s : list){
            System.out.println(s);
        }

    }
}
