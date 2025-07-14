package org.example.animals;

import org.example.buildings.Buildings;

public abstract class Bird extends Animal {
    protected Buildings location;

    public Bird(String name, String species) {
        super(name, species);
    }

    @Override
    public void roam(){

    }
}
