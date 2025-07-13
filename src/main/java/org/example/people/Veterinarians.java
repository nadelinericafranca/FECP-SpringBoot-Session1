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
        System.out.println("Dr. " + name + " begins healing sick animals...");
        animal.setHealthy(true);
        animal.setHealingTimestamp(LocalDateTime.now()); // Set timestamp
        System.out.println("✅ Healed: " + animal.getName());
        System.out.println(animal.getName() + " has been discharged and returned to enclosure.");
    }

    public void lecture() {
        System.out.println("Dr. " + name + "gives a science lecture on animal health and conservation.");
    }
}
