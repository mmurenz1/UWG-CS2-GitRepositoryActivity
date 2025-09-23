package edu.westga.cs1302.javafx_sample_starter.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import edu.westga.cs1302.javafx_sample_starter.model.Task;

public class MainWindow {

    @FXML
    private ComboBox<String> taskPriorityComboBox;

    @FXML
    private ListView<Task> taskListView;

    @FXML
    private TextField taskNameField;

    @FXML
    private TextArea taskDescriptionArea;

    @FXML
    private Button addTaskButton;

    @FXML
    void addButton(ActionEvent event) {
        try {
            String name = this.taskNameField.getText();
            String description = this.taskDescriptionArea.getText();
            String priority = this.taskPriorityComboBox.getValue();
            
            Task newTask = new Task(name, description, priority);
            
            this.taskListView.getItems().add(newTask);
            
            this.taskNameField.clear();
            this.taskDescriptionArea.clear();
            this.taskPriorityComboBox.getSelectionModel().clearSelection();
            
        } catch (IllegalArgumentException e) {
        }
    }

    /**
     * Perform any needed initialization of UI components and underlying objects.
     */
    public void initialize() {
        this.taskPriorityComboBox.getItems().addAll("High", "Medium", "Low");
    }
}