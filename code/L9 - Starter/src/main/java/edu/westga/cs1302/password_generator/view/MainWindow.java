package edu.westga.cs1302.password_generator.view;

import edu.westga.cs1302.password_generator.viewmodel.ViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javafx.scene.control.Alert;

/** Codebehind for the MainWindow of the Application.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class MainWindow {

    @FXML private CheckBox mustIncludeDigits;
    @FXML private CheckBox mustIncludeLowerCaseLetters;
    @FXML private CheckBox mustIncludeUpperCaseLetters;
    @FXML private TextField minimumLength;
    @FXML private Label errorTextLabel;
    @FXML private Label minLengthErrorText;
    @FXML private Button generatePasswordButton;
    @FXML private ListView<String> passwordHistory;
    @FXML private MenuItem saveMenuItem;
    @FXML private MenuItem aboutMenuItem;
    @FXML private MenuItem closeMenuItem;
    
    private ViewModel vm;
    
    @FXML
    void initialize() {
    	this.vm = new ViewModel();
    	this.vm.getRequireDigits().bind(this.mustIncludeDigits.selectedProperty());
    	this.vm.getRequireLowercase().bind(this.mustIncludeLowerCaseLetters.selectedProperty());
    	this.vm.getRequireUppercase().bind(this.mustIncludeUpperCaseLetters.selectedProperty());
    	this.minimumLength.setText(this.vm.getMinimumLength().getValue());
    	this.vm.getMinimumLength().bind(this.minimumLength.textProperty());
    	
    	this.errorTextLabel.textProperty().bind(this.vm.getErrorText());
    	this.passwordHistory.setItems(this.vm.getPasswordHistory());
    	
    	this.minimumLength.textProperty().addListener((observable, newValue, oldValue) -> {
    		this.minLengthErrorText.setVisible(!newValue.matches("\\d+") || Integer.parseInt(newValue) == 0);
    	});
    	
    	this.generatePasswordButton.setOnAction(
    			(event) -> { 
    				this.vm.generatePassword();
    			} 
    	);
    	
    	this.saveMenuItem.setOnAction((event) -> {
    	    this.handleSave();
    	});

    	this.aboutMenuItem.setOnAction((event) -> {
    	    this.handleAbout();
    	});

    	this.closeMenuItem.setOnAction((event) -> {
    	    this.handleClose();
    	});
    }
    
    private void handleSave() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Password History");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        
        File file = fileChooser.showSaveDialog(this.saveMenuItem.getParentPopup().getOwnerWindow());
        
        if (file != null) {
            try (FileWriter writer = new FileWriter(file)) {
                for (String password : this.vm.getPasswordHistory()) {
                    writer.write(password + "\n");
                }
            } catch (IOException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Failed to save file");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        }
    }

    private void handleAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Password Generator");
        alert.setContentText("This application generates secure passwords.\nAuthor: Mickel Murenzi");
        alert.showAndWait();
    }

    private void handleClose() {
        ((javafx.stage.Stage) this.closeMenuItem.getParentPopup().getOwnerWindow()).close();
    }
}
