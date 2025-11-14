package com.pluralsight.models;

public class BLTSandwich extends Sandwich{
    public BLTSandwich() {
        super("BLT", "White", 8, true);
        addTopping(new Meat("bacon", false));
        addTopping(new Cheese("cheddar", false));
        addTopping(new RegularTopping("lettuce", false));
        addTopping(new RegularTopping("tomatoes", false));
        addTopping(new Sauce("ranch"));
    }
}
