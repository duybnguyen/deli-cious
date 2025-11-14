package com.pluralsight.order;
import com.pluralsight.models.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class OrderFileManager {

    public void saveTransaction(Order order) {

        String timestamp = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());
        File receiptsDir = new File("receipts");

        File file = new File(receiptsDir, timestamp + ".txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {

            writer.write("======= Deli-cious Receipt =======");
            writer.newLine();
            writer.write("Order Timestamp: " + timestamp);
            writer.newLine();
            writer.newLine();

            for (Item item : order.getItems()) {
                writer.write(formatItem(item));
                writer.newLine();
            }

            writer.newLine();
            writer.write(String.format("TOTAL: $%.2f", order.getTotalPrice()));
            writer.newLine();
            writer.write("==================================");

        } catch (IOException e) {
            System.out.println("Error writing receipt: " + e.getMessage());
        }
    }

    private String formatItem(Item item) {
        StringBuilder sb = new StringBuilder();

        if (item instanceof Sandwich sandwich) {
            sb.append("Sandwich (")
                    .append(sandwich.getSandwichSize()).append("\", ")
                    .append(sandwich.getBreadType()).append(", ")
                    .append(sandwich.isToasted() ? "Toasted" : "Not Toasted")
                    .append(")").append("\n");

            for (Topping topping : sandwich.getToppings()) {
                sb.append("   - ").append(topping.getName());

                if (topping instanceof PremiumTopping pt && pt.isExtra()) {
                    sb.append(" (extra)");
                }

                sb.append("\n");
            }

            sb.append(String.format("   Price: $%.2f", sandwich.getPrice()));

        } else if (item instanceof Drink drink) {
            sb.append("Drink (")
                    .append(drink.getSize()).append(") - ")
                    .append(String.format("$%.2f", drink.getPrice()));

        } else if (item instanceof Chips chips) {
            sb.append("Chips (")
                    .append(chips.getName()).append(") - ")
                    .append(String.format("$%.2f", chips.getPrice()));
        }

        return sb.toString();
    }
}
