package org.example;

import java.util.*;

public class TicketingSystem {
    private final Scanner scanner;

    // store purchased tickets
    public static List<Ticket> purchasedTickets = new ArrayList<>();

    public TicketingSystem (Scanner scanner) {
        this.scanner = scanner;
        // Initialize with the shared scanner
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
                int age;
                try{
                    age = Integer.parseInt(scanner.nextLine());

                    if(age <0){
                        System.out.println("> [ERR: Age must be >= 0]");
                        break;
                    }

                    String type = checkTicketType(age);
                    double price = getTicketPrice(type);

                    System.out.println("--- Ticket Breakdown ---");
                    System.out.println("Ticket Type: " + type + "\nPrice: Php" + price);
                    System.out.print("\nConfirm Purchase? (yes/no): ");

                    String confirmPurchase = scanner.nextLine();

                    if(confirmPurchase.equalsIgnoreCase("yes")){
                        String code = generateTicketCode();
                        Ticket ticket = new Ticket(name, age, type, price, code);
                        purchasedTickets.add(ticket);

                        System.out.println("----- Ticket Purchased! -----");
                        System.out.println("Name: " + name + "\nAge: " + age + "\nTicket Type: " + type + "\nPrice: Php" + price + "\nTICKET CODE: " + code + "\n");
                    }else{
                        System.out.println("> [PURCHASE CANCELLED]");
                    }


                } catch (NumberFormatException e) {
                    System.out.println("> [ERR: Invalid Input. Age must be a number]");
                }



                break;
            } else if (buyTicket.equalsIgnoreCase("no")) {
                System.out.println("No problem! Feel free to visit us again soon.\n");
                break;
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }
        }
    }

    // check ticket type method
    private String checkTicketType(int age){
        if (age <= 5) {
            return "Child";
        } else if (age <= 17) {
            return "Student";
        } else if (age <=59){
            return "Adult";
        } else{
            return "Senior";
        }
    }

    private double getTicketPrice(String type){
        return switch (type) {
            case "Child" -> 0.0;
            case "Student" -> 75.0;
            case "Adult" -> 150.0;
            case "Senior" -> 50.0;
            default -> 0.0;
        };
    }


    // generate ticket code
    private String generateTicketCode(){
        Random rand = new Random();

        while(true){
            int num = 1000 + rand.nextInt(9000);
            String code = "ZOO-" + num;
            boolean ticketExists = false;

            for(Ticket ticket:purchasedTickets){
                if (ticket.code.equals(code)){
                    ticketExists = true;
                    break;
                }
            }

            if(!ticketExists) return code;

        }



    }


}
