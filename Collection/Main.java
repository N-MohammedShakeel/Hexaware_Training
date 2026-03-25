package Hexaware.Collection;

import java.util.*;

public class Main {
    public static void main(String[] args) {

//        double[] sales = {-43, -54, 7, 78, 69, 99, 12, -67};
//
//        List<Double> positive = new ArrayList<>();
//        List<Double> negative = new ArrayList<>();
//
//        for (double e : sales){
//            if (e >= 0) positive.add(e);
//            else negative.add(e);
//        }
//
//        int[] num = {2,4,5,5,3,7,5,7,9};
//
//        List<Integer> list = new ArrayList<>();
//        List<Integer> duplicates1 = new ArrayList<>();
//
//        for(int n : num) {
//            if(list.contains(n) && !duplicates1.contains(n)) {
//                duplicates1.add(n);
//            } else {
//                list.add(n);
//            }
//        }
//
//        for(int d : duplicates1) {
//            System.out.println("Duplicate value: " + d);
//        }
//
//        Set<Integer> seen = new HashSet<>();
//        Set<Integer> duplicates = new HashSet<>();
//
//        for(int n : num){
//            if(!seen.add(n)){
//                duplicates.add(n);
//            }
//        }
//
//        for(int n : num){
//            if(!duplicates.contains(n)){
//                System.out.println("Non Duplicate value: " + n);
//            }
//        }

//        HashMap<String, String> login = new HashMap<>();
//        login.put("ms1","pass1234");
//        login.put("ms2","pass5678");
//
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Enter UserId: ");
//        String id = sc.nextLine();
//        System.out.print("Enter Password: ");
//        String pass = sc.nextLine();
//
//        if (login.get(id).equals(pass)) {
//            System.out.println("Login Successfull");
//        } else {
//            System.out.println("Invalid");
//        }


//        String[] fruits = {
//                "Apple", "Banana", "Mango", "Apple", "Orange",
//                "Banana", "Grapes", "Mango", "Apple", "Pineapple",
//                "Orange", "Banana", "Apple", "Mango", "Grapes",
//                "Banana", "Apple", "Orange", "Mango", "Banana"
//        };
//
//        Map<String, Integer> freq = new HashMap<>();
//
//        for(String fruit : fruits){
//            freq.put(fruit,freq.getOrDefault(fruit,0) + 1);
//        }
//
//        for (Map.Entry<String,Integer> e : freq.entrySet()){
//            System.out.println("Fruit: " + e.getKey() + ", Count: " + e.getValue());
//        }

//        String[] exp = {"5","4","+","6","*"};
//        Stack<Integer> s = new Stack<>();
//
//        for (String e : exp){
//
//            if(e.equals("+") || e.equals("-") || e.equals("*") || e.equals("/")){
//                int v1 = s.pop();
//                int v2 = s.pop();
//
//                switch (e){
//                    case "+":{
//                        s.push(v1+v2);
//                        break;
//                    }
//                    case "-":{
//                        s.push(v1-v2);
//                        break;
//                    }
//                    case "*":{
//                        s.push(v1*v2);
//                        break;
//                    }
//                    case "/":{
//                        s.push(v1/v2);
//                        break;
//                    }
//                }
//            }else {
//                int stoi = Integer.parseInt(e);
//                s.push(stoi);
//            }
//        }
//
//        System.out.println("Result: " + s.pop());
//

//        int[] a = {1, 2, 3, 4, 5, 6};
//
//        Queue<Integer> q = new LinkedList<>();
//        q.add(a[a.length - 1]);
//
//        for (int i = 0; i < a.length - 1; i++) {
//            q.add(a[i]);
//        }
//
//        for (int e : q){
//            System.out.print(e + " ");
//        }

        Queue<Integer> pq = new PriorityQueue<>();
        pq.add(2);
        pq.add(9);
        pq.add(1);
        pq.add(4);

        int k = 3;

        while(k > 0){
            Integer v = pq.poll();
            if (k == 1) System.out.println(v);
            k--;
        }

        // HashMap : No order
        // LinkedHashMap : Insertion Order
        // TreeMap : 	Sorted Order based on keys

        // HashSet : No order
        // LinkedHashSet : Insertion Order
        // TreeSet : 	Sorted Order based on keys


//        List<String> list = new ArrayList<>();
//        list.add("Apple");
//        list.add("Mango");
//
//        for (String e : list) System.out.println(e);


        Attendance<Student> a = new Attendance<>();

        a.add(new Student(101,true));
        a.add(new Student(102,false));

        for (Student s : a.getAll()) {
            System.out.println("Roll: " + s.rollno + ", Present: " + s.isPresent());
        }
    }
}
