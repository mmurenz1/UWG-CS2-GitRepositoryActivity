package edu.westga.cs1302.e3.model;

/** Stores information for a Student
 * 
 * @author CS 1302
 * @version Fall 2024
 */
public class Student {
	
	private String name;
	private int gpa;
	
	/** Create a new student
	 * 
	 * @precondition name != null &&
	 * 				 gpa is 1,2, 3, or 4
	 * @postcondition getName() == name &&
	 * 				  getGPA() == gpa
	 * 
	 * @param name name of the student
	 * @param gpa gpa of the student
	 */
	public Student(String name, int gpa) {
		if (name == null) {
			throw new IllegalArgumentException("Must provide a name");
		}
		if (gpa != 1 && gpa != 2 && gpa != 3 && gpa != 4) {
			throw new IllegalArgumentException("GPA must be 1, 2, 3, or 4");
		}
		this.name = name;
		this.gpa = gpa;
	}
	
	/** Returns the name of the student
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the name of the student
	 */
	public String getName() {
		return this.name;
	}

	/** Returns the gpa of the student
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return the gpa of the student
	 */
	public int getGPA() {
		return this.gpa;
	}
	
	@Override
	public String toString() {
		return this.name;
	}

}
