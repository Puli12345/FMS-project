package com.cg.fms.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.fms.dao.ParticipantFeedbackRepository;
import com.cg.fms.entities.ParticipantFeedback;
import com.cg.fms.exception.ParticipantFeedbackException;
import com.cg.fms.service.ParticipantFeedbackService;

class ParticipantFeedbackControllerTest {

	@Autowired
	private ParticipantFeedbackService participantFeedbackService;

	@MockBean
	private ParticipantFeedbackRepository participantFeedbackRepository;


	@Test
	void ListTest() throws ParticipantFeedbackException {
		try{
			ParticipantFeedback pf1 = new ParticipantFeedback(1,4,5,4,5,3,18.6);
			ParticipantFeedback pf2 = new ParticipantFeedback(2,4,5,4,5,3,18.6);
			ParticipantFeedback pf3 = new ParticipantFeedback(3,4,5,4,5,3,18.6);

			List<ParticipantFeedback> allParticipantFeedbacks = new ArrayList<ParticipantFeedback>();
			allParticipantFeedbacks.add(pf1);
			allParticipantFeedbacks.add(pf2);
			allParticipantFeedbacks.add(pf3);
			participantFeedbackRepository.findAll();
			assertEquals(allParticipantFeedbacks, participantFeedbackService.getAllparticipantFeedbacks());
		}catch(Exception e) {
			e.getMessage();
		}

	}

	@Test
	void addParticipantFeedbackTest() throws ParticipantFeedbackException {
		try {
			ParticipantFeedback pf1 = new ParticipantFeedback(1,4,5,4,5,3,18.6);
			when(participantFeedbackRepository.save(pf1)).thenReturn(pf1);
			participantFeedbackService.addParticipantFeedback(pf1);
			verify(participantFeedbackRepository,times(1)).save(pf1);
		}catch(Exception e) {
			e.getMessage();
		}
	}

	@Test
	void updateParticipantFeedbackTest() throws ParticipantFeedbackException {
		try {
			ParticipantFeedback pf1 = new ParticipantFeedback(1,4,5,4,5,3,18.6);
			participantFeedbackService.updateParticipantFeedback(pf1);
			verify(participantFeedbackRepository,times(1)).save(pf1);
		}catch(Exception e) {
			e.getMessage();
		}
	}

	@Test
	void deleteParticipantFeedbackTest() throws ParticipantFeedbackException{
		try {
			participantFeedbackService.removeParticipantFeedback(1);
			verify(participantFeedbackRepository,times(1)).deleteById(1);;
		}catch(Exception e) {
			e.getMessage();
		}
	}

	@Test
	void getParticipantFeedbackByNo() throws ParticipantFeedbackException {
		try {
			ParticipantFeedback pf1 = new ParticipantFeedback(1,4,5,4,5,3,18.6);
			when(participantFeedbackRepository.getById(1)).thenReturn(pf1);
			assertEquals(pf1,participantFeedbackService.getParticipantFeedbackByNo(1));
		}catch(Exception e) {
			e.getMessage();
		}
	}

@Test
void getParticipantById() throws ParticipantFeedbackException {
try {
ParticipantFeedback pf1 = new ParticipantFeedback(1,4,5,4,5,3,18.6);
when(participantFeedbackRepository.getById(1)).thenReturn(pf1);
assertEquals(pf1,participantFeedbackService.findByParticipantId(1));
}catch(Exception e) {
e.getMessage();
}
}

@Test
void getFacultyById() throws ParticipantFeedbackException {
try {
ParticipantFeedback pf1 = new ParticipantFeedback(1,4,5,4,5,3,18.6);
when(participantFeedbackRepository.getById(1)).thenReturn(pf1);
assertEquals(pf1,participantFeedbackService.findByFacultyId(1));
}catch(Exception e) {
e.getMessage();
}
}
}


