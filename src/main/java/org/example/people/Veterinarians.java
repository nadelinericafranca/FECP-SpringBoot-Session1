package org.example.people;

import org.example.animals.Animal;
import org.example.buildings.Buildings;

import java.time.LocalDateTime;

public class Veterinarians extends People {
    public Veterinarians(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    @Override
    public void goTo(Buildings destination) {

    }

    public void heal(Animal animal) {
        animal.setHealthy(true);
        animal.setHealingTimestamp(LocalDateTime.now()); // Set timestamp
    }

    public void lecture() {
        System.out.println("Dr. " + name + " gives a science lecture on animal health and conservation.\n");
    }
}
