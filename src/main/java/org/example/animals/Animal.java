package org.example.animals;

import java.time.LocalDateTime;

public abstract class Animal {
    protected boolean healthy;
    protected String name;
    protected String species;
    protected LocalDateTime healingTimestamp;

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

    public LocalDateTime getHealingTimestamp() {
        return healingTimestamp;
    }

    public boolean isHealthy() {
        return healthy;
    }

    public void setHealthy(boolean healthy) {
        this.healthy = healthy;
    }

    public void setHealingTimestamp(LocalDateTime healingTimestamp) {
        this.healingTimestamp = healingTimestamp;
    }
}
