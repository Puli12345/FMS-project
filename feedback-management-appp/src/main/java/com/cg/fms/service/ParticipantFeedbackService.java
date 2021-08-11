package com.cg.fms.service;

import java.util.List;

import com.cg.fms.entities.ParticipantFeedback;
import com.cg.fms.exception.ParticipantFeedbackException;

public interface ParticipantFeedbackService {
	public abstract ParticipantFeedback getParticipantFeedbackByNo(Integer feedbackNo ) throws ParticipantFeedbackException;
	public abstract List<ParticipantFeedback> getAllparticipantFeedbacks() throws ParticipantFeedbackException;
	public abstract ParticipantFeedback addParticipantFeedback(ParticipantFeedback participantFeedback) throws ParticipantFeedbackException;
	public abstract void removeParticipantFeedback(Integer feedbackNo) throws ParticipantFeedbackException;
	public abstract List<ParticipantFeedback> findByParticipantId(Integer participantId) throws ParticipantFeedbackException;
	public abstract List<ParticipantFeedback> findByFacultyId(Integer facultyId) throws ParticipantFeedbackException;
	public abstract ParticipantFeedback updateParticipantFeedback(ParticipantFeedback participantFeedback) throws ParticipantFeedbackException;
}