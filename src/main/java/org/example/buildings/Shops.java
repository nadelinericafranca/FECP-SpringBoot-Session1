package org.example.buildings;

import java.util.*;

public class Shops extends Buildings {
    private final ArrayList<Product> products = new ArrayList<>();

    public Shops() {
        products.add(new Drinks(1, "Soft Drink", 30));
        products.add(new Food(2, "Popcorn", 50));
        products.add(new Gifts(3, "Plush Toy", 120));
        products.add(new Gifts(4, "Keychain", 45));

    }
    private String name;
    private int price;
    private String type;

    public void startShopping(Scanner scanner) {
        ArrayList<Product> selectedProducts = new ArrayList<>();
        boolean stillShopping = true;

        while (stillShopping) {
            System.out.println("=== 🛒 Zoo Shop ===");
            System.out.println("Available Products: ");
            displayProducts();

            System.out.print("Enter the numbers of the item you want to buy (separated by spaces): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting Zoo Shop. Goodbye!\n");
                stillShopping = false;
                continue;
            }

            try {
                List<Integer> itemNumbers = Arrays.stream(input.split(" "))
                        .filter(s -> !s.isEmpty())
                        .map(Integer::parseInt)
                        .toList();

                for (int itemNumber : itemNumbers) {
                    Product product = getProduct(itemNumber);

                    if (product != null) {
                        selectedProducts.add(product);
                        System.out.printf("Added '%s' to your selection.\n", product.getName());
                    } else {
                        System.out.println("Item number " + itemNumber + " is invalid and was not added.");
                    }
                }

                if (selectedProducts.isEmpty()) {
                    System.out.println("No valid items selected. Please try again.\n");
                    continue;
                }

                System.out.println("\nSelected:");
                for (Product selectedProduct : selectedProducts) {
                    System.out.printf("%s (₱%d)\n", selectedProduct.getName(), selectedProduct.getPrice());
                }

                double total = calculateTotal(selectedProducts);
                System.out.printf("\nTotal: ₱%.2f\n\n", total);

                while (true) {
                    System.out.print("Proceed to checkout? (yes/no): ");
                    String proceedToCheckout = scanner.nextLine();
                    System.out.println();

                    if (proceedToCheckout.equalsIgnoreCase("yes")) {
                        System.out.println("Payment successful!");
                        generateReceipt(selectedProducts, total);
                        stillShopping = false;
                        break;
                    } else if (proceedToCheckout.equalsIgnoreCase("no")) {
                        System.out.println("Purchase cancelled. Exiting shop.\n");
                        stillShopping = false;
                        break;
                    } else {
                        System.out.println("Invalid input. Please answer 'yes' or 'no'.\n");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Item numbers must be an integers separated by spaces.\n");
            }
        }
    }

    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available at the moment.");
            return;
        }

        for (Product product : products) {
            System.out.printf("%d. %s - ₱%d\n", product.getItemNumber(), product.getName(), product.getPrice());
        }
    }

    public Product getProduct(int itemNumber) {
        if (itemNumber > 0 && itemNumber <= products.size()) {
            return products.get(itemNumber - 1);
        }
        return null;
    }

    public double calculateTotal(ArrayList<Product> selectedProducts) {
        double total = 0;

        for (Product selectedProduct : selectedProducts) {
            total += selectedProduct.getPrice();
        }
        return total;
    }

    public void generateReceipt(ArrayList<Product> purchasedProducts, double total) {
        System.out.println("Receipt:");
        for (Product product : purchasedProducts) {
            System.out.printf("- %s (₱%d)\n", product.getName(), product.getPrice());
        }
        System.out.printf("Total Paid: ₱%.2f\n\n", total);
    }
}
