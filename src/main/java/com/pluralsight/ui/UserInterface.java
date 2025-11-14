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

}
