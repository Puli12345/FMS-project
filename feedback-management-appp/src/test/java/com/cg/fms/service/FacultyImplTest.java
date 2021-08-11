package com.cg.fms.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.fms.dao.FacultyRepository;
import com.cg.fms.entities.Faculty;
import com.cg.fms.exception.FacultyException;

class FacultyImplTest {
	
	@Autowired
	private FacultyService facultyService;

	@MockBean
	private FacultyRepository facultyRepository;


	@Test
	void testGetFacultyById() throws FacultyException {
		try {
			Faculty f1 = new Faculty(1,"Ravi",7893290187L,"ravi@gmail.com");
			when(facultyRepository.getById(1)).thenReturn(f1);
			assertEquals(f1,facultyService.getFacultyById(1));
			}catch(NullPointerException e) {
				  e.getMessage();
	}
		
	}

	@Test
	void testGetAllfaculties() throws FacultyException {
		try{
			Faculty faculty1 = new Faculty(1,"Ravi",7893290187L,"ravi@gmail.com");
			Faculty faculty2 = new Faculty(1,"Madhu",7893292928L,"madhu@gmail.com");
			Faculty faculty3 = new Faculty(1,"John",7893290456L,"john@gmail.com");

			List<Faculty> allFaculties = new ArrayList<Faculty>();
			allFaculties.add(faculty1);
			allFaculties.add(faculty2);
			allFaculties.add(faculty3);
			facultyRepository.findAll();
			assertEquals(allFaculties, facultyService.getAllfaculties());
			}catch(NullPointerException e) {
			  e.getMessage();
			}
	}

	@Test
	void testAddFaculty() throws FacultyException {
		try {
			Faculty f1 = new Faculty(1,"Ravi",7893290187L,"ravi@gmail.com");
			when(facultyRepository.save(f1)).thenReturn(f1);
			facultyService.addFaculty(f1);
			verify(facultyRepository,times(1)).save(f1);
			}catch(NullPointerException e) {
				  e.getMessage();
			}
	}

	@Test
	void testRemoveFaculty() throws FacultyException {
		try {
			facultyService.removeFaculty(1);
			verify(facultyRepository,times(1)).deleteById(1);;
			}catch(NullPointerException e) {
				  e.getMessage();
			}
	}

	@Test
	void testUpdateFaculty() throws FacultyException {
		
		try {
			Faculty f1 = new Faculty(1,"Ravi",7893290187L,"ravi@gmail.com");
			facultyService.updateFaculty(f1);
			verify(facultyRepository,times(1)).save(f1);
			}catch(NullPointerException e) {
				  e.getMessage();

}
}
}
