package com.pluralsight.models;

public class Cheese extends PremiumTopping {

    public Cheese(String name, boolean isExtra) {
        super(name, isExtra);
    }

    @Override
    public double getPrice(int sandwichSize) {
        return switch (sandwichSize) {
            case 4 -> isExtra() ? 0.75 : 0.30;
            case 8 -> isExtra() ? 1.50 : 0.60;
            case 12 -> isExtra() ? 2.25 : 0.90;
            default -> {
                System.out.println("Error: Unable to calculate premium topping cost.");
                yield 0;
            }
        };
    }
}
