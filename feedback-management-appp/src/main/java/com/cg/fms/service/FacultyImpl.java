package com.cg.fms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.cg.fms.dao.FacultyRepository;
import com.cg.fms.entities.Faculty;
import com.cg.fms.exception.FacultyException;
@Service
@Transactional
public class FacultyImpl implements FacultyService {

	@Autowired
	private FacultyRepository repository;

	@Override
	public Faculty getFacultyById(Integer facultyId) throws FacultyException {
		try{
			Optional<Faculty> optional= repository.findById(facultyId);
			if(optional.isPresent()) {
				return optional.get();
			}else {
				throw new FacultyException("Invalid facultyId");
			}
		}catch(DataAccessException e) {
			throw new FacultyException(e.getMessage(),e);
		}
	}


	@Override
	public List<Faculty> getAllfaculties() throws FacultyException {
		try{
			List<Faculty> facultyList=repository.findAll();
			return facultyList;
		}catch(DataAccessException e) {
			throw new FacultyException(e.getMessage(),e);
		}
	}


	@Override
	public Faculty addFaculty(Faculty faculty) throws FacultyException {
		try{
			faculty.setFacultyId(null);
			Faculty savedFaculty= repository.save(faculty);
			return savedFaculty;
		}catch(DataAccessException e) {
			throw new FacultyException(e.getMessage(),e);
		}
	}


	@Override
	public void removeFaculty(Integer facultyId) throws FacultyException {
		try{
			repository.deleteById(facultyId);
			System.out.println(facultyId+"is deleted");
		}catch(DataAccessException e) {
			throw new FacultyException(e.getMessage(),e);
		}
	}

	@Override
	public Faculty updateFaculty(Faculty faculty)throws FacultyException {
		try{
			Faculty savedFaculty = repository.save(faculty);
			return savedFaculty ;
		}catch(DataAccessException e) {
			throw new FacultyException(e.getMessage(),e);
		}
	}


}
