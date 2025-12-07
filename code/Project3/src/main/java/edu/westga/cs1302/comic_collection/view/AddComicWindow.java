package edu.westga.cs1302.comic_collection.view;

import edu.westga.cs1302.comic_collection.viewmodel.ViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Code-behind for the AddComicWindow.
 * 
 * @author Mickel Ishema Murenzi
 * @version Fall 2025
 */
public class AddComicWindow {
    @FXML
    private TextField titleTextField;
    
    @FXML
    private TextField issueNumberTextField;
    
    @FXML
    private Button confirmButton;
    
    @FXML
    private Button cancelButton;
    
    private ViewModel vm;

    public AddComicWindow(ViewModel vm) {
        this.vm = vm;
    }

    @FXML
    void initialize() {
        // Binding will be added in Task 2D
    }

    @FXML
    void handleConfirm() {
        try {
            this.vm.addComic();
            Stage stage = (Stage) this.confirmButton.getScene().getWindow();
            stage.close();
        } catch (Exception e) {
            // Error handling
        }
    }

    @FXML
    void handleCancel() {
        Stage stage = (Stage) this.cancelButton.getScene().getWindow();
        stage.close();
    }
}
