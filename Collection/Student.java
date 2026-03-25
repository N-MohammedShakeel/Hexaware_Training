package Hexaware.Collection;

public class Student {

    int rollno;
    boolean isPresent;

    Student(int rollno, boolean isPresent) {
        this.rollno = rollno;
        this.isPresent = isPresent;
    }

    public boolean isPresent() {
        return isPresent;
    }
}
