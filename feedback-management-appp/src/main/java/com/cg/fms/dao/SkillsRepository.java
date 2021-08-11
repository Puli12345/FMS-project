package com.cg.fms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fms.entities.Skills;

@Repository
public interface SkillsRepository extends JpaRepository<Skills, Integer> {

}