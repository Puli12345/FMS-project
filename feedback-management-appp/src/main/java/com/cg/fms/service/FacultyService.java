package com.cg.fms.service;

import java.util.List;


import com.cg.fms.entities.Faculty;
import com.cg.fms.exception.FacultyException;

public interface FacultyService {
	public abstract List<Faculty> getAllfaculties() throws FacultyException;
	public abstract Faculty addFaculty(Faculty faculty) throws FacultyException;
	public abstract void removeFaculty(Integer facultyId) throws FacultyException;
	public abstract Faculty updateFaculty(Faculty faculty) throws FacultyException;
	public abstract Faculty getFacultyById(Integer facultyId) throws FacultyException; 
	
}
