package edu.westga.cs1302.lab2.test.view.bill_view;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import edu.westga.cs1302.lab2.model.Bill;
import edu.westga.cs1302.lab2.model.BillItem;
import edu.westga.cs1302.lab2.view.BillView;

class TestGetText {

	@Test
    void testGetTextWithEmptyBill() {
        Bill bill = new Bill();
        BillView view = new BillView();
        
        String result = view.getText(bill);
        
        assertNotNull(result);
        assertTrue(result.contains("ITEMS"));
        assertTrue(result.contains("SUBTOTAL"));
        assertTrue(result.contains("TAX"));
        assertTrue(result.contains("TIP"));
        assertTrue(result.contains("TOTAL"));
    }
    
    @Test
    void testGetTextWithSingleItem() {
        Bill bill = new Bill();
        BillItem item = new BillItem("Pizza", 10.0);
        bill.addItem(item);
        BillView view = new BillView();
        
        String result = view.getText(bill);
        
        assertTrue(result.contains("Pizza"));
        assertTrue(result.contains("10.0"));
        assertTrue(result.contains("SUBTOTAL - $10.0"));
    }
    
    @Test
    void testGetTextWithMultipleItems() {
        Bill bill = new Bill();
        BillItem item1 = new BillItem("Pizza", 10.0);
        BillItem item2 = new BillItem("Soda", 5.0);
        bill.addItem(item1);
        bill.addItem(item2);
        BillView view = new BillView();
        
        String result = view.getText(bill);
        
        assertTrue(result.contains("Pizza"));
        assertTrue(result.contains("Soda"));
        assertTrue(result.contains("SUBTOTAL - $15.0"));
    }

}
