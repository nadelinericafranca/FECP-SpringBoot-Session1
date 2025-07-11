package org.example.people;

import org.example.buildings.Buildings;

public class Vendors extends People {
    public Vendors(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }


    @Override
    public void goTo(Buildings destination) {

    }
}
