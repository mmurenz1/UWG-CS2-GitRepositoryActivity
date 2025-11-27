package edu.westga.cs1302.contact_manager.viewmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs1302.contact_manager.model.Contact;

/**
 * Unit tests for MainWindowViewModel class.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
class TestMainWindowViewModel {
	
	private MainWindowViewModel viewModel;
	
	@BeforeEach
	void setUp() {
		this.viewModel = new MainWindowViewModel();
	}
	
	@Test
	void testAddValidContact() {
		this.viewModel.getName().set("Alice");
		this.viewModel.getPhoneNumber().set("555-1234");
		
		this.viewModel.addContact();
		
		assertEquals(1, this.viewModel.getContacts().size());
		Contact contact = (Contact) this.viewModel.getContacts().get(0);
		assertEquals("Alice", contact.getName());
	}
	
	@Test
	void testAddContactWithDuplicateName() {
		this.viewModel.getName().set("Alice");
		this.viewModel.getPhoneNumber().set("555-1234");
		this.viewModel.addContact();
		
		this.viewModel.getName().set("Alice");
		this.viewModel.getPhoneNumber().set("555-9999");
		
		assertThrows(IllegalArgumentException.class, () -> {
			this.viewModel.addContact();
		});
		
		assertEquals(1, this.viewModel.getContacts().size());
	}
	
	@Test
	void testAddContactWithDuplicatePhone() {
		this.viewModel.getName().set("Alice");
		this.viewModel.getPhoneNumber().set("555-1234");
		this.viewModel.addContact();
		
		this.viewModel.getName().set("Bob");
		this.viewModel.getPhoneNumber().set("555-1234");
		
		assertThrows(IllegalArgumentException.class, () -> {
			this.viewModel.addContact();
		});
		
		assertEquals(1, this.viewModel.getContacts().size());
	}
	
	@Test
	void testFindContactByName() {
		this.viewModel.getName().set("Alice");
		this.viewModel.getPhoneNumber().set("555-1234");
		this.viewModel.addContact();
		
		this.viewModel.getSearchCriteria().set("Alice");
		String result = this.viewModel.findContact();
		
		assertTrue(result.contains("Alice"));
		assertTrue(result.contains("555-1234"));
	}
	
	@Test
	void testFindContactByPhone() {
		this.viewModel.getName().set("Alice");
		this.viewModel.getPhoneNumber().set("555-1234");
		this.viewModel.addContact();
		
		this.viewModel.getSearchCriteria().set("555-1234");
		String result = this.viewModel.findContact();
		
		assertTrue(result.contains("Alice"));
		assertTrue(result.contains("555-1234"));
	}
	
	@Test
	void testFindContactNotFound() {
		this.viewModel.getSearchCriteria().set("Nonexistent");
		String result = this.viewModel.findContact();
		
		assertEquals("No contact found.", result);
	}
	
	@Test
	void testFindContactWithInvalidCriteria() {
		this.viewModel.getSearchCriteria().set("123");
		
		assertThrows(IllegalArgumentException.class, () -> {
			this.viewModel.findContact();
		});
	}
}