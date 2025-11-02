package edu.westga.cs1302.password_generator.tests.viewmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.password_generator.viewmodel.PasswordGeneratorViewModel;

class TestPasswordGeneratorViewModel {

	@Test
	void testConstructor() {
		PasswordGeneratorViewModel viewModel = new PasswordGeneratorViewModel();
		
		assertEquals("1", viewModel.minimumLengthProperty().get());
		assertEquals("", viewModel.outputProperty().get());
		assertEquals(false, viewModel.mustIncludeDigitsProperty().get());
		assertEquals(false, viewModel.mustIncludeLowerCaseLettersProperty().get());
		assertEquals(false, viewModel.mustIncludeUpperCaseLettersProperty().get());
		assertEquals("", viewModel.errorMessageProperty().get());
	}
	
	@Test
	void testGeneratePasswordWithMinimumRequirements() {
		PasswordGeneratorViewModel viewModel = new PasswordGeneratorViewModel();
		
		viewModel.minimumLengthProperty().set("5");
		viewModel.generatePassword();
		
		String password = viewModel.outputProperty().get();
		assertTrue(password.length() >= 5);
		assertEquals("", viewModel.errorMessageProperty().get());
	}
	
	@Test
	void testGeneratePasswordWithInvalidMinimumLength() {
		PasswordGeneratorViewModel viewModel = new PasswordGeneratorViewModel();
		
		viewModel.minimumLengthProperty().set("abc");
		viewModel.generatePassword();
		
		assertEquals("", viewModel.outputProperty().get());
		assertTrue(viewModel.errorMessageProperty().get().contains("Invalid Minimum Length"));
	}
	
	@Test
	void testGeneratePasswordWithNegativeMinimumLength() {
		PasswordGeneratorViewModel viewModel = new PasswordGeneratorViewModel();
		
		viewModel.minimumLengthProperty().set("-5");
		viewModel.generatePassword();
		
		assertEquals("", viewModel.outputProperty().get());
		assertTrue(viewModel.errorMessageProperty().get().contains("Invalid Minimum Length"));
	}
	
	@Test
	void testGeneratePasswordWithDigitsRequired() {
		PasswordGeneratorViewModel viewModel = new PasswordGeneratorViewModel();
		
		viewModel.minimumLengthProperty().set("10");
		viewModel.mustIncludeDigitsProperty().set(true);
		viewModel.generatePassword();
		
		String password = viewModel.outputProperty().get();
		assertTrue(password.matches(".*\\d.*"));
	}
	
	@Test
	void testGeneratePasswordWithUpperCaseRequired() {
		PasswordGeneratorViewModel viewModel = new PasswordGeneratorViewModel();
		
		viewModel.minimumLengthProperty().set("10");
		viewModel.mustIncludeUpperCaseLettersProperty().set(true);
		viewModel.generatePassword();
		
		String password = viewModel.outputProperty().get();
		assertTrue(password.matches(".*[A-Z].*"));
	}
	
	@Test
	void testGeneratePasswordWithLowerCaseRequired() {
		PasswordGeneratorViewModel viewModel = new PasswordGeneratorViewModel();
		
		viewModel.minimumLengthProperty().set("10");
		viewModel.mustIncludeLowerCaseLettersProperty().set(true);
		viewModel.generatePassword();
		
		String password = viewModel.outputProperty().get();
		assertTrue(password.matches(".*[a-z].*"));
	}
}