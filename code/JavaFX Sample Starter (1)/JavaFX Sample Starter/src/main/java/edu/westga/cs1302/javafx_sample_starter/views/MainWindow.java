package edu.westga.cs1302.javafx_sample_starter.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;

public class MainWindow {

    @FXML
    private ComboBox<String> taskPriorityComboBox;

    @FXML
    private ListView<String> taskListView;

    @FXML
    private TextField taskNameField;

    @FXML
    private TextArea taskDescriptionArea;

    @FXML
    private Button addTaskButton;

    @FXML
    void addButton(ActionEvent event) {
    }

    /**
     * Perform any needed initialization of UI components and underlying objects.
     */
    public void initialize() {
    }
}
