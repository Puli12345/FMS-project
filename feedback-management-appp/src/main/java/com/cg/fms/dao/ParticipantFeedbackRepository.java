package com.cg.fms.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.fms.entities.ParticipantFeedback;

@Repository
public interface ParticipantFeedbackRepository extends JpaRepository<ParticipantFeedback,Integer>{
	
	//@Query("SELECT p FROM ParticipantFeedback p WHERE p.participant.participant_id = :id")
    @Query("from ParticipantFeedback where participant_id = ?1" )
	List<ParticipantFeedback> findByparticipant( Integer participantId);
    //@Query("SELECT f FROM ParticipantFeedback f WHERE f.faculty.faculty_id = ?1")
    @Query("from ParticipantFeedback where faculty_id = ?1" )
    List<ParticipantFeedback> findByfaculty( Integer facultyId);    
}