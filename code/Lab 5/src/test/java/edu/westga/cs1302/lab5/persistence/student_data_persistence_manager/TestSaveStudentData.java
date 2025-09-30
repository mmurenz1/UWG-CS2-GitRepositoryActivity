package edu.westga.cs1302.lab5.persistence.student_data_persistence_manager;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.lab5.model.Student;
import edu.westga.cs1302.lab5.persistence.StudentDataPersistenceManager;

class TestSaveStudentData {

	@Test
	void testSaveNullStudents() {
	    assertThrows(IllegalArgumentException.class, () -> {
	        StudentDataPersistenceManager.saveStudentData(null);
	    });
	}

	@Test
	void testSaveEmptyStudents() throws Exception {
	    Student[] students = new Student[0];
	    StudentDataPersistenceManager.saveStudentData(students);
	    
	    File file = new File("data.txt");
	    assertTrue(file.exists(), "File should be created");
	    
	    try (Scanner reader = new Scanner(file)) {
	        assertFalse(reader.hasNextLine(), "File should be empty for no students");
	    }
	}

	@Test
	void testSaveOneStudent() throws Exception {
	    Student[] students = new Student[1];
	    students[0] = new Student("alice", 95);
	    
	    StudentDataPersistenceManager.saveStudentData(students);
	    
	    File file = new File("data.txt");
	    try (Scanner reader = new Scanner(file)) {
	        assertTrue(reader.hasNextLine(), "File should have data");
	        String line = reader.nextLine();
	        assertEquals("alice,95", line, "Format should be name,grade");
	        assertFalse(reader.hasNextLine(), "Should only have one line");
	    }
	}

	@Test
	void testSaveMultipleStudents() throws Exception {
	    Student[] students = new Student[3];
	    students[0] = new Student("bob", 80);
	    students[1] = new Student("carol", 90);
	    students[2] = new Student("dave", 85);
	    
	    StudentDataPersistenceManager.saveStudentData(students);
	    
	    File file = new File("data.txt");
	    try (Scanner reader = new Scanner(file)) {
	        assertEquals("bob,80", reader.nextLine());
	        assertEquals("carol,90", reader.nextLine());
	        assertEquals("dave,85", reader.nextLine());
	        assertFalse(reader.hasNextLine(), "Should only have three lines");
	    }
	}

}
