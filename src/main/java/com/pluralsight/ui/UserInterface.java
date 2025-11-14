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
            System.out.println("===== Welcome to Deli-cious =====");
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
            System.out.println("\n===== Current Order Menu =====");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) View Order");
            System.out.println("5) Checkout");
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
                    showOrder();
                    break;
                case 5:
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
        System.out.println("\n===== Add Sandwich =====");
        System.out.println("1) Custom Sandwich");
        System.out.println("2) Signature Sandwich");
        System.out.print("Choose an option: ");

        int choice = readInt();

        switch (choice) {
            case 1 -> addCustomSandwich();
            case 2 -> addSignatureSandwich();
            default -> System.out.println("Invalid choice, returning to order menu.");
        }
    }

    private void addCustomSandwich() {
        System.out.println("\n===== Add Custom Sandwich =====");

        int size = promptSandwichSize();
        String bread = promptBreadType();
        boolean toasted = promptYesNo("Would you like the sandwich toasted? (y/n): ");

        Sandwich sandwich = new Sandwich("Custom", bread, size, toasted);

        boolean addMoreMeat = promptYesNo("Add meat? (y/n): ");
        while (addMoreMeat) {
            String meatName = promptMeatChoice();
            boolean isExtra = promptYesNo("Extra " + meatName + "? (y/n): ");
            sandwich.addTopping(new Meat(meatName, isExtra));
            addMoreMeat = promptYesNo("Add another meat? (y/n): ");
        }

        boolean addMoreCheese = promptYesNo("Add cheese? (y/n): ");
        while (addMoreCheese) {
            String cheeseName = promptCheeseChoice();
            boolean isExtra = promptYesNo("Extra " + cheeseName + "? (y/n): ");
            sandwich.addTopping(new Cheese(cheeseName, isExtra));
            addMoreCheese = promptYesNo("Add another cheese? (y/n): ");
        }

        boolean addRegular = promptYesNo("Add regular toppings? (y/n): ");
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
        System.out.println("Custom sandwich added to order.");
    }

    private void addSignatureSandwich() {
        System.out.println("\n===== Signature Sandwiches =====");
        System.out.println("1) BLT");
        System.out.println("2) Philly Cheese Steak");
        System.out.print("Choose a signature sandwich: ");

        int choice = readInt();
        Sandwich sandwich;

        switch (choice) {
            case 1 -> sandwich = new BLTSandwich();
            case 2 -> sandwich = new PhillyCheeseSteak();
            default -> {
                System.out.println("Invalid choice, returning to order menu.");
                return;
            }
        }

        System.out.println("\nYou chose:");
        System.out.println(sandwich);

        if (promptYesNo("Would you like to customize this sandwich? (y/n): ")) {
            customizeSandwich(sandwich);
        }

        currentOrder.addItem(sandwich);
        System.out.println("Signature sandwich added to order.");
    }

    private void customizeSandwich(Sandwich sandwich) {
        boolean customizing = true;

        while (customizing) {
            System.out.println("\nCurrent Sandwich:");
            System.out.println(sandwich);

            System.out.println("\nCustomize:");
            System.out.println("1) Remove a topping");
            System.out.println("2) Add meat");
            System.out.println("3) Add cheese");
            System.out.println("4) Add regular topping");
            System.out.println("5) Add sauce");
            System.out.println("0) Done customizing");
            System.out.print("Choose an option: ");

            int choice = readInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter the name of the topping to remove: ");
                    String name = scanner.nextLine().trim();
                    sandwich.removeTopping(name);
                }
                case 2 -> {
                    String meatName = promptMeatChoice();
                    boolean isExtra = promptYesNo("Extra " + meatName + "? (y/n): ");
                    sandwich.addTopping(new Meat(meatName, isExtra));
                }
                case 3 -> {
                    String cheeseName = promptCheeseChoice();
                    boolean isExtra = promptYesNo("Extra " + cheeseName + "? (y/n): ");
                    sandwich.addTopping(new Cheese(cheeseName, isExtra));
                }
                case 4 -> {
                    String regName = promptRegularToppingChoice();
                    boolean isExtra = promptYesNo("Extra " + regName + "? (y/n): ");
                    sandwich.addTopping(new RegularTopping(regName, isExtra));
                }
                case 5 -> {
                    String sauceName = promptSauceChoice();
                    sandwich.addTopping(new Sauce(sauceName));
                }
                case 0 -> customizing = false;
                default -> System.out.println("Invalid choice, please try again!");
            }
        }
    }





    public void addDrink() {
        System.out.println("\n===== Add Drink =====");

        String flavor = promptDrinkFlavor();
        String size = promptDrinkSize();

        Drink drink = new Drink(size, flavor);

        currentOrder.addItem(drink);
        System.out.println("Drink added to order.");
    }

    public void addChips() {
        String flavor = promptChipsFlavor();

        Chips chips = new Chips(flavor);
        currentOrder.addItem(chips);
        System.out.println("Chips added to order.");
    }

    public void checkout() {
        showOrder();
        while (true) {
            System.out.print("1) Confirm   0) Cancel Order: ");
            String input = scanner.nextLine().trim();

            if (input.equals("1")) {
                fileManager.saveTransaction(currentOrder);
                System.out.println("Order confirmed. Receipt saved in receipts folder.");
                currentOrder = null;
                break;
            } else if (input.equals("0")) {
                System.out.println("Order cancelled. Nothing was saved.");
                currentOrder = null;
                break;
            } else {
                System.out.println("Invalid choice. Please enter 1 or 0.");
            }
        }
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

    private void showOrder() {
        if (currentOrder == null || currentOrder.getItems().isEmpty()) {
            System.out.println("Unable to checkout, there are no items in your order.");
            return;
        }

        System.out.println("\n===== ORDER DETAILS =====");
        for (Item item : currentOrder.getItems()) {
            System.out.println(item);
        }
        System.out.println("-------------------------");
        System.out.printf("TOTAL: $%.2f%n", currentOrder.getTotalPrice());
        System.out.println("=========================");
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

    private String promptDrinkFlavor() {
        while (true) {
            System.out.println("Choose drink flavor:");
            System.out.println("1) Coke");
            System.out.println("2) Sprite");
            System.out.println("3) Iced Tea");
            System.out.println("4) Lemonade");
            System.out.print("Enter Your Choice: ");

            int choice = readInt();

            switch (choice) {
                case 1: return "Coke";
                case 2: return "Sprite";
                case 3: return "Iced Tea";
                case 4: return "Lemonade";
                default:
                    System.out.println("Invalid choice, please try again!");
            };
        }
    }

    private String promptDrinkSize() {
        while (true) {
            System.out.println("\nChoose drink size:");
            System.out.println("1) Small");
            System.out.println("2) Medium");
            System.out.println("3) Large");
            System.out.print("Enter Your Choice: ");

            int choice = readInt();
            switch (choice) {
                case 1: return "Small";
                case 2: return "Medium";
                case 3: return "Large";
                default:
                    System.out.println("Invalid choice, please try again!");
            }
        }
    }

    private int promptSandwichSize() {
        while (true) {
            System.out.println("Choose sandwich size:");
            System.out.println("1) 4\"");
            System.out.println("2) 8\"");
            System.out.println("3) 12\"");
            System.out.print("Enter Your Choice: ");

            int choice = readInt();
            switch (choice) {
                case 1: return 4;
                case 2: return 8;
                case 3: return 12;
                default:
                    System.out.println("Invalid choice, please try again!");
            }
        }
    }

    private String promptBreadType() {
        while (true) {
            System.out.println("\nChoose bread type:");
            System.out.println("1) White");
            System.out.println("2) Wheat");
            System.out.println("3) Rye");
            System.out.println("4) Wrap");
            System.out.print("Enter Your Choice: ");

            int choice = readInt();
            switch (choice) {
                case 1: return "White";
                case 2: return "Wheat";
                case 3: return "Rye";
                case 4: return "Wrap";
                default:
                    System.out.println("Invalid choice, please try again!");
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
            System.out.print("Enter your choice: ");

            int choice = readInt();
            switch (choice) {
                case 1: return "american";
                case 2: return "provolone";
                case 3: return "cheddar";
                case 4: return "swiss";
                default:
                    System.out.println("Invalid choice, please try again!");
            }
        }
    }

    private String promptChipsFlavor() {
        while (true) {
            System.out.println("\nChoose chips flavor: ");
            System.out.println("1) Classic");
            System.out.println("2) Sour Cream & Onion");
            System.out.println("3) BBQ");
            System.out.print("Enter your choice: ");

            int choice = readInt();
            switch (choice) {
                case 1: return "Classic";
                case 2: return "Sour Cream & Onion";
                case 3: return "BBQ";
                default:
                    System.out.println("Invalid choice, please try again!");
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
            System.out.print("Enter your choice: ");

            int choice = readInt();
            switch (choice) {
                case 1: return "steak";
                case 2: return "ham";
                case 3: return "salami";
                case 4: return "roast beef";
                case 5: return "chicken";
                case 6: return "bacon";
                default:
                    System.out.println("Invalid choice, please try again!");
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
            System.out.print("Enter your choice: ");

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
                    System.out.println("Invalid choice, please try again!");
            }
        }
    }

    private String promptSauceChoice() {
        while (true) {
            System.out.println("\nChoose sauce:");
            System.out.println("1) Mayo");
            System.out.println("2) Mustard");
            System.out.println("3) Ketchup");
            System.out.println("4) Ranch");
            System.out.println("5) Thousand Islands");
            System.out.println("6) Vinaigrette");
            System.out.print("Enter your choice: ");

            int choice = readInt();
            switch (choice) {
                case 1: return "mayo";
                case 2: return "mustard";
                case 3: return "ketchup";
                case 4: return "ranch";
                case 5: return "thousand islands";
                case 6: return "vinaigrette";
                default:
                    System.out.println("Invalid choice, please try again!");
            }
        }
    }

}
