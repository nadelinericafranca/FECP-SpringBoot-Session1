package org.example.animals;

public abstract class Animal {
    protected boolean healthy;
    protected String name;
    protected String species;

    public Animal(String name, String species) {
        this.name = name;
        this.species = species;
        this.healthy = false;   // default to false
    }

    public abstract void eat();
    public abstract void sleep();
    public abstract void roam();
    public abstract void makeSound();

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public boolean isHealthy() {
        return healthy;
    }
}
