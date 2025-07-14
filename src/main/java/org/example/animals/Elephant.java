package org.example.animals;

public class Elephant extends Pachyderm {
    public Elephant() {
        this.name = "Elephant";
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

    public String getName() {
        return name;
    }
}
