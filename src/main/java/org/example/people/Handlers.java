package org.example.people;

import org.example.buildings.Buildings;
import org.example.animals.Animal;
import java.util.*;

public class Handlers extends People {

    private List<Animal> assignedAnimals = new ArrayList<>();

    public Handlers(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public List<Animal> getAssignedAnimals(){
        return assignedAnimals;
    }

    public void assignAnimal(Animal animal  ){
        assignedAnimals.add(animal);
    }


    @Override
    public void goTo(Buildings destination) {

    }

    public static void feed() {

    }

    public static void exercise() {

    }

    public static void examine() {

    }


}
