package Hexaware.Functional_Interface;

public interface Phone {

    void calling(double rate);

    default void message(){
        System.out.println("message 2 rupees");
    }
}
