package edu.westga.cs1302.password_generator.view;

import edu.westga.cs1302.password_generator.viewmodel.PasswordGeneratorViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Codebehind for the MainWindow of the Application.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class MainWindow {

	@FXML
	private CheckBox mustIncludeDigits;
	@FXML
	private CheckBox mustIncludeLowerCaseLetters;
	@FXML
	private CheckBox mustIncludeUpperCaseLetters;
	@FXML
	private TextField minimumLength;
	@FXML
	private TextArea output;

	private PasswordGeneratorViewModel viewModel;

	@FXML
	void generatePassword() {
		this.viewModel.generatePassword();
		
		String errorMessage = this.viewModel.errorMessageProperty().get();
		if (!errorMessage.isEmpty()) {
			this.output.setText(errorMessage);
		}
	}

	@FXML
	void initialize() {
		this.viewModel = new PasswordGeneratorViewModel();
		
		this.minimumLength.setText("1");
		
		this.bindToViewModel();
	}
	
	private void bindToViewModel() {
		this.minimumLength.textProperty().bindBidirectional(this.viewModel.minimumLengthProperty());
		this.output.textProperty().bind(this.viewModel.outputProperty());
		this.mustIncludeDigits.selectedProperty().bindBidirectional(this.viewModel.mustIncludeDigitsProperty());
		this.mustIncludeLowerCaseLetters.selectedProperty().bindBidirectional(this.viewModel.mustIncludeLowerCaseLettersProperty());
		this.mustIncludeUpperCaseLetters.selectedProperty().bindBidirectional(this.viewModel.mustIncludeUpperCaseLettersProperty());
	}
}