package org.example.animals;

public abstract class Animal {
    protected boolean healthy;
    protected String name;
    protected String species;

    public abstract void eat();
    public abstract void sleep();
    public abstract void roam();
    public abstract void makeSound();
    public abstract String getName();
}
