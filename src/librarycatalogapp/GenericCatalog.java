package librarycatalogapp;

import java.util.ArrayList;
import java.util.List;

/**
 * A generic catalog class that can store and manage different types of library items.
 * @param <T> the type of library item
 */
public class GenericCatalog<T extends LibraryItem> {
    private List<T> items = new ArrayList<>();

    /**
     * Adds a new item to the catalog.
     * @param item the item to add
     */
    public void addItem(T item) {
        items.add(item);
    }

    /**
     * Removes an item from the catalog by its item ID.
     * @param itemID the ID of the item to remove
     */
    public void removeItem(String itemID) {
        boolean removed = items.removeIf(item -> item.getItemID().equals(itemID));
        if (!removed) {
            System.out.println("Error: Item with ID " + itemID + " not found.");
        }
    }

    /**
     * Retrieves an item from the catalog by its item ID.
     * @param itemID the ID of the item to retrieve
     * @return the item with the specified ID, or null if not found
     */
    public T getItem(String itemID) {
        return items.stream().filter(item -> item.getItemID().equals(itemID)).findFirst().orElse(null);
    }

    /**
     * Retrieves all items in the catalog.
     * @return a list of all items
     */
    public List<T> getAllItems() {
        return items;
    }
}
