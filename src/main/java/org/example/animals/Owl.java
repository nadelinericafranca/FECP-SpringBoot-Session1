package org.example.animals;

public class Owl extends Bird {
    public Owl() {
        this.name = "Owl";
    }

    @Override
    public void eat() {
        System.out.println("Owl is eating.");
    }

    @Override
    public void sleep() {
        System.out.println("Owl is sleeping.");
    }

    @Override
    public void makeSound() {
        System.out.println("Owl hoots! 🦉");
    }

    public String getName() {
        return name;
    }
}
