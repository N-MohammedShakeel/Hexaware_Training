package Hexaware.Functional_Interface;

public class Main {
    public static void main(String[] args) {

        Calculator sum = (a,b) -> a + b;
        System.out.println(sum.operation(5,6));

        Phone airtel = n -> System.out.println("Airtel calling : " + n + " RS");;
        Phone vodafone = n -> System.out.println("Vodafone calling : " + n + " RS");;
        Phone jio = n -> System.out.println("Jio calling : " + n + " RS");;

        airtel.calling(5);
        vodafone.calling(10);
        jio.calling(12);

        airtel.message();
        vodafone.message();
        jio.message();



    }
}
