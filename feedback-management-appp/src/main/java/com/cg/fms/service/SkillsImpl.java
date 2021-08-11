package com.cg.fms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.cg.fms.dao.SkillsRepository;
import com.cg.fms.entities.Skills;
import com.cg.fms.exception.SkillsException;
@Service
@Transactional
public class SkillsImpl implements SkillsService {
    
	@Autowired
	private SkillsRepository repository;
	@Override
	public List<Skills> getAllskills() throws SkillsException{
		try {
			List<Skills> skillsList=repository.findAll();
		return skillsList;
		}catch(DataAccessException e) {
			throw new SkillsException(e.getMessage(),e);
		}
	}

	
	@Override
	public Skills addSkills(Skills skills) throws SkillsException {
		try {
		skills.setSkillId(null);
		Skills savedSkills= repository.save(skills);
		return savedSkills;
	}catch(DataAccessException e) {
		throw new SkillsException(e.getMessage(),e);
	}
}

	@Override
	public void removeSkills(Integer skillsId) throws SkillsException{
		try {
		
		repository.deleteById(skillsId);
		//System.out.println(skillsId+"is deleted");
		}catch(DataAccessException e) {
			throw new SkillsException(e.getMessage(),e);
		}
		
	}


	@Override
	public Skills updateSkills(Skills skills) throws SkillsException{
		try {
		Skills savedSkills= repository.save(skills);
		return savedSkills;
	}catch(DataAccessException e) {
		throw new SkillsException(e.getMessage(),e);
	}
}


	@Override
	public Skills getSkillsById(Integer skillsId) throws SkillsException {
		try{
			Optional<Skills> optional= repository.findById(skillsId);
			if(optional.isPresent()) {
				return optional.get();
			}else {
				throw new SkillsException("Invalid skillsId");
			}
		}catch(DataAccessException e) {
			throw new SkillsException(e.getMessage(),e);
		}
	}

}