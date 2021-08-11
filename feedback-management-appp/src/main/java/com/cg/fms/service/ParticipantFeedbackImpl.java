package com.cg.fms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.cg.fms.dao.ParticipantFeedbackRepository;
import com.cg.fms.entities.ParticipantFeedback;
import com.cg.fms.exception.ParticipantFeedbackException;

@Service
@Transactional
public class ParticipantFeedbackImpl implements ParticipantFeedbackService {


	@Autowired
	private ParticipantFeedbackRepository repository;

	//	@Autowired
	//	private ParticipantRepository Participantrepository;

	@Override
	public ParticipantFeedback getParticipantFeedbackByNo(Integer feedbackNo) throws ParticipantFeedbackException {
		try {
			Optional<ParticipantFeedback> optional= repository.findById(feedbackNo);
			if(optional.isPresent()) {
				return optional.get();      
			}else {
				throw new ParticipantFeedbackException("Invalid feedbackNo");
			}
		}catch(DataAccessException e) {
			throw new ParticipantFeedbackException(e.getMessage(),e);
		}
	}

	@Override
	public List<ParticipantFeedback> getAllparticipantFeedbacks() throws ParticipantFeedbackException{

		try {

			List<ParticipantFeedback> participantFeedbackList=repository.findAll();
			return participantFeedbackList;
		}catch(DataAccessException e) {
			throw new ParticipantFeedbackException(e.getMessage(),e);
		}
	}

	@Override
	public ParticipantFeedback addParticipantFeedback(ParticipantFeedback participantFeedback1) throws ParticipantFeedbackException {
		try {

			participantFeedback1.setFeedbackNo(null);
			ParticipantFeedback participantFeedback= repository.saveAndFlush(participantFeedback1);
			Integer sum = participantFeedback.getMarksQuestion1() + participantFeedback.getMarksQuestion2() +participantFeedback.getMarksQuestion3() +participantFeedback.getMarksQuestion4() +participantFeedback.getMarksQuestion5();
			double average =  sum/5.0;
			participantFeedback.setAverageRating(average);
			return participantFeedback;
		}catch(DataAccessException e) {
			throw new ParticipantFeedbackException(e.getMessage(),e);
		}
	}

	@Override
	public void removeParticipantFeedback(Integer feedbackNo) throws ParticipantFeedbackException{
		try {
			repository.deleteById(feedbackNo);
			System.out.println(feedbackNo+ "is deleted");
		}catch(DataAccessException e) {
			throw new ParticipantFeedbackException(e.getMessage(),e);
		}

	}

	@Override
	public List<ParticipantFeedback> findByParticipantId(Integer participantId)
			throws ParticipantFeedbackException {
		try {
			List<ParticipantFeedback> participantList = repository.findByparticipant(participantId);
			return participantList;
		}catch(DataAccessException e) {
			throw new ParticipantFeedbackException(e.getMessage(),e);
		}
	}

	@Override
	public List<ParticipantFeedback> findByFacultyId(Integer facultyId)
			throws ParticipantFeedbackException {
		try {
			List<ParticipantFeedback> facultyList = repository.findByfaculty(facultyId);
			return facultyList;
		}catch(DataAccessException e) {
			throw new ParticipantFeedbackException(e.getMessage(),e);
		}
	}

	@Override
	public ParticipantFeedback updateParticipantFeedback(ParticipantFeedback participantFeedback) throws ParticipantFeedbackException{
		try {
			ParticipantFeedback savedParticipantFeedback= repository.save(participantFeedback);
			return savedParticipantFeedback;
		}catch(DataAccessException e) {
			throw new ParticipantFeedbackException(e.getMessage(),e);
		}
	}
}




