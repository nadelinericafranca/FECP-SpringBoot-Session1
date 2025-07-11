package org.example.buildings;

public abstract class Product {
    private int itemNumber;
    private String name;
    private int price;

    public Product (int itemNumber, String name, int price) {
        this.itemNumber = itemNumber;
        this.name = name;
        this.price = price;
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
