package org.example;

public class Ticket {
     public final String name;
     public final int age;
     public final String type;
     public final double price;
     public final String code;

    public Ticket(String name, int age, String type, double price, String code) {
        this.name = name;
        this.age = age;
        this.type = type;
        this.price = price;
        this.code = code;
    }
}
