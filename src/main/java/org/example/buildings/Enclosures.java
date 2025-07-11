package org.example.buildings;

public class Enclosures extends Buildings {
    protected String species;
    private String animal;

    public Enclosures(String species, String animal) {
        this.species = species;
        this.animal = animal;
    }

    public String getSpecies() {
        return species;
    }

    public String getAnimal() {
        return animal;
    }
}
