package org.example.animals;

public class Owl extends Bird {
    public Owl(String name, String species) {
        super(name, species);
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
}
