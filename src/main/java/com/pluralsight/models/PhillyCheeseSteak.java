package com.pluralsight.models;

public class PhillyCheeseSteak extends Sandwich {

    public PhillyCheeseSteakSandwich() {
        super("Philly Cheese Steak", "White", 8, true);

        addTopping(new Meat("steak", false));
        addTopping(new Cheese("american", false));
        addTopping(new RegularTopping("peppers", false));
        addTopping(new Sauce("mayo"));
    }
}