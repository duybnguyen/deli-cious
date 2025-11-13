package com.pluralsight.models;

public class Sauce extends Topping {

    public Sauce(String name) {
        super(name, false);
    }

    @Override
    public double getPrice(int sandwichSize) {
        return 0.0;
    }
}
