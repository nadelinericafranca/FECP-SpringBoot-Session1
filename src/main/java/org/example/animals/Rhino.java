package org.example.animals;

public class Rhino extends Pachyderm {
        this.name = "Rhino";
=======
    public Rhino(String name, String species) {
        super(name, species);
    }

    @Override
    public void eat() {

    }

    @Override
    public void sleep() {

    }

    @Override
    public void makeSound() {
      
    }
    public String getName() {
        return name;
    }
}
