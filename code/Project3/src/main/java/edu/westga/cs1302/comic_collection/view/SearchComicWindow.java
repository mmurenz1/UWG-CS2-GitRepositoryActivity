package edu.westga.cs1302.comic_collection.view;

import edu.westga.cs1302.comic_collection.model.Comic;
import edu.westga.cs1302.comic_collection.viewmodel.ViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Code-behind for the SearchComicWindow.
 * 
 * @author Mickel Ishema Murenzi
 * @version Fall 2025
 */
public class SearchComicWindow {
    @FXML
    private TextField searchTitleTextField;
    
    @FXML
    private TextField searchIssueTextField;
    
    @FXML
    private Button searchButton;
    
    @FXML
    private Button closeButton;
    
    @FXML
    private Label resultLabel;
    
    private ViewModel vm;

    public SearchComicWindow(ViewModel vm) {
        this.vm = vm;
    }

    @FXML
    void initialize() {
    }

    @FXML
    void handleSearch() {
        try {
            String title = this.searchTitleTextField.getText();
            int issueNumber = Integer.parseInt(this.searchIssueTextField.getText());
            
            Comic found = this.vm.findComic(title, issueNumber);
            
            if (found != null) {
                this.resultLabel.setText("Found: " + found.getTitle() + " #" + found.getIssueNumber());
            } else {
                this.resultLabel.setText("Comic not found");
            }
        } catch (NumberFormatException e) {
            this.resultLabel.setText("Invalid issue number");
        }
    }

    @FXML
    void handleClose() {
        Stage stage = (Stage) this.closeButton.getScene().getWindow();
        stage.close();
    }
}