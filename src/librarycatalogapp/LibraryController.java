package librarycatalogapp;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class LibraryController {
    @FXML private TextField titleField;
    @FXML private TextField authorField;
    @FXML private TextField itemIDField;
    @FXML private Button addButton;
    @FXML private Button removeButton;
    @FXML private TableView<LibraryItem> tableView;
    @FXML private TableColumn<LibraryItem, String> titleColumn;
    @FXML private TableColumn<LibraryItem, String> authorColumn;
    @FXML private TableColumn<LibraryItem, String> itemIDColumn;

    private GenericCatalog<LibraryItem> catalog = new GenericCatalog<>();

    @FXML
    public void initialize() {
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        itemIDColumn.setCellValueFactory(new PropertyValueFactory<>("itemID"));

        addButton.setOnAction(event -> addItem());
        removeButton.setOnAction(event -> removeItem());
    }

    private void addItem() {
        String title = titleField.getText();
        String author = authorField.getText();
        String itemID = itemIDField.getText();
        LibraryItem item = new LibraryItem(title, author, itemID);
        catalog.addItem(item);
        tableView.getItems().add(item);
    }

    private void removeItem() {
        String itemID = itemIDField.getText();
        catalog.removeItem(itemID);
        tableView.getItems().removeIf(item -> item.getItemID().equals(itemID));
    }
}
