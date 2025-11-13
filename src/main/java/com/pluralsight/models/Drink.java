package com.pluralsight.models;

public class Drink extends Item {
    String size;

    public Drink(String name, String size) {
        super(name);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public double getPrice() {
        return switch (size) {
            case "Large" -> 3.0;
            case "Medium" -> 2.5;
            default -> 2.0;
        };
    }
}
