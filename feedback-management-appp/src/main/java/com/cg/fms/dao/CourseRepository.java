package com.cg.fms.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fms.entities.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer>{

}