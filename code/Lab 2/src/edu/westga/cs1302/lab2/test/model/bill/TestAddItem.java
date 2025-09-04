package edu.westga.cs1302.lab2.test.model.bill;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import edu.westga.cs1302.lab2.model.Bill;
import edu.westga.cs1302.lab2.model.BillItem;

class TestAddItem {

	@Test
    void testAddValidItem() {
        Bill bill = new Bill();
        BillItem item = new BillItem("Pizza", 12.99);
        
        bill.addItem(item);
        
        assertEquals("Pizza", bill.getItems().get(0).getName());
        assertEquals(12.99, bill.getItems().get(0).getAmount());
    }
    
    @Test
    void testAddNullItem() {
        Bill bill = new Bill();
        BillItem item = null;
        
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> bill.addItem(item)
        );
        
        assertEquals("item must not be null.", exception.getMessage());
    }
    
    @Test
    void testAddMultipleItems() {
        Bill bill = new Bill();
        BillItem item1 = new BillItem("Pizza", 12.99);
        BillItem item2 = new BillItem("Soda", 2.50);
        
        bill.addItem(item1);
        bill.addItem(item2);
        
        assertEquals(2, bill.getItems().size());
        assertEquals(item1, bill.getItems().get(0));
        assertEquals(item2, bill.getItems().get(1));
    }

}
