package org.example;

import org.example.animals.Animal;
import org.example.buildings.Buildings;
import org.example.people.People;

import java.util.*;

public class Main {
    ArrayList<Animal> animals = new ArrayList<>();
    ArrayList<People> people = new ArrayList<>();
    ArrayList<Buildings> buildings = new ArrayList<>();

    static Scanner scanner = new Scanner(System.in);
    static AdminMenu adminMenu = new AdminMenu(scanner);
    static TicketingSystem ticketingSystem = new TicketingSystem(scanner);
    static ZooVisitor zooVisitor = new ZooVisitor(scanner);

    public static void main(String[] args) {
        while (true) {
            System.out.println("========== WELCOME TO THE MAIN MENU! ==========");
            System.out.println("1. Admin Login");
            System.out.println("2. Buy Ticket");
            System.out.println("3. Enter Zoo");
            System.out.println("4. Exit");

            System.out.print("Choose an option: ");

            try {
                int option = Integer.parseInt(scanner.nextLine());
                System.out.println();

                switch (option) {
                    case 1:
                        adminMenu.displayMenu();
                        break;
                    case 2:
                        ticketingSystem.displayMenu();
                        break;
                    case 3:
                        // TODO: Implement open/closing
                        zooVisitor.displayMenu();
                        break;
                    case 4:
                        System.out.println("--- Thank you! ---");
                        System.exit(0);
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