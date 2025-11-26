package edu.westga.cs1302.coursegui;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * CourseGuiApplication extends the JavaFX Application class to build the GUI and
 * start program execution.
 * 
 * @author CS 1302
 * @version 1.0
 */
public class CourseGuiApplication extends Application {
	
	 @FXML
	    private MenuItem aboutMenuItem;

	    @FXML
	    private Button addButton;

	    @FXML
	    private MenuItem capLimitMenuItem;

	    @FXML
	    private Label capacityLabel;

	    @FXML
	    private MenuItem exitMenuItem;

	    @FXML
	    private TextField gpaTextField;

	    @FXML
	    private AnchorPane guiPane;

	    @FXML
	    private Label idErrorLabel;

	    @FXML
	    private TextField idTextField;

	    @FXML
	    private TextField nameTextField;

	    @FXML
	    private MenuItem openMenuItem;

	    @FXML
	    private Button removeAllButton;

	    @FXML
	    private Button removeButton;

	    @FXML
	    private Button searchButton;

	    @FXML
	    private ListView<?> studentListView;

	    @FXML
	    void clearNameGPA(ActionEvent event) {

	    }
	
	private static final String WINDOW_TITLE = "Course Management Menus&Dialogs Sandbox";
	private static final String GUI_FXML = "view/CourseGui.fxml";

	/**
	 * Constructs a new Application object for the Student Management demo program.
	 * 
	 * @precondition none
	 * @postcondition the object is ready to execute
	 */
	public CourseGuiApplication() {
		super();
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			Pane pane = this.loadGui();
			Scene scene = new Scene(pane);
			primaryStage.setScene(scene);
			primaryStage.setTitle(WINDOW_TITLE);
			primaryStage.show();
		} catch (IllegalStateException | IOException anException) {
			anException.printStackTrace();
		}
	}

	private Pane loadGui() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource(GUI_FXML));
		return (Pane) loader.load();
	}

	/**
	 * Launches the application.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
