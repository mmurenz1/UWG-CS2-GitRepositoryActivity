package edu.westga.cs1302.comic_collection.view;

import edu.westga.cs1302.comic_collection.model.Collection;
import edu.westga.cs1302.comic_collection.model.Comic;
import edu.westga.cs1302.comic_collection.viewmodel.ViewModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Code-behind for the MainWindow.
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
    private MenuItem removeCollectionMenuItem;
    
    @FXML
    private ListView<Comic> comicsListView;
    
    @FXML
    private Button addComicButton;
    
    @FXML
    private Button removeComicButton;
    
    @FXML
    private MenuItem removeComicMenuItem;
    
    @FXML
    private Button searchComicButton;
    
    private ViewModel vm;

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
        
        this.addCollectionButton.setDisable(true);
        this.collectionNameTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            this.addCollectionButton.setDisable(newValue.trim().isEmpty());
        });
        
        this.comicsListView.setItems(this.vm.getComicsInSelectedCollection());
        this.comicsListView.setCellFactory(lv -> new javafx.scene.control.ListCell<Comic>() {
            @Override
            protected void updateItem(Comic item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? null : item.getTitle() + " #" + item.getIssueNumber());
            }
        });
        
        this.collectionsListView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                this.vm.setSelectedCollection(newVal);
                this.vm.getComicsInSelectedCollection().setAll(newVal.getComics());
            }
        });
    }

    @FXML
    void handleAddCollection() {
        try {
            this.vm.addCollection();
        } catch (IllegalArgumentException error) {
        }
    }

    @FXML
    void handleRemoveCollection() {
        Collection selected = this.collectionsListView.getSelectionModel().getSelectedItem();
        this.vm.setSelectedCollection(selected);
        this.vm.removeSelectedCollection();
    }

    @FXML
    void handleAddComicWindow() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainWindow.class.getResource("AddComicWindow.fxml"));
            loader.setControllerFactory(c -> new AddComicWindow(this.vm));
            Parent parent = loader.load();
            
            Stage stage = new Stage();
            stage.setTitle("Add Comic");
            stage.setScene(new Scene(parent));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleRemoveComic() {
        Comic selected = this.comicsListView.getSelectionModel().getSelectedItem();
        this.vm.setSelectedComic(selected);
        this.vm.removeSelectedComic();
    }
    
    @FXML
    void handleSearchComic() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainWindow.class.getResource("SearchComicWindow.fxml"));
            loader.setControllerFactory(c -> new SearchComicWindow(this.vm));
            Parent parent = loader.load();
            
            Stage stage = new Stage();
            stage.setTitle("Search Comic");
            stage.setScene(new Scene(parent));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}