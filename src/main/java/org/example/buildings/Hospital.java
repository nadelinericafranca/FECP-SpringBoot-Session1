package org.example.buildings;

import org.example.animals.Animal;
import org.example.people.Veterinarians;

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

    public void healAnimal(Animal animal, Veterinarians vet) {
        vet.heal(animal);
        sickAnimals.remove(animal);
        healedAnimals.add(animal);
    }
}
