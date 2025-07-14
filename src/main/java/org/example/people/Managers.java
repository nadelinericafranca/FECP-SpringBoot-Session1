package org.example.people;

import org.example.buildings.Buildings;

public class Managers extends People {
    public Managers(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }


    @Override
    public void goTo(Buildings destination) {

    }

    public static void openZoo() {

    }

    public static void closeZoo() {

    }


}
