package edu.westga.cs1302.lab3.views;
import edu.westga.cs1302.lab3.model.Bill;
import edu.westga.cs1302.lab3.model.BillItem;
import edu.westga.cs1302.lab3.views.BillView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Controller class for drawing various things to our canvas window.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class MainWindow {
		
	    @FXML
	    private TextField amount;

	    @FXML
	    private TextField name;

	    @FXML
	    private TextArea output;

	    @FXML
	    void addItem(ActionEvent event) {
	    	
	        String itemName = this.name.getText();
	        String amountText = this.amount.getText();
	        double itemAmount = Double.parseDouble(amountText);
	        
	        BillItem item = new BillItem(itemName, itemAmount);
	        
	        this.bill.addItem(item);
	        
	        BillView view = new BillView();
	        String billText = view.getText(this.bill);
    }
    
    /**
     * Perform any needed initialization of UI components and underlying objects.
     */
    public void initialize() {
    }
}
