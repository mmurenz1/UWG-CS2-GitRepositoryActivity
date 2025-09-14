package edu.westga.cs1302.bill.test.model.bill_calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import edu.westga.cs1302.bill.model.BillCalculator;
import edu.westga.cs1302.bill.model.BillItem;

class TestBillCalculator {

    @Test
    void testGetSubTotalWithValidItems() {
        BillItem[] items = {
            new BillItem("Pizza", 10.0),
            new BillItem("Soda", 5.0)
        };
        
        double result = BillCalculator.getSubTotal(items);
        
        assertEquals(15.0, result);
    }
    
    @Test
    void testGetSubTotalWithEmptyArray() {
        BillItem[] items = {};
        
        double result = BillCalculator.getSubTotal(items);
        
        assertEquals(0.0, result);
    }
    
    @Test
    void testGetSubTotalWithNullArray() {
        BillItem[] items = null;
        
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> BillCalculator.getSubTotal(items)
        );
        assertEquals("items array must not be null", exception.getMessage());
    }
    
    @Test
    void testGetSubTotalWithNullItemInArray() {
        BillItem[] items = {
            new BillItem("Pizza", 10.0),
            null
        };
        
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> BillCalculator.getSubTotal(items)
        );
        assertEquals("items array must not contain null values", exception.getMessage());
    }
    
    @Test
    void testGetTaxWithValidSubtotal() {
        double subtotal = 10.0;
        
        double result = BillCalculator.getTax(subtotal);
        
        assertEquals(1.0, result); 
    }
    
    @Test
    void testGetTipWithValidSubtotal() {
        double subtotal = 10.0;
        
        double result = BillCalculator.getTip(subtotal);
        
        assertEquals(2.0, result); 
    }
    
    @Test
    void testGetTotalWithValidSubtotal() {
        double subtotal = 10.0;
        
        double result = BillCalculator.getTotal(subtotal);
        
        assertEquals(13.0, result); 
    }
}