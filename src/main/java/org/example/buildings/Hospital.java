package org.example.buildings;

import org.example.animals.Animal;
import org.example.people.Veterinarians;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Hospital extends Buildings {
    private ArrayList<Animal> sickAnimals;
    private ArrayList<Animal> healedAnimals;

    public Hospital() {
        this.sickAnimals = new ArrayList<>();
        this.healedAnimals = new ArrayList<>();
    }

    public ArrayList<Animal> getSickAnimals() {
        return sickAnimals;
    }

    public ArrayList<Animal> getHealedAnimals() {
        return healedAnimals;
    }

    public void admitAnimal(Animal animal) { // for adding new sick animals
        sickAnimals.add(animal);
        animal.setHealthy(false);
    }

    public void healSickAnimals(Veterinarians vet) {
        if (sickAnimals.isEmpty()) {
            System.out.println("No sick animals to heal.\n");
            return;
        }

        System.out.println("Dr. " + vet.getName() + " begins healing sick animals...");

        ArrayList<Animal> animalsToHeal = new ArrayList<>(sickAnimals); // create copy to avoid conflict during removal of animal to the original list

        for (Animal animal : animalsToHeal) {
            vet.heal(animal);
            sickAnimals.remove(animal);
            healedAnimals.add(animal);

            System.out.println("✅ Healed: " + animal.getName());
            System.out.println(animal.getName() + " has been discharged and returned to enclosure");
        }
        System.out.println();
    }

    public void displaySickAnimals() {
        if (sickAnimals.isEmpty()) {
            System.out.println("No sick animals currently in Hospital.\n");
        } else {
            System.out.println("🐾 Sick Animals Currently in Hospital:");
            for (Animal animal : sickAnimals) {
                System.out.println("- " + animal.getName());
            }
            System.out.println();
        }
    }

    public void displayHealedAnimals() {
        if (healedAnimals.isEmpty()) {
            System.out.println("No animals have been healed yet.\n");
        } else {
            System.out.println("🩺 Healed Animals with Timestamps:");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedTimestamp;

            for (Animal animal : healedAnimals) {
                LocalDateTime timestamp = animal.getHealingTimestamp();

                if (timestamp != null) {
                    formattedTimestamp = timestamp.format(formatter);
                } else {
                    formattedTimestamp = "N/A";
                }

                System.out.printf("- %s ✅(%s)\n", animal.getName(), formattedTimestamp);
            }
            System.out.println();
        }
    }
}
