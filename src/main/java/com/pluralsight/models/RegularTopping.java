package com.pluralsight.models;

public class RegularTopping extends Topping {

    public RegularTopping(String name, boolean isExtra) {
        super(name, isExtra);
    }

    @Override
    public double getPrice(int sandwichSize) {
        return 0.0;
    }
}
