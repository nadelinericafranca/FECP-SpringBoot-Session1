package org.example.animals;

public class Elephant extends Pachyderm {
    public Elephant(String name, String species) {
        super(name, species);
    }

    @Override
    public void eat() {
        System.out.println("Elephant is eating.");
    }

    @Override
    public void sleep() {
        System.out.println("Elephant is sleeping.");
    }

    @Override
    public void makeSound() {
        System.out.println("Elephant trumpets. 🐘🎺");
    }
}
