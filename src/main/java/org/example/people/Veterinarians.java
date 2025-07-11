package org.example.people;

import org.example.buildings.Buildings;

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

    public static void heal() {

    }

    public static void lecture() {

    }
}
