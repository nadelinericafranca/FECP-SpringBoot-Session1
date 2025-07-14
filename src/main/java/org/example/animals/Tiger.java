package org.example.animals;

public class Tiger extends Feline {
    public Tiger(String name, String species) {
        super(name, species);
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
}
