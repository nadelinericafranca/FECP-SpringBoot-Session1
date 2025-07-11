package org.example.animals;

import org.example.buildings.Buildings;

public abstract class Pachyderm extends Animal {
    protected Buildings location;

    public Pachyderm(String name, String species) {
        super(name, species);
    }

    @Override
    public void roam(){

    }
}
