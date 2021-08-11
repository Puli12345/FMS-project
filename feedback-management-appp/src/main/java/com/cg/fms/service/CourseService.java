package com.cg.fms.service;

 
import java.util.List;

import com.cg.fms.entities.Course;
import com.cg.fms.exception.CourseException;

 
public interface CourseService   {
    public abstract Course getCourseById(Integer courseId) throws CourseException ;
    public abstract List<Course> getAllCourses() throws CourseException;
    public abstract Course addCourse(Course course) throws CourseException;
    public abstract Course updateCourse(Course course) throws CourseException;
    public void deleteCourse(Integer courseId) throws CourseException;
}