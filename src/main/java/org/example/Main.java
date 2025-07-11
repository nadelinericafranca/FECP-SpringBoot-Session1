package org.example;

import org.example.animals.Animal;
import org.example.buildings.Buildings;
import org.example.people.People;

import java.sql.SQLOutput;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    ArrayList<Animal> animals = new ArrayList<>();
    ArrayList<People> people = new ArrayList<>();
    ArrayList<Buildings> buildings = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Welcome to the Zoo Admin Console ===\n");
        System.out.println("Please log in.");

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Implement checking of admin credentials here

        System.out.println("\nLogin successful. Welcome!\n");

        while (true) {
            System.out.println("========== 🦁 ZOO ADMIN MAIN MENU ==========");
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
                        // print statement here
                        System.exit(0);
                    default:
                        System.out.println("Invalid input. Please choose between 1 and 5.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please choose between 1 and 5.\n");
            }
        }
    }
}