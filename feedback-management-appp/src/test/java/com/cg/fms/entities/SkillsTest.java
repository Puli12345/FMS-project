package com.cg.fms.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SkillsTest {
	
private Skills skills;
	
	
	@BeforeEach
	void setUp() throws Exception {
		skills= new Skills(1,"Python","Python Full Stack");		
	}
	
	@AfterEach
	void reset() throws Exception {
		skills= null;		
	}

	@Test
	void testGetSkillId() {
		assertEquals(1,skills.getSkillId());
	}

	@Test
	void testGetSkillName() {
		assertEquals("Python",skills.getSkillName());
	}

	@Test
	void testGetSkillDescription() {
		assertEquals("Python Full Stack",skills.getSkillDescription());
	}

}
