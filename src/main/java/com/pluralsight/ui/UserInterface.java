package com.pluralsight.ui;
import java.util.Scanner;
import com.pluralsight.models.*;
import com.pluralsight.order.*;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);
    private Order currentOrder;
    private OrderFileManager fileManager = new OrderFileManager();

    public void displayMenu() {
        boolean running = true;

        while (running) {
            System.out.println("==== Welcome to DELI-cious ====");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("Choose an option: ");

            int choice = readInt();

            switch (choice) {
                case 1:
                    startOrder();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }
    }
    public void startOrder() {
        currentOrder = new Order();
        boolean inOrder = true;

        while (inOrder) {
            System.out.println("==== Current Order Menu ====");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.print("Choose an option: ");

            int choice = readInt();

            switch (choice) {
                case 1:
                    addSandwich();
                    break;
                case 2:
                    addDrink();
                    break;
                case 3:
                    addChips();
                    break;
                case 4:
                    checkout();
                    inOrder = false;
                    break;
                case 0:
                    System.out.println("Order cancelled.");
                    currentOrder = null;
                    inOrder = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }
    }

    public void addSandwich() {
        System.out.println("=== Add Sandwich ===");

        int size = promptSandwichSize();
        String bread = promptBreadType();
        boolean toasted = promptYesNo("Would you like the sandwich toasted? (y/n): ");

        Sandwich sandwich = new Sandwich("Custom", bread, size, toasted);

        boolean addMoreMeat = promptYesNo("Add meat toppings? (y/n): ");
        while (addMoreMeat) {
            String meatName = promptMeatChoice();
            boolean isExtra = promptYesNo("Extra " + meatName + "? (y/n): ");
            sandwich.addTopping(new Meat(meatName, isExtra));
            addMoreMeat = promptYesNo("Add another meat? (y/n): ");
        }

        boolean addMoreCheese = promptYesNo("Add cheese toppings? (y/n): ");
        while (addMoreCheese) {
            String cheeseName = promptCheeseChoice();
            boolean isExtra = promptYesNo("Extra " + cheeseName + "? (y/n): ");
            sandwich.addTopping(new Cheese(cheeseName, isExtra));
            addMoreCheese = promptYesNo("Add another cheese? (y/n): ");
        }

        boolean addRegular = promptYesNo("Add regular toppings (lettuce, tomato, etc.)? (y/n): ");
        while (addRegular) {
            String regToppingName = promptRegularToppingChoice();
            boolean isExtra = promptYesNo("Extra " + regToppingName + "? (y/n): ");
            sandwich.addTopping(new RegularTopping(regToppingName, isExtra));
            addRegular = promptYesNo("Add another regular topping? (y/n): ");
        }

        boolean addSauce = promptYesNo("Add sauces? (y/n): ");
        while (addSauce) {
            String sauceName = promptSauceChoice();
            sandwich.addTopping(new Sauce(sauceName));
            addSauce = promptYesNo("Add another sauce? (y/n): ");
        }

        currentOrder.addItem(sandwich);
        System.out.println("Sandwich added to order.");
    }

    public void addDrink() {

    }

    public void addChips() {

    }

    public void checkout() {

    }

    // Helper Methods
    private int readInt() {
        while (true) {
            String line = scanner.nextLine();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }

    private boolean promptYesNo(String prompt) {
        System.out.print(prompt);
        while (true) {
            String input = scanner.nextLine().toLowerCase();
            if (input.startsWith("y")) return true;
            if (input.startsWith("n")) return false;
            System.out.print("Please enter y or n: ");
        }
    }

    private int promptSandwichSize() {
        while (true) {
            System.out.println("Choose sandwich size:");
            System.out.println("1) 4\"");
            System.out.println("2) 8\"");
            System.out.println("3) 12\"");
            System.out.print("Choice: ");

            int choice = readInt();
            switch (choice) {
                case 1: return 4;
                case 2: return 8;
                case 3: return 12;
                default:
                    System.out.println("Invalid size. Try again.");
            }
        }
    }

    private String promptBreadType() {
        while (true) {
            System.out.println("Choose bread type:");
            System.out.println("1) White");
            System.out.println("2) Wheat");
            System.out.println("3) Rye");
            System.out.println("4) Wrap");
            System.out.print("Choice: ");

            int choice = readInt();
            switch (choice) {
                case 1: return "White";
                case 2: return "Wheat";
                case 3: return "Rye";
                case 4: return "Wrap";
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private String promptCheeseChoice() {
        while (true) {
            System.out.println("Choose cheese:");
            System.out.println("1) American");
            System.out.println("2) Provolone");
            System.out.println("3) Cheddar");
            System.out.println("4) Swiss");
            System.out.print("Choice: ");

            int choice = readInt();
            switch (choice) {
                case 1: return "american";
                case 2: return "provolone";
                case 3: return "cheddar";
                case 4: return "swiss";
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private String promptMeatChoice() {
        while (true) {
            System.out.println("Choose meat:");
            System.out.println("1) Steak");
            System.out.println("2) Ham");
            System.out.println("3) Salami");
            System.out.println("4) Roast Beef");
            System.out.println("5) Chicken");
            System.out.println("6) Bacon");
            System.out.print("Choice: ");

            int choice = readInt();
            switch (choice) {
                case 1: return "steak";
                case 2: return "ham";
                case 3: return "salami";
                case 4: return "roast beef";
                case 5: return "chicken";
                case 6: return "bacon";
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private String promptRegularToppingChoice() {
        while (true) {
            System.out.println("Choose regular topping:");
            System.out.println("1) Lettuce");
            System.out.println("2) Peppers");
            System.out.println("3) Onions");
            System.out.println("4) Tomatoes");
            System.out.println("5) Jalapeños");
            System.out.println("6) Cucumbers");
            System.out.println("7) Pickles");
            System.out.println("8) Guacamole");
            System.out.println("9) Mushrooms");
            System.out.print("Choice: ");

            int choice = readInt();
            switch (choice) {
                case 1: return "lettuce";
                case 2: return "peppers";
                case 3: return "onions";
                case 4: return "tomatoes";
                case 5: return "jalapeños";
                case 6: return "cucumbers";
                case 7: return "pickles";
                case 8: return "guacamole";
                case 9: return "mushrooms";
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private String promptSauceChoice() {
        while (true) {
            System.out.println("Choose sauce:");
            System.out.println("1) Mayo");
            System.out.println("2) Mustard");
            System.out.println("3) Ketchup");
            System.out.println("4) Ranch");
            System.out.println("5) Thousand Islands");
            System.out.println("6) Vinaigrette");
            System.out.print("Choice: ");

            int choice = readInt();
            switch (choice) {
                case 1: return "mayo";
                case 2: return "mustard";
                case 3: return "ketchup";
                case 4: return "ranch";
                case 5: return "thousand islands";
                case 6: return "vinaigrette";
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

}
