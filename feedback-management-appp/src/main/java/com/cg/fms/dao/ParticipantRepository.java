package com.cg.fms.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cg.fms.entities.Participant;
@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Integer> {
	
}
