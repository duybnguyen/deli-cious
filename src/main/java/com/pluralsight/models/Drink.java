package com.pluralsight.models;

public class Drink extends Item {
    private String size;

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

    @Override
    public String toString() {
        return "Drink (" + getSize() + ") - " +
                String.format("$%.2f", getPrice());
    }
}
