package org.example;

import org.example.animals.*;
import org.example.buildings.*;
import org.example.people.*;

import java.util.*;

public class ZooVisitor {
    private final Scanner scanner;
    private ArrayList<Enclosures> enclosures;
    private Hospital hospital;
    private Veterinarians vet;

    public ZooVisitor (Scanner scanner) {
        this.scanner = scanner; // Initialize with the shared scanner
        this.enclosures = new ArrayList<Enclosures>();

        Animal elephant = new Elephant("Elephant", "Pachyderm");
        Animal tiger = new Tiger("Tiger", "Feline");
        Animal owl = new Owl("Owl", "Bird");

        Enclosures pachydermEnclosure = new Enclosures("Pachyderm", elephant);
        Enclosures felineEnclosure = new Enclosures("Feline", tiger);
        Enclosures birdEnclosure = new Enclosures("Bird", owl);

        this.enclosures.add(pachydermEnclosure);
        this.enclosures.add(felineEnclosure);
        this.enclosures.add(birdEnclosure);

        this.hospital = new Hospital();
        this.vet = new Veterinarians("Ellie");

        hospital.admitAnimal(new Elephant("Dumbo", "Pachyderm"));
        hospital.admitAnimal(new Lion("Simba", "Feline"));
    }

    public void visitEnclosure(Scanner scanner) {
        System.out.println("===Zoo Enclosure===");
        System.out.println("Choose Enclosure:");
        for (int i = 0; i < enclosures.size(); i++) {
            System.out.println((i + 1) + ". " + enclosures.get(i));
        }
        System.out.print("Choose an option: ");

        int option;
        try {
            option = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.\n");
            return; // Exit if input is not a number
        }

        Enclosures selectedEnclosure;

        switch(option) {
            case 1:
                selectedEnclosure = enclosures.getFirst();
                break;
            case 2:
                selectedEnclosure = enclosures.get(1);
                break;
            case 3:
                selectedEnclosure = enclosures.get(2);
                break;
            default: // Handle invalid numbers
                System.out.println("Invalid option. Returning to the previous menu.\n");
                return; // Exit the method
        }

        System.out.print("Would you like to feed the " + selectedEnclosure.getAnimal().getName() + "? (yes/no): ");
        String willFeed = scanner.nextLine();

        if (willFeed.equalsIgnoreCase("yes")) {
            selectedEnclosure.getAnimal().eat();
            selectedEnclosure.getAnimal().makeSound();
        }
        System.out.println(); // Add a newline for better spacing
    }

    public void visitShop() {
        Shops shop = new Shops();
        shop.startShopping(scanner);
    }

    public void visitHospital() {
        while (true) {
            System.out.println("=== 🏥 Zoo Visitor Hospital Monitor ===");
            System.out.println("1. View Sick Animals");
            System.out.println("2. View Healed Animals");
            System.out.println("3. Attend Science Lecture");
            System.out.println("4. Heal Animals (Veterinarian)");
            System.out.println("5. Exit");

            System.out.print("Choose an option: ");

            try {
                int option = Integer.parseInt(scanner.nextLine());
                System.out.println();

                switch (option) {
                    case 1:
                        hospital.displaySickAnimals();
                        break;
                    case 2:
                        hospital.displayHealedAnimals();
                        break;
                    case 3:
                        vet.lecture();
                        break;
                    case 4:
                        hospital.healSickAnimals(vet);
                        break;
                    case 5:
                        System.out.println("Exiting Zoo Vet Hospital. Goodbye!\n");
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

    public void displayMenu() {
        System.out.print("Enter ticket code: ");
        String codeToCheck = scanner.nextLine();
        System.out.println();
        boolean doesTicketExist = checkForTicket(codeToCheck);

        if (!doesTicketExist){
            System.out.println("Please buy a ticket first.");
            return;
        }

        System.out.println("What would you like to do?");

        while (true) {
            System.out.println("1. Visit Enclosure");
            System.out.println("2. Visit Shop");
            System.out.println("3. Visit Hospital");
            System.out.println("4. Leave Zoo");
            System.out.print("Choose an option: ");

            try {
                int option = Integer.parseInt(scanner.nextLine());
                System.out.println();

                switch(option) {
                    case 1:
                        visitEnclosure(scanner);
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

    public boolean checkForTicket(String codeToCheck) {
        for(Ticket ticket: TicketingSystem.purchasedTickets) {
            if(ticket.code.equals(codeToCheck)) {
                return true;
            }
        }

        return false;
    }
}
