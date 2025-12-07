package edu.westga.cs1302.e3.view;

import edu.westga.cs1302.e3.model.Student;
import edu.westga.cs1302.e3.viewmodel.Exam3PrepViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/** Codebehind for the MainWindow of the Application.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class MainWindow {
    @FXML private TextField nameTextField;
    @FXML private ListView<Student> studentsListView;
    @FXML private ComboBox<Integer> gpaComboBox;
    @FXML private Button addStudentButton;
    @FXML private Button displayDetailsButton;
	
	private Exam3PrepViewModel vm; 

    @FXML
    void initialize() {
    	
    }
	
}
