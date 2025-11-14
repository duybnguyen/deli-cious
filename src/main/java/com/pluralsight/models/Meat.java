package com.pluralsight.models;

public class Meat extends PremiumTopping {

    public Meat(String name, boolean isExtra) {
        super(name, isExtra);
    }

    @Override
    public double getPrice(int sandwichSize) {
        return switch (sandwichSize) {
            case 4 -> isExtra() ? 1.00 : .50;
            case 8 -> isExtra() ? 2.00 : 1.00;
            case 12 -> isExtra() ? 3.00 : 1.50;
            default -> {
                System.out.println("Error: Unable to calculate premium topping cost.");
                yield 0;
            }
        };
    }
}