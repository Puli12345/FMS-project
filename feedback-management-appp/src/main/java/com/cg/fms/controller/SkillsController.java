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

import com.cg.fms.entities.Skills;
import com.cg.fms.exception.SkillsException;
import com.cg.fms.service.SkillsService;

import io.swagger.annotations.Api;

@Api
@RestController
@Transactional
@RequestMapping("/v1")
@CrossOrigin("*")

public class SkillsController {

	@Autowired
	private SkillsService skillsService;

	@GetMapping("/testskills")
	public Skills getSkills() {
		return new Skills(1,"java",null,null);		
	}


	
	@PostMapping("/addskills")
	public ResponseEntity<Skills> addSkills(@Valid @RequestBody Skills skills) {
		try {
			Skills s= skillsService.addSkills(skills);
			return new ResponseEntity<>(s,HttpStatus.OK);
		}catch(SkillsException e) {
			throw new ResponseStatusException(
					HttpStatus.INTERNAL_SERVER_ERROR, "Unable to add skills", e);

		}
	}


	
	@GetMapping("/skillbyid/{id}")
	public ResponseEntity<Skills> getSkillsById(@PathVariable(value = "id") Integer skillsId) {
		try{
			Skills skills= skillsService.getSkillsById(skillsId);
			return new ResponseEntity<>(skills,HttpStatus.OK);
		}catch(SkillsException e) {
			throw new ResponseStatusException(
					HttpStatus.INTERNAL_SERVER_ERROR, "Unable to get skills", e);
		}
	}


	
	@GetMapping("/skillslist")
	public ResponseEntity<List<Skills>> getskillsList(){
		try {
			//List<Skills> skillsList=skillsService.getAllskills();
			return new ResponseEntity<>(skillsService.getAllskills(),HttpStatus.OK);	
		}catch(SkillsException e) {
			throw new ResponseStatusException(
					HttpStatus.INTERNAL_SERVER_ERROR, "Unable to get skillslist", e);
		}
	}


	@DeleteMapping("/deleteskills/{id}")
	public String deleteSkills(@PathVariable(value = "id") Integer skillsId) {
		try {
			skillsService.removeSkills(skillsId);
			return skillsId+ "deleted";
		}catch(SkillsException e) {
			throw new ResponseStatusException(
					HttpStatus.INTERNAL_SERVER_ERROR, "Unable to delete skills", e);

		}
	}


	
	@PutMapping("/updateskills")
	public ResponseEntity<Skills> updateParticipant(@Valid @RequestBody Skills skills) {
		try {
			Skills s = skillsService.updateSkills(skills);
			return new ResponseEntity<>(s,HttpStatus.OK);
		}catch(SkillsException e) {
			throw new ResponseStatusException(
					HttpStatus.INTERNAL_SERVER_ERROR, "Unable to update skills", e);
		}
	}
}