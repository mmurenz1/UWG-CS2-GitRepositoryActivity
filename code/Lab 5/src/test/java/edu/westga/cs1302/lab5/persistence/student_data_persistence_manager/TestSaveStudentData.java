package edu.westga.cs1302.lab5.persistence.student_data_persistence_manager;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.Scanner;

import org.junit.jupiter.api.Test;


import edu.westga.cs1302.lab5.model.student.*;
import edu.westga.cs1302.lab5.persistence.StudentDataPersistenceManager.*;

class TestSaveStudentData {

	@Test
	void testNoStudents() {
		StudentsDataPersistenceManager.saveStudentData(new Stuudent[], "test-data.txt");
		
		File inputFile = new File("test-data.txt");
		try(Scanner reader = new Scanner(inputFile)) {
			assertFalse(reader.hasNextLine(), "checking if file is empty (should have no lines");
		}
	}

}
