package org.example;

import org.example.people.Handlers;
import org.example.people.Managers;
import org.example.people.Vendors;
import org.example.people.Veterinarians;
import org.example.animals.*;

import java.util.*;
import java.util.stream.Collectors;

public class AdminMenu {

    private final Scanner scanner;

    private static boolean zooState = false;
    private final String ADMIN_USERNAME;
    private final String ADMIN_PASSWORD;

    // staff list
    private final List<Handlers> handlers = new ArrayList<>();
    private final List<Managers> managers = new ArrayList<>();
    private final List<Vendors>  vendors = new ArrayList<>();
    private final List<Veterinarians> veterinarians = new ArrayList<>();


    // animal list
    private final List<Animal> animals = new ArrayList<>();


    public AdminMenu(Scanner scanner) {
        this.scanner = scanner;
        this.ADMIN_USERNAME = "admin";
        this.ADMIN_PASSWORD = "password123";

        // populate animal list for demo
        animals.add(new Cheetah("Chester", "Cheetah"));
        animals.add(new Elephant("Elly", "Elephant"));
        animals.add(new Hippo("Hipster", "Hippo"));
        animals.add(new Owl("Owly", "Owl"));
        animals.add(new Parrot("Parry", "Parrot"));
        animals.add(new Rhino("Rhyan", "Rhino"));
        animals.add(new Tiger("Tigy", "Tiger"));
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
                        handlerMenu();
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
            System.out.println("1. Add Manager \n2. Add Handler \n3. Add Vendor \n4. Add Veterinarian \n5. View Existing Staff  \n6. Return to Admin Menu");
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


    private void handlerMenu(){


        while(true){
            System.out.println("\n----- Handler Main Menu ------");
            System.out.println("1. List Handler Assignments \n2. Assign Animal to Handler \n3. Handler Actions \n4. Return to Admin Menu");
            System.out.print("Choose an Option: ");

            int choice;

            try{
                choice = Integer.parseInt(scanner.nextLine());

                switch(choice){
                    case 1:
                        // list all handler with assigned animals

                        if(handlers.isEmpty()){
                            System.out.println("> [ERR: No Handlers Available. Add a Handler first.]");
                        }else{
                            for(Handlers handler : handlers){

                                System.out.print("Handler: " + handler.getName() + " | Animals: ") ;

                                if (handler.getAssignedAnimals().isEmpty()){
                                    System.out.println("None");
                                }else{
                                    System.out.println(handler.getAssignedAnimals().stream().map(animals -> animals.getName() + "(" + animals.getSpecies() + ")").collect(Collectors.joining(", ")));
                                }
                            }
                        }
                        break;
                    case 2:
                        // assign animals to handlers

                        if(handlers.isEmpty()){
                            System.out.println("> [ERR: No Handlers Available. Add a Handler first.]");
                            break;
                        }

                        if(animals.isEmpty()){
                            System.out.println("> [ERR: No animals available.]");
                            break;
                        }

                        System.out.println("--- Handlers List ---");
                        // print out list of handlers
                        for (int i = 0; i<handlers.size(); i++){
                            System.out.println((i+1) + ". " + handlers.get(i).getName());
                        }

                        System.out.print("Choose a Handler (Number): ");

                        int handlerIndex;

                        try{
                            handlerIndex = Integer.parseInt(scanner.nextLine()) -1;

                            if(handlerIndex < 0 || handlerIndex >= handlers.size()){
                                System.out.println("> [ERR: Invalid Input. Chosen Option out of range]");
                                break;
                            }

                        } catch (NumberFormatException e) {
                            System.out.println("> [ERR: Invalid Input. Choice must be a number.]");
                            break;
                        }



                        System.out.println("--- Animals List ---");
                        for (int i = 0; i < animals.size(); i++){
                            System.out.println((i+1) + ". " + animals.get(i).getName() + "(" + animals.get(i).getSpecies() + ")");
                        }

                        System.out.print("Choose an Animal (Number): ");

                        int animalIndex;
                        try{
                            animalIndex = Integer.parseInt(scanner.nextLine())-1;

                            if(animalIndex < 0 || animalIndex >= animals.size()){
                                System.out.println("> [ERR: Invalid Input. Chosen Option out of range]");
                                break;
                            }

                        } catch (NumberFormatException e) {
                            System.out.println("> [ERR: Invalid Input. Choice must be a number.]");
                            break;
                        }

                        Handlers selectedHandler = handlers.get(handlerIndex);
                        Animal selectedAnimal = animals.get(animalIndex);

                        selectedHandler.assignAnimal(selectedAnimal);
                        System.out.println("> [SUCCESS: " + selectedAnimal.getName()+ " assigned to " + selectedHandler.getName() + "]" );

                        break;
                    case 3:

                        // Handler Actions
                        if(handlers.isEmpty()){
                            System.out.println("> [ERR: No Handlers Available. Add a Handler first.]");
                            break;
                        }

                        System.out.println("--- Handlers List ---");
                        for (int i = 0; i < handlers.size(); i++) {
                            System.out.println((i+1) + ". " + handlers.get(i).getName());
                        }

                        System.out.print("Choose Handler (number): ");

                        int handlerActionIndex = 0;

                        try{
                            handlerActionIndex = Integer.parseInt(scanner.nextLine()) - 1;

                            if (handlerActionIndex < 0 || handlerActionIndex >= handlers.size()) {
                                System.out.println("Invalid handler selection.");
                                break;
                            }

                        }catch(NumberFormatException e){
                            System.out.println("> [ERR: Invalid Input. Chosen Option must be a number]");
                        }

                        Handlers actionHandler = handlers.get(handlerActionIndex);

                        if (actionHandler.getAssignedAnimals().isEmpty()) {
                            System.out.println("This handler has no assigned animals.");
                            break;
                        }


                        System.out.println("--- Assigned Animals List ---");
                        List<Animal> assigned = actionHandler.getAssignedAnimals();
                        for (int i = 0; i < assigned.size(); i++) {
                            System.out.println((i+1) + ". " + assigned.get(i).getName() + " (" + assigned.get(i).getSpecies() + ")");
                        }

                        System.out.print("Choose an Animal (number): ");
                        int animalsActionIndex = 0;
                        try{
                            animalsActionIndex = Integer.parseInt(scanner.nextLine()) - 1;
                            if (animalsActionIndex < 0 || animalsActionIndex >= assigned.size()) {
                                System.out.println("Invalid animal selection.");
                                break;
                            }
                        }catch(NumberFormatException e){
                            System.out.println("> [ERR: Invalid Input. Chosen Opetion must be a number]");
                        }


                        Animal actionAnimal = assigned.get(animalsActionIndex);

                        System.out.println("--- Handler Actions ---");
                        System.out.println("1. Feed \n2. Exercise \n3. Examine");
                        System.out.print("Choose Action (number): ");

                        int actionChoice;

                        try{
                            actionChoice = Integer.parseInt(scanner.nextLine());

                            switch (actionChoice) {
                                case 1:
                                    actionAnimal.eat();
                                    System.out.println("> [" + actionAnimal.getName() + " has been fed]");
                                    break;
                                case 2:
                                    actionAnimal.roam();
                                    System.out.println("> [" + actionAnimal.getName() + " has exercised]");
                                    break;
                                case 3:
                                    actionAnimal.makeSound();
                                    System.out.println( "> [" + actionAnimal.getName() + " has been examined (made sound)." + "]");
                                    break;
                                default:
                                    System.out.println("Invalid action.");
                            }


                        }catch(NumberFormatException e){
                            System.out.println("> [ERR: Invalid Input. Chosen Option must be a number]");
                        }
                        break;
                    case 4:
                        System.out.println("----- Going Back to Admin Menu! -----");
                        return;
                }

            } catch (NumberFormatException e) {
                System.out.println("> [ERR: Invalid Choice Input]");
            }

        }

    }


}
