package Hexaware.Functional_Interface;

@FunctionalInterface
public interface Calculator {
    int operation(int a, int b);
}

// A functional interface is an interface that contains exactly one abstract method
// Can have default, static, and private methods without affecting SAM status.