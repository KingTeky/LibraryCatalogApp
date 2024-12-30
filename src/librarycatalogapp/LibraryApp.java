package librarycatalogapp;

import java.util.Scanner;

/**
 * A command-line interface for interacting with the library catalog.
 */
public class LibraryApp {
    private static GenericCatalog<LibraryItem> catalog = new GenericCatalog<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Library Catalog Menu:");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. View Item");
            System.out.println("4. View All Items");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    removeItem();
                    break;
                case 3:
                    viewItem();
                    break;
                case 4:
                    viewAllItems();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * Prompts the user to add a new item to the catalog.
     */
    private static void addItem() {
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter item ID: ");
        String itemID = scanner.nextLine();
        LibraryItem item = new LibraryItem(title, author, itemID);
        catalog.addItem(item);
        System.out.println("Item added successfully.");
    }

    /**
     * Prompts the user to remove an item from the catalog.
     */
    private static void removeItem() {
        System.out.print("Enter item ID to remove: ");
        String itemID = scanner.nextLine();
        catalog.removeItem(itemID);
    }

    /**
     * Prompts the user to view an item from the catalog.
     */
    private static void viewItem() {
        System.out.print("Enter item ID to view: ");
        String itemID = scanner.nextLine();
        LibraryItem item = catalog.getItem(itemID);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Item not found.");
        }
    }

    /**
     * Displays all items in the catalog.
     */
    private static void viewAllItems() {
        System.out.println("All Items in Catalog:");
        for (LibraryItem item : catalog.getAllItems()) {
            System.out.println(item);
        }
    }
}
