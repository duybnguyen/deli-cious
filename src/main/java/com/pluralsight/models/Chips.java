package com.pluralsight.models;

public class Chips extends Item {
    public Chips(String name) {
        super(name);
    }

    @Override
    public double getPrice() {
        return 1.50;
    }
}
