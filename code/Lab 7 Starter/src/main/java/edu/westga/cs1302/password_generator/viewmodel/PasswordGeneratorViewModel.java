package edu.westga.cs1302.password_generator.viewmodel;

import edu.westga.cs1302.password_generator.model.PasswordGenerator;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * ViewModel for the Password Generator application.
 * Manages the state and logic for password generation.
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class PasswordGeneratorViewModel {
	
	private StringProperty minimumLength;
	private StringProperty output;
	private BooleanProperty mustIncludeDigits;
	private BooleanProperty mustIncludeLowerCaseLetters;
	private BooleanProperty mustIncludeUpperCaseLetters;
	private StringProperty errorMessage;
	
	private PasswordGenerator generator;
	
	/**
	 * Creates a new PasswordGeneratorViewModel with a random seed.
	 */
	public PasswordGeneratorViewModel() {
		this.minimumLength = new SimpleStringProperty("1");
		this.output = new SimpleStringProperty("");
		this.mustIncludeDigits = new SimpleBooleanProperty(false);
		this.mustIncludeLowerCaseLetters = new SimpleBooleanProperty(false);
		this.mustIncludeUpperCaseLetters = new SimpleBooleanProperty(false);
		this.errorMessage = new SimpleStringProperty("");
		
		long seed = System.currentTimeMillis();
		this.generator = new PasswordGenerator(seed);
	}
	
	/**
	 * Gets the minimum length property.
	 * 
	 * @return the minimum length property
	 */
	public StringProperty minimumLengthProperty() {
		return this.minimumLength;
	}
	
	/**
	 * Gets the output property.
	 * 
	 * @return the output property
	 */
	public StringProperty outputProperty() {
		return this.output;
	}
	
	/**
	 * Gets the must include digits property.
	 * 
	 * @return the must include digits property
	 */
	public BooleanProperty mustIncludeDigitsProperty() {
		return this.mustIncludeDigits;
	}
	
	/**
	 * Gets the must include lower case letters property.
	 * 
	 * @return the must include lower case letters property
	 */
	public BooleanProperty mustIncludeLowerCaseLettersProperty() {
		return this.mustIncludeLowerCaseLetters;
	}
	
	/**
	 * Gets the must include upper case letters property.
	 * 
	 * @return the must include upper case letters property
	 */
	public BooleanProperty mustIncludeUpperCaseLettersProperty() {
		return this.mustIncludeUpperCaseLetters;
	}
	
	/**
	 * Gets the error message property.
	 * 
	 * @return the error message property
	 */
	public StringProperty errorMessageProperty() {
		return this.errorMessage;
	}
	
	/**
	 * Generates a password based on the current settings.
	 * Updates the output property with the generated password,
	 * or the error message property if there's an error.
	 */
	public void generatePassword() {
		this.errorMessage.set("");
		this.output.set("");
		
		try {
			int length = Integer.parseInt(this.minimumLength.get());
			this.generator.setMinimumLength(length);
		} catch (NumberFormatException numberError) {
			this.errorMessage.set("Invalid Minimum Length: must be a positive integer, but was " + this.minimumLength.get());
			return;
		} catch (IllegalArgumentException invalidLengthError) {
			this.errorMessage.set("Invalid Minimum Length: " + invalidLengthError.getMessage());
			return;
		}
		
		this.generator.setMustHaveAtLeastOneDigit(this.mustIncludeDigits.get());
		this.generator.setMustHaveAtLeastOneLowerCaseLetter(this.mustIncludeLowerCaseLetters.get());
		this.generator.setMustHaveAtLeastOneUpperCaseLetter(this.mustIncludeUpperCaseLetters.get());
		
		String password = this.generator.generatePassword();
		this.output.set(password);
	}
}
