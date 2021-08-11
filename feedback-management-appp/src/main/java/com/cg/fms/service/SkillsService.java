package com.cg.fms.service;

import java.util.List;

import com.cg.fms.entities.Skills;
import com.cg.fms.exception.SkillsException;

public interface SkillsService {
	public abstract Skills getSkillsById(Integer skillsId ) throws SkillsException;
	public abstract List<Skills> getAllskills() throws SkillsException;
	public abstract Skills addSkills(Skills skills) throws SkillsException;
	public abstract void removeSkills(Integer skillsId) throws SkillsException;
	public abstract Skills updateSkills(Skills skills) throws SkillsException; 
	

}