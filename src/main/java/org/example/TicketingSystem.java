package org.example;

import java.util.*;

public class TicketingSystem {
    private final Scanner scanner;

    public TicketingSystem (Scanner scanner) {
        this.scanner = scanner; // Initialize with the shared scanner
    }

    public void displayMenu() {
        System.out.println("=== 🎟️ WELCOME TO THE ZOO TICKET SHOP ===\n");
        System.out.println("Here's what you can experience in the zoo:");
        System.out.println("Visit Animal Enclosures (Elephant, Lion, Owl)");
        System.out.println("Listen to Science lectures at the Hospital");
        System.out.println("Buy fun gifts at our Gift Shop");

        while (true) {
            System.out.print("\nWould you like to buy a ticket? (yes/no): ");
            String buyTicket = scanner.nextLine();

            if (buyTicket.equalsIgnoreCase("yes")) {
                System.out.print("Enter your name: ");
                String name = scanner.nextLine();

                System.out.print("Enter your age: ");
                int age = scanner.nextInt();
                scanner.nextLine();

                // Call a function or implement ticket pricing here

                break;
            } else if (buyTicket.equalsIgnoreCase("no")) {
                System.out.println("No problem! Feel free to visit us again soon.\n");
                break;
            } else {
                System.out.println("Invalid answer. Please enter 'yes' or 'no'.");
            }
        }
    }
}
