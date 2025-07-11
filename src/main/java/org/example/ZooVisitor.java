package org.example;

import org.example.buildings.Enclosures;
import java.util.*;

import java.util.Scanner;

public class ZooVisitor {
    private final Scanner scanner;
    private ArrayList<Enclosures> enclosures;

    public ZooVisitor (Scanner scanner) {
        this.scanner = scanner; // Initialize with the shared scanner
        // TODO: Initialize enclosure ?
    }

    public void visitEnclosure(Scanner scanner) {
        System.out.println("===Zoo Enclosure===");
        System.out.println("Choose Enclosure:");
        // TODO: use forEach to print list of enclosures
        System.out.println("1. Pachyderm (Elephant)");
        System.out.println("2. Feline (Lion)");
        System.out.println("3. Bird (Owl)");
        System.out.print("Choose an option: ");

        int option;
        try {
            option = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.\n");
            return; // Exit if input is not a number
        }

        String animal;
        String animalSound;

        switch(option) {
            case 1:
                animal = "Elephant";
                animalSound = "trumpets";
                break;
            case 2:
                animal = "Lion";
                animalSound = "roars";
                break;
            case 3:
                animal = "Owl";
                animalSound = "hoots";
                break;
            default: // Handle invalid numbers
                System.out.println("Invalid option. Returning to the previous menu.\n");
                return; // Exit the method
        }

        System.out.print("Would you like to feed the " + animal + "? (yes/no): ");
        String willFeed = scanner.nextLine();

        if (willFeed.equalsIgnoreCase("yes")) {
            System.out.println(animal + " is eating.");
            System.out.println(animal + " " + animalSound + "!");
        }
        System.out.println(); // Add a newline for better spacing
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
                        visitEnclosure(scanner);
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
