package com.cg.fms.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FacultyTest {
private Faculty faculty;
	
	
	@BeforeEach
	void setUp() throws Exception {
		faculty= new Faculty(1,"Ramesh",9666375661L,"ramesh@gmail.com");		
	}
	
	@AfterEach
	void reset() throws Exception {
		faculty= null;		
	}

	@Test
	void testGetFacultyId() {
		assertEquals(1,faculty.getFacultyId());
		}

	@Test
	void testGetFacultyName() {
		assertEquals("Ramesh",faculty.getFacultyName());
	}

	@Test
	void testGetMobile() {
		assertEquals(9666375661L,faculty.getMobile());
	}

	@Test
	void testGetEmail() {
		assertEquals("ramesh@gmail.com",faculty.getEmail());
	}

}
