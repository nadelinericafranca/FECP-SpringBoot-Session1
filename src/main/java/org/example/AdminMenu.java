package org.example;

import org.example.people.Handlers;
import org.example.people.Managers;
import org.example.people.Vendors;
import org.example.people.Veterinarians;

import java.util.*;
import java.util.stream.Collectors;

public class AdminMenu {

    private final Scanner scanner;

    private static boolean zooState = false;
    private final String ADMIN_USERNAME;
    private final String ADMIN_PASSWORD;

    // staff list
    private List<Handlers> handlers = new ArrayList<>();
    private List<Managers> managers = new ArrayList<>();
    private List<Vendors>  vendors = new ArrayList<>();
    private List<Veterinarians> veterinarians = new ArrayList<>();


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
                        staffSetupMenu();
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
            System.out.println("\n----- Opening the Zoo -----");
            System.out.println("> Zoo is now OPEN to visitors!");
        }
    }

    // close zoo method
    private static void closeZoo(){
        if(zooState){
            zooState = false;
            System.out.println("\n------ Closing the Zoo -----");
            System.out.println("> Zoo is now CLOSED to visitors.");
        }else{
            System.out.println("> Zoo is already CLOSED to visitors.");
        }
    }


    // setup staff method
    private void staffSetupMenu(){

        while(true){
            System.out.println("\n----- Setup Zoo Staff -----");
            System.out.println("1. Add Manager \n2. Add Handler \n3. Add Vendor \n4. Add Veterinarian \n5. View Existing Staff  \n6. Back to Main Menu");
            System.out.print("Choose a Staff to Add: ");

            int choice;

            try{
                choice = Integer.parseInt(scanner.nextLine());

                switch(choice){
                    case 1:
                        System.out.print("\nEnter Manager Name: ");
                        String managerName = scanner.nextLine();
                        managers.add(new Managers(managerName));
                        System.out.println(managerName + " Added as Manager!");
                        break;
                    case 2:
                        System.out.print("\nEnter Handler Name: ");
                        String handlerName = scanner.nextLine();
                        handlers.add(new Handlers(handlerName));
                        System.out.println(handlerName + " Added as Handler!");
                        break;
                    case 3:
                        System.out.print("\nEnter Vendor Name: ");
                        String vendorName = scanner.nextLine();
                        vendors.add(new Vendors(vendorName));
                        System.out.println(vendorName + " Added as Vendor!");
                        break;
                    case 4:
                        System.out.print("\nEnter Veterinarian Name: ");
                        String veterinarianName = scanner.nextLine();
                        veterinarians.add(new Veterinarians(veterinarianName));
                        System.out.println(veterinarianName + " Added as Veterinarian!");
                        break;
                    case 5:
                        getStaff();
                        break;
                    case 6:
                        System.out.println("----- Going Back to Admin Menu! -----");
                        return;
                    default:
                        System.out.println("> [ERR: Please Choose between 1-5 only.]");
                }

            } catch (NumberFormatException e) {
                System.out.println("> [ERR: Invalid Input for Choice.]");
            }
        }



    }


    // helper method to print existing staff
    private void getStaff(){
        System.out.println("\n----- Existing Zoo Staff -----");

        String managersList = managers.stream().map(Managers::getName).collect(Collectors.joining(", "));
        System.out.println("Managers: " + managersList);

        String handlersList = handlers.stream().map(Handlers::getName).collect(Collectors.joining(", "));
        System.out.println("Handlers: " + handlersList);

        String vendorsList = vendors.stream().map(Vendors::getName).collect(Collectors.joining(", "));
        System.out.println("Vendors: " + vendorsList);

        String veterinariansList = veterinarians.stream().map(Veterinarians::getName).collect(Collectors.joining(", "));
        System.out.println("Veterinarians: " + veterinariansList);

    }






}
