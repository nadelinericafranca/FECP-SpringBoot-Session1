package org.example.buildings;

import org.example.animals.Animal;

public class Enclosures extends Buildings {
    protected String species;
    private Animal animal;

    public Enclosures(String species, Animal animal) {
        this.species = species;
        this.animal = animal;
    }

    public String getSpecies() {
        return species;
    }

    public Animal getAnimal() {
        return animal;
    }

    @Override
    public String toString() {
        return species + " (" + animal + ")";
    }
}
