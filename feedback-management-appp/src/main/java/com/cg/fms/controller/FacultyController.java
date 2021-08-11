package com.cg.fms.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.cg.fms.entities.Faculty;
import com.cg.fms.exception.FacultyException;
import com.cg.fms.service.FacultyService;

import io.swagger.annotations.Api;

@Api
@RestController
@Transactional
@RequestMapping("/v1")
@CrossOrigin("*")
public class FacultyController {

	@Autowired
	private FacultyService facultyService;

	@GetMapping("/testfaculty")
	public Faculty getFaculty() {
		return new Faculty(1,"Srinivas",7660889908L, null,"srinavas@gmail.com",null, null);		
	}

	
	@GetMapping("/facultybyid/{id}")
	public ResponseEntity<Faculty> getFacultyById(@PathVariable(value = "id") Integer facultyId){
		try {
			Faculty faculty= facultyService.getFacultyById(facultyId);
			return new ResponseEntity<>(faculty,HttpStatus.OK);
		}catch(FacultyException e) {
			throw new ResponseStatusException(
					HttpStatus.INTERNAL_SERVER_ERROR, "Unable to get faculty", e);
		}
	}
	
	
	
	@GetMapping("/facultylist")
	public ResponseEntity<List<Faculty>> getFacultyList(){
		try {
			List<Faculty> facultyList=facultyService.getAllfaculties();
			return new ResponseEntity<>(facultyList,HttpStatus.OK);	
		}catch(FacultyException e) {
			throw new ResponseStatusException(
					HttpStatus.INTERNAL_SERVER_ERROR, "Unable to get facultylist", e);
		}
	}

	
	@PostMapping("/addfaculty")
	public ResponseEntity<Faculty> addFaculty(@Valid @RequestBody Faculty faculty) {
		try {
			Faculty f= facultyService.addFaculty(faculty);
			return new ResponseEntity<>(f,HttpStatus.OK);
		}catch(FacultyException e) {
			throw new ResponseStatusException(
					HttpStatus.INTERNAL_SERVER_ERROR, "Unable to add faculty", e);
		}
	}

	
	@DeleteMapping("/deletefaculty/{id}")
	public String deleteFaculty(@PathVariable(value = "id") Integer facultyId) {
		try{
			facultyService.removeFaculty(facultyId);
			return facultyId+ "deleted";
		}catch(FacultyException e) {
			throw new ResponseStatusException(
					HttpStatus.INTERNAL_SERVER_ERROR, "Unable to delete faculty", e);
		}
	}

	
	@PutMapping("/updatefaculty")
	public ResponseEntity<Faculty> updateFaculty(@Valid @RequestBody Faculty faculty) {
		try{
			Faculty f= facultyService.updateFaculty(faculty);
			return new ResponseEntity<>(f,HttpStatus.OK);
		}catch(FacultyException e) {
			throw new ResponseStatusException(
					HttpStatus.INTERNAL_SERVER_ERROR, "Unable to update faculty", e);
		}
	}


}