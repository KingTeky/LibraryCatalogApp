package librarycatalogapp;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the GenericCatalog and LibraryItem classes.
 */
public class LibraryCatalogTest {
    private GenericCatalog<LibraryItem> catalog;

    @BeforeEach
    public void setUp() {
        catalog = new GenericCatalog<>();
    }

    @Test
    public void testAddItem() {
        LibraryItem item = new LibraryItem("Title1", "Author1", "ID1");
        catalog.addItem(item);
        assertEquals(1, catalog.getAllItems().size());
    }

    @Test
    public void testRemoveItem() {
        LibraryItem item = new LibraryItem("Title1", "Author1", "ID1");
        catalog.addItem(item);
        catalog.removeItem("ID1");
        assertEquals(0, catalog.getAllItems().size());
    }

    @Test
    public void testGetItem() {
        LibraryItem item = new LibraryItem("Title1", "Author1", "ID1");
        catalog.addItem(item);
        LibraryItem retrievedItem = catalog.getItem("ID1");
        assertNotNull(retrievedItem);
        assertEquals("Title1", retrievedItem.getTitle());
    }

    @Test
    public void testRemoveNonExistentItem() {
        catalog.removeItem("NonExistentID");
        assertEquals(0, catalog.getAllItems().size());
    }
}
