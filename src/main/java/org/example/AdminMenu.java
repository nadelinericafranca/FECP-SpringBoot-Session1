package org.example;

import java.util.*;

public class AdminMenu {

    private final Scanner scanner;
    private static boolean zooState = false;
    private final String ADMIN_USERNAME;
    private final String ADMIN_PASSWORD;

    public AdminMenu(Scanner scanner) {
        this.scanner = scanner;
        this.ADMIN_USERNAME = "admin";
        this.ADMIN_PASSWORD = "password123";
    }

    // method for other modules to check zooState
    public static boolean isZooOpen(){
        return zooState;
    }

    public void displayMenu() {

        boolean loggedIn = false;

        System.out.println("=== Welcome to the Zoo Admin Console ===");

        while(!loggedIn) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();

            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            if(username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)){
                loggedIn = true;
                System.out.println("> [Login Successful! Welcome!]");
            }else{
                System.out.println("> [ERR: Incorrect credentials. Please try again.]\n");
            }

        }

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
                        openZoo();
                        break;
                    case 4:
                        closeZoo();
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

    // open zoo method
    private static void openZoo(){
        if(zooState){
            System.out.println("> Zoo is already OPEN to visitors.");
        }else{
            zooState = true;
            System.out.println("----- Opening the Zoo -----");
            System.out.println("> Zoo is now OPEN to visitors!");
        }
    }

    // close zoo method
    private static void closeZoo(){
        if(zooState){
            zooState = false;
            System.out.println("------ Closing the Zoo -----");
            System.out.println("> Zoo is now CLOSED to visitors.");
        }else{
            System.out.println("> Zoo is already CLOSED to visitors.");
        }
    }





}
