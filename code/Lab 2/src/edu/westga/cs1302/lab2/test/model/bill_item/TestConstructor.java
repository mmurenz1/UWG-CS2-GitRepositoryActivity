package edu.westga.cs1302.lab2.test.model.bill_item;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import edu.westga.cs1302.lab2.model.BillItem;

class TestConstructor {

	@Test
	void testValidConstructor() {
		String name = "Pizza";
		double amount = 12.99;
		
		BillItem item = new BillItem(name, amount);
		
		assertEquals(name, item.getName());
		assertEquals(amount, item.getAmount());
	}
	
	@Test
	void testConstructorWithNullName() {
		String name = null;
		double amount = 12.99;
		
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new BillItem(name, amount));
		
		assertEquals("name must not be null.", exception.getMessage());
	}
	
	@Test
	void testConstructorWithNegativeAmount() {
	    String name = "Pizza";
	    double amount = -5.0;
	    
	    IllegalArgumentException exception = assertThrows(
	        IllegalArgumentException.class,
	        () -> new BillItem(name, amount)
	    );
	    
	    assertEquals("amount must be positive, but was -5.0", exception.getMessage());
	}
	
	@Test
	void testConstructorWithZeroAmount() {
	    String name = "Pizza";
	    double amount = 0.0;
	    
	    IllegalArgumentException exception = assertThrows(
	        IllegalArgumentException.class,
	        () -> new BillItem(name, amount)
	    );
	    
	    assertEquals("amount must be positive, but was 0.0", exception.getMessage());
	}
}
