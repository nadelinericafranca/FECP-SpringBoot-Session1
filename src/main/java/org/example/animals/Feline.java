package org.example.animals;

import org.example.buildings.Buildings;

public abstract class Feline extends Animal {
    protected Buildings location;

    public Feline(String name, String species) {
        super(name, species);
    }

    @Override
    public void roam(){

    }
}
