package Hexaware.Collection;

import java.util.ArrayList;

public class Attendance<T> {

    ArrayList<T> present = new ArrayList<>();

    void add(T obj) {
        present.add(obj);
    }

    ArrayList<T> getAll() {
        return present;
    }
}