package com.cg.fms.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.fms.dao.CourseRepository;
import com.cg.fms.entities.Course;
import com.cg.fms.exception.CourseException;

class CourseServiceImplTest {


	@Autowired
	private CourseService courseService;

	@MockBean
	private CourseRepository courseRepository;


	@Test
	void ListTest() throws CourseException {
		try{
			Course course1 = new Course(1,"Java","Learn Java in 60 days",60);
			Course course2 = new Course(2,"Python","Learn Python in 30 days",30);
			Course course3 = new Course(3,"C","Learn C in 60 days",60);

			List<Course> allCourses = new ArrayList<Course>();
			allCourses.add(course1);
			allCourses.add(course2);
			allCourses.add(course3);
			courseRepository.findAll();
			assertEquals(allCourses, courseService.getAllCourses());
		}catch(Exception e) {
			e.getMessage();
		}

	}

	@Test
	void addCourseTest() throws CourseException {
		try {
			Course c1 = new Course(1,"Java","Learn Java in 60 days",60);
			when(courseRepository.save(c1)).thenReturn(c1);
			courseService.addCourse(c1);
			verify(courseRepository,times(1)).save(c1);
		}catch(Exception e) {
			e.getMessage();
		}
	}

	@Test
	void updateFacultyTest() throws  CourseException {
		try {
			Course c1 = new Course(1,"Java","Learn Java in 60 days",60);
			courseService.updateCourse(c1);
			verify(courseRepository,times(1)).save(c1);
		}catch(Exception e) {
			e.getMessage();
		}
	}

	@Test
	void deleteCourseTest() throws CourseException{
		try {
			courseService.deleteCourse(1);
			verify(courseRepository,times(1)).deleteById(1);;
		}catch(Exception e) {
			e.getMessage();
		}
	}

	@Test
	void getCourseById() throws CourseException {
		try {
			Course c1 = new Course(1,"Java","Learn Java in 60 days",60);
			when(courseRepository.getById(1)).thenReturn(c1);
			assertEquals(c1,courseService.getCourseById(1));
		}catch(Exception e) {
			e.getMessage();
		}
	}
}



