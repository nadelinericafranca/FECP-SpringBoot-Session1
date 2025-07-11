package org.example.people;

import org.example.buildings.Buildings;

public abstract class People {
    protected String name;
    protected Buildings location;

    public abstract void goTo(Buildings destination);
}
