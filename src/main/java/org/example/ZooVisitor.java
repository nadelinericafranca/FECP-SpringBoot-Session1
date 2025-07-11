package org.example;

import java.util.Scanner;

public class ZooVisitor {
    private final Scanner scanner;

    public ZooVisitor (Scanner scanner) {
        this.scanner = scanner; // Initialize with the shared scanner
    }

    public void displayMenu() {
        System.out.println("What would you like to do?");
        System.out.println("1. Visit Enclosure");
        System.out.println("2. Visit Shop");
        System.out.println("3. Visit Hospital");
        System.out.println("4. Leave Zoo");

        while (true) {
            System.out.print("Choose an option: ");

            try {
                int option = Integer.parseInt(scanner.nextLine());
                System.out.println();

                switch(option) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        System.out.println("You have left the zoo. 👋");
                        System.out.println("Returning to main menu...\n");
                        return;
                    default:
                        System.out.println("Invalid input. Please choose from the menu.\n");
                        break;
                }

                System.out.println("What would you like to do next?");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please choose from the menu.\n");
            }
        }
    }
}
