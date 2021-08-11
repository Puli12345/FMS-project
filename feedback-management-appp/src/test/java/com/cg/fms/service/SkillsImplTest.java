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

import com.cg.fms.dao.SkillsRepository;
import com.cg.fms.entities.Skills;
import com.cg.fms.exception.SkillsException;

class SkillsImplTest {

	@Autowired
	private SkillsService skillsService;

	@MockBean
	private SkillsRepository skillsRepository;


	@Test
	void ListTest() throws SkillsException {
		try{
			Skills skills1 = new Skills(1,"Java","Intermediate");
			Skills skills2 = new Skills(2,"Python","Intermediate");
			Skills skills3 = new Skills(3,"C","Intermediate");

			List<Skills> allSkills = new ArrayList<Skills>();
			allSkills.add(skills1);
			allSkills.add(skills2);
			allSkills.add(skills3);
			skillsRepository.findAll();
			assertEquals(allSkills, skillsService.getAllskills());
		}catch(Exception e) {
			e.getMessage();
		}
	}

	@Test
	void addSkillsTest() throws SkillsException {
		try {
			Skills s1 = new Skills(1,"Java","Intermediate");
			when(skillsRepository.save(s1)).thenReturn(s1);
			skillsService.addSkills(s1);
			verify(skillsRepository,times(1)).save(s1);
		}catch(Exception e) {
			e.getMessage();
		}
	}

	@Test
	void updateSkillsTest() throws SkillsException {
		try {
			Skills s1 = new Skills(1,"Java","Intermediate");
			skillsService.updateSkills(s1);
			verify(skillsRepository,times(1)).save(s1);
		}catch(Exception e) {
			e.getMessage();
		}
	}

	@Test
	void deleteSkillsTest() throws SkillsException{
		try {
			skillsService.removeSkills(1);
			verify(skillsRepository,times(1)).deleteById(1);;
		}catch(Exception e) {
			e.getMessage();
		}
	}

	@Test
	void getSkillsById() throws SkillsException {
		try {
			Skills s1 = new Skills(1,"Java","Intermediate");
			when(skillsRepository.getById(1)).thenReturn(s1);
			assertEquals(s1,skillsService.getSkillsById(1));
		}catch(Exception e) {
			e.getMessage();
		}
	}
}
