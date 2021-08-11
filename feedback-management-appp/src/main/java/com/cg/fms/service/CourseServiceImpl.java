package com.cg.fms.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.fms.dao.CourseRepository;
import com.cg.fms.entities.Course;
import com.cg.fms.exception.CourseException;



@Service
@Transactional
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseRepository repository;
	@Override
	public Course getCourseById(Integer courseId) throws CourseException{
		try{
			Optional<Course> optional= repository.findById(courseId);

			if(optional.isPresent()) {
				return optional.get();
			}else {
				throw new CourseException("Invalid courseId");
			}
		}catch(DataAccessException e) {
			throw new CourseException(e.getMessage(),e);
		}

	}



	@Override
	public List<Course> getAllCourses() throws CourseException{
		try {
			List<Course> courseList=repository.findAll();
			return courseList;
		}catch(DataAccessException e) {
			throw new CourseException(e.getMessage(),e);
		}
	}



	@Override
	public Course addCourse(Course course) throws CourseException {
		try{
			course.setCourseId(null);
			Course savedCourse=repository.save(course);
			return savedCourse;
		}catch(DataAccessException e) {
			throw new CourseException(e.getMessage(),e);
		}
	}



	@Override
	public Course updateCourse(Course course) throws CourseException {
		try{
			Course savedCourse=repository.save(course);
			return savedCourse;
		}catch(DataAccessException e) {
			throw new CourseException(e.getMessage(),e);
		}
	}


	@Override
	public void deleteCourse(Integer courseId) throws CourseException {
		try{
			repository.deleteById(courseId);
		}catch(DataAccessException e) {
			throw new CourseException(e.getMessage(),e);
		}

	}

}