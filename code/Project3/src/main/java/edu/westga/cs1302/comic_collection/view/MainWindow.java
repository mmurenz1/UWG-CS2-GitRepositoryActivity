package edu.westga.cs1302.comic_collection.view;

import edu.westga.cs1302.comic_collection.model.Collection;
import edu.westga.cs1302.comic_collection.viewmodel.ViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

/**
 * Code-behind for the MainWindow of the Comic Collection application.
 * 
 * @author Mickel Ishema Murenzi
 * @version Fall 2025
 */
public class MainWindow {
    @FXML
    private TextField collectionNameTextField;
    
    @FXML
    private Button addCollectionButton;
    
    @FXML
    private ListView<Collection> collectionsListView;
    
    @FXML
    private Button removeCollectionButton;
    
    @FXML
    private MenuItem removeMenuItem;
    
    private ViewModel vm;

    /**
     * Creates a new MainWindow.
     * 
     * @precondition none
     * @postcondition the window is initialized
     */
    public MainWindow() {
        this.vm = new ViewModel();
    }

    @FXML
    void initialize() {
        this.collectionNameTextField.textProperty().bindBidirectional(this.vm.collectionNameProperty());
        this.collectionsListView.setItems(this.vm.getCollections());
        this.collectionsListView.setCellFactory(lv -> new javafx.scene.control.ListCell<Collection>() {
            @Override
            protected void updateItem(Collection item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : item.getName());
            }
        });
    }

    @FXML
    void handleAddCollection() {
        try {
            this.vm.addCollection();
        } catch (IllegalArgumentException error) {
            // TODO: Add error handling in later tasks
        }
    }

    @FXML
    void handleRemoveCollection() {
        Collection selected = this.collectionsListView.getSelectionModel().getSelectedItem();
        this.vm.setSelectedCollection(selected);
        this.vm.removeSelectedCollection();
    }
}