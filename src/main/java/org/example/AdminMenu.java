package org.example;

import java.util.*;

public class AdminMenu {
    private final Scanner scanner;

    public AdminMenu(Scanner scanner) {
        this.scanner = scanner; // Initialize with the shared scanner
    }

    public void displayMenu() {
        System.out.println("=== Welcome to the Zoo Admin Console ===\n");
        System.out.println("Please log in.");

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Implement checking of admin credentials here

        System.out.println("\nLogin successful. Welcome!");

        while (true) {
            System.out.println("\n========== 🦁 ZOO ADMIN MAIN MENU ==========");
            System.out.println("1. Setup Zoo Staff");
            System.out.println("2. Access Handler Module");
            System.out.println("3. Open Zoo to Visitors");
            System.out.println("4. Close Zoo to Visitors");
            System.out.println("5. Exit");

            System.out.print("Choose an option: ");

            try {
                int option = Integer.parseInt(scanner.nextLine());

                switch(option) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        System.out.println("Returning to main menu...\n");
                        return;
                    default:
                        System.out.println("Invalid input. Please choose from the menu.\n");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please choose from the menu.\n");
            }
        }
    }
}
