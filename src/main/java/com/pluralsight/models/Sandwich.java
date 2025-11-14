package com.pluralsight.models;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends Item {
    private String breadType;
    private int sandwichSize;
    private boolean isToasted;
    private List<Topping> toppings = new ArrayList<>();

    public Sandwich(String name, String breadType, int sandwichSize, boolean isToasted) {
        super(name);
        this.breadType = breadType;
        this.sandwichSize = sandwichSize;
        this.isToasted = isToasted;
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

    public boolean isToasted() {
        return isToasted;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    @Override
    public double getPrice() {
        double total = 0;

        switch (sandwichSize) {
            case 4 -> total += 5.50;
            case 8 -> total += 7.00;
            case 12 -> total += 8.50;
            default -> System.out.println("Invalid sandwich size!");
        }

        for (Topping topping : toppings) {
            total += topping.getPrice(sandwichSize);
        }

        return total;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public void removeTopping(String name) {
        toppings.removeIf(t -> t.getName().equalsIgnoreCase(name));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Sandwich (")
                .append(getSandwichSize()).append("\", ")
                .append(getBreadType()).append(", ")
                .append(isToasted() ? "Toasted" : "Not Toasted")
                .append(")").append("\n");

        for (Topping topping : toppings) {
            sb.append("   - ").append(topping.getName());

            if (topping instanceof PremiumTopping pt && pt.isExtra()) {
                sb.append(" (extra)");
            }

            sb.append("\n");
        }

        sb.append(String.format("   Price: $%.2f", getPrice()));

        return sb.toString();
    }
}
