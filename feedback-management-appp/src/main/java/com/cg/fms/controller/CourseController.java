package com.cg.fms.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cg.fms.entities.Course;
import com.cg.fms.exception.CourseException;
import com.cg.fms.service.CourseService;

import io.swagger.annotations.Api;

@Api
@RestController
@Transactional
@RequestMapping("/v1")
@CrossOrigin("*")
public class CourseController {

	@GetMapping("/testcourse")
	public Course getCourse() {
		return  null;		
	}

	@Autowired
	private CourseService courseService;


	@PostMapping("/addcourse")
	public ResponseEntity<Course> addCourse(@Valid @RequestBody Course course) {
		try {
			Course c= courseService.addCourse(course);
			return new ResponseEntity<>(c,HttpStatus.OK);
		}catch(CourseException e) {
			throw new ResponseStatusException(
					HttpStatus.INTERNAL_SERVER_ERROR, "Unable to add course", e);
		}
	}


	@DeleteMapping("/deletecourse/{id}")
	public String deleteCourse(@PathVariable(value = "id") Integer courseId) {
		try{
			courseService.deleteCourse(courseId);
			return courseId+ "deleted";
		}catch(CourseException e) {
			throw new ResponseStatusException(
					HttpStatus.INTERNAL_SERVER_ERROR, "Unable to delete course", e);
		}
	}



	@GetMapping("/coursebyid/{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable(value = "id") Integer courseId) {
		try{
			Course course= courseService.getCourseById(courseId);
			return new ResponseEntity<>(course,HttpStatus.OK);
		}catch(CourseException e) {
			throw new ResponseStatusException(
					HttpStatus.INTERNAL_SERVER_ERROR, "Unable to get course", e);
		}
	}


	@GetMapping("/courselist")
	public ResponseEntity<List<Course>> getCourseList() {
		try{
			return new ResponseEntity<>(courseService.getAllCourses(),HttpStatus.OK);
		}catch(CourseException e) {
			throw new ResponseStatusException(
					HttpStatus.INTERNAL_SERVER_ERROR, "Unable to get courselist", e);
		}
	}


	@PutMapping("/updatecourse")
	public ResponseEntity<Course> updateParticipant(@Valid @RequestBody Course course) {
		try{
			Course c = courseService.updateCourse(course);
			return new ResponseEntity<>(c,HttpStatus.OK);
		}catch(CourseException e) {
			throw new ResponseStatusException(
					HttpStatus.INTERNAL_SERVER_ERROR, "Unable to update course", e);
		}

	}
}