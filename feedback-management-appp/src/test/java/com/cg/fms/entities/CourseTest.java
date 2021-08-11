package com.cg.fms.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class CourseTest {
	
	private Course course;
	
	
	@BeforeEach
	void setUp() throws Exception {
		course= new Course(1,"java","java full stack with react",60);		
	}
	
	@AfterEach
	void reset() throws Exception {
		course= null;		
	}


	@Test
	void testGetCourseId() {
		assertEquals(1,course.getCourseId());
	}

	@Test
	void testGetCourseName() {
		assertEquals("java",course.getCourseName());
	}

	@Test
	void testGetCourseDescription() {
		assertEquals("java full stack with react",course.getCourseDescription());
	}

	@Test
	void testGetDuration() {
		assertEquals(60,course.getDuration());;
	}

}
