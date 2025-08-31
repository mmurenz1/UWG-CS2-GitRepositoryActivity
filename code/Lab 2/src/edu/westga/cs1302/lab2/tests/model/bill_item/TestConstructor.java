package edu.westga.cs1302.lab2.tests.model.bill_item;

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

}
