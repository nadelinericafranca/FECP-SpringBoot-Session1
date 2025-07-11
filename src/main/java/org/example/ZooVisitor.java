package org.example;

import org.example.animals.Animal;
import org.example.buildings.Hospital;

import java.util.*;

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
                        visitShop();
                        break;
                    case 3:
                        visitHospital();
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

    public void visitShop() {
        while (true) {
            System.out.println("=== 🛒 Zoo Shop ===");
            System.out.println("Available Products: ");

            System.out.print("Enter the numbers of the items you want to buy: ");

            try {
                int itemNumber = Integer.parseInt(scanner.nextLine());

                break;
            } catch (NumberFormatException e) {
                System.out.println("Item number must be an integer.\n");
            }
        }
    }

    public void visitHospital() {
        Hospital hospital = new Hospital();

        while (true) {
            System.out.println("=== 🏥 Zoo Visitor Hospital Monitor ===");
            System.out.println("1. View Sick Animals");
            System.out.println("2. View Healed Animals");
            System.out.println("3. Attend Science Lecture");
            System.out.println("4. Heal Animals (Veterinarian");
            System.out.println("5. Exit");

            System.out.print("Choose an option: ");

            try {
                int option = Integer.parseInt(scanner.nextLine());
                System.out.println();

                switch (option) {
                    case 1:

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:
                        System.out.println("Exiting Zoo Vet Hospital. Goodbye!");
                        break;
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
