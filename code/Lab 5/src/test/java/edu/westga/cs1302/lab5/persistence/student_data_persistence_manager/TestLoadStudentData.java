package edu.westga.cs1302.lab5.persistence.student_data_persistence_manager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

import edu.westga.cs1302.lab5.model.Student;
import edu.westga.cs1302.lab5.persistence.StudentDataPersistenceManager;

class TestLoadStudentData {

	@Test
	void testLoadFileDoesNotExist() {
	    File file = new File("data.txt");
	    if (file.exists()) {
	        file.delete();
	    }
	    
	    assertThrows(FileNotFoundException.class, () -> {
	        StudentDataPersistenceManager.loadStudentData();
	    });
	}

	@Test
	void testLoadEmptyFile() throws Exception {
	    File file = new File("data.txt");
	    try (FileWriter writer = new FileWriter(file)) {
	    }
	    
	    Student[] students = StudentDataPersistenceManager.loadStudentData();
	    assertEquals(0, students.length, "Should return empty array for empty file");
	}

	@Test
	void testLoadOneStudent() throws Exception {
	    File file = new File("data.txt");
	    try (FileWriter writer = new FileWriter(file)) {
	        writer.write("alice,95\n");
	    }
	    
	    Student[] students = StudentDataPersistenceManager.loadStudentData();
	    assertEquals(1, students.length, "Should load one student");
	    assertEquals("alice", students[0].getName());
	    assertEquals(95, students[0].getGrade());
	}

	@Test
	void testLoadMultipleStudents() throws Exception {
	    File file = new File("data.txt");
	    try (FileWriter writer = new FileWriter(file)) {
	        writer.write("bob,80\n");
	        writer.write("carol,90\n");
	        writer.write("dave,85\n");
	    }
	    
	    Student[] students = StudentDataPersistenceManager.loadStudentData();
	    assertEquals(3, students.length, "Should load three students");
	    assertEquals("bob", students[0].getName());
	    assertEquals(80, students[0].getGrade());
	    assertEquals("carol", students[1].getName());
	    assertEquals(90, students[1].getGrade());
	    assertEquals("dave", students[2].getName());
	    assertEquals(85, students[2].getGrade());
	}

	@Test
	void testLoadInvalidFormat() throws Exception {
	    File file = new File("data.txt");
	    try (FileWriter writer = new FileWriter(file)) {
	        writer.write("invalidline\n");
	    }
	    
	    assertThrows(IOException.class, () -> {
	        StudentDataPersistenceManager.loadStudentData();
	    });
	}

	@Test
	void testLoadInvalidGrade() throws Exception {
	    File file = new File("data.txt");
	    try (FileWriter writer = new FileWriter(file)) {
	        writer.write("alice,notanumber\n");
	    }
	    
	    assertThrows(IOException.class, () -> {
	        StudentDataPersistenceManager.loadStudentData();
	    });
	}

}
