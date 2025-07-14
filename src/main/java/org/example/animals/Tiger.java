package org.example.animals;

public class Tiger extends Feline {
    public Tiger() {
        this.name = "Tiger";
    }

    @Override
    public void eat() {
        System.out.println("Tiger is eating.");
    }

    @Override
    public void sleep() {
        System.out.println("Tiger is sleeping.");
    }

    @Override
    public void makeSound() {
        System.out.println("Tiger roars! 🐯");
    }

    public String getName() {
        return name;
    }
}
