package edu.westga.cs1302.password_generator.viewmodel.viewmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_generator.viewmodel.ViewModel;

class TestGeneratePassword {

	@Test
	void testMinimumLengthNotANumber() {
		ViewModel vm = new ViewModel();
		vm.getMinimumLength().setValue("apple");
		
		vm.generatePassword();
		
		assertEquals("", vm.getPassword().getValue(), "checking the password property");
		assertEquals("Invalid Minimum Length: must be a positive integer, but was apple", vm.getErrorText().getValue(), "checking the error text property");
	}
	
	@Test
	void testMinimumLengthNotAValidNumber() {
		ViewModel vm = new ViewModel();
		vm.getMinimumLength().setValue("-2");
		
		vm.generatePassword();
		
		assertEquals("", vm.getPassword().getValue(), "checking the password property");
		assertEquals("Invalid Minimum Length: minimum length must be at least 1", vm.getErrorText().getValue(), "checking the error text property");
	}
	
	@Test
	void testValidInputProvided() {
		ViewModel vm = new ViewModel();
		vm.getMinimumLength().setValue("2");
		
		vm.generatePassword();
		
		assertTrue(vm.getPassword().getValue().length() >= 2, "checking the password property has an appropriate number of characters");
		assertEquals("", vm.getErrorText().getValue(), "checking the error text property");
	}
	
	@Test
	void testPasswordAddedToList() {
	    ViewModel vm = new ViewModel();
	    vm.getMinimumLength().setValue("5");
	    
	    vm.generatePassword();
	    
	    assertEquals(1, vm.getPasswordList().size(), "checking one password is in the list");
	    assertFalse(vm.getPasswordList().get(0).isEmpty(), "checking the password is not empty");
	}

	@Test
	void testMultiplePasswordsAddedToList() {
	    ViewModel vm = new ViewModel();
	    vm.getMinimumLength().setValue("3");
	    
	    vm.generatePassword();
	    vm.generatePassword();
	    vm.generatePassword();
	    
	    assertEquals(3, vm.getPasswordList().size(), "checking three passwords are in the list");
	}
	
	@Test
	void testGetPasswordListNotNull() {
	    ViewModel vm = new ViewModel();
	    
	    assertNotNull(vm.getPasswordList(), "checking password list is not null");
	    assertEquals(0, vm.getPasswordList().size(), "checking password list starts empty");
	}
	
	@Test
	void testPasswordNotAddedToListWhenError() {
	    ViewModel vm = new ViewModel();
	    vm.getMinimumLength().setValue("abc");
	    
	    int initialSize = vm.getPasswordList().size();
	    vm.generatePassword();
	    
	    assertEquals(initialSize, vm.getPasswordList().size(), "checking no password added when error occurs");
	}

}
