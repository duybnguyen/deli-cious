package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends Item {
    private String breadType;
    private int sandwichSize;
    private List<Topping> toppings = new ArrayList<>();

    public Sandwich(String name, String breadType, int sandwichSize) {
        super(name);
    }

    public String getBreadType() {
        return breadType;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public int getSandwichSize() {
        return sandwichSize;
    }

    public void setSandwichSize(int sandwichSize) {
        this.sandwichSize = sandwichSize;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(List<Topping> toppings) {
        this.toppings = toppings;
    }

    @Override
    public double getPrice() {
        return 0.0;
    }
}
