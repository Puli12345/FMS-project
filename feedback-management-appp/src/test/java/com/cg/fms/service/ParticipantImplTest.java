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

import com.cg.fms.dao.ParticipantRepository;
import com.cg.fms.entities.Participant;
import com.cg.fms.exception.ParticipantException;

class ParticipantImplTest {

	@Autowired
	private ParticipantService participantService;

	@MockBean
	private ParticipantRepository participantRepository;


	@Test
	void ListTest() throws ParticipantException {
		try{
			Participant participant1 = new Participant(1,"Sumanth","Hyderabad",8893291187L,"ravi@gmail.com");
			Participant participant2 = new Participant(2,"Varun","Hyderabad",7893290187L,"varun@gmail.com");
			Participant participant3 = new Participant(3,"Kushwant","Hyderabad",9893290189L,"kushwant@gmail.com");

			List<Participant> allFaculties = new ArrayList<Participant>();
			allFaculties.add(participant1);
			allFaculties.add(participant2);
			allFaculties.add(participant3);
			participantRepository.findAll();
			assertEquals(allFaculties, participantService.getAllparticipants());
		}catch(Exception e) {
			e.getMessage();
		}

	}

	@Test
	void addParticipantTest() throws ParticipantException {
		try {
			Participant p1 = new Participant(1,"Sumanth","Hyderabad",7893290187L,"ravi@gmail.com");
			when(participantRepository.save(p1)).thenReturn(p1);
			participantService.addParticipant(p1);
			verify(participantRepository,times(1)).save(p1);
		}catch(Exception e) {
			e.getMessage();
		}
	}

	@Test
	void updateParticipantTest() throws ParticipantException {
		try {
			Participant p1 = new Participant(1,"Sumanth","Hyderabad",7893290187L,"ravi@gmail.com");
			participantService.updateParticipant(p1);
			verify(participantRepository,times(1)).save(p1);
		}catch(Exception e) {
			e.getMessage();
		}
	}

	@Test
	void deleteParticipantTest() throws ParticipantException{
		try {
			participantService.removeParticipant(1);
			verify(participantRepository,times(1)).deleteById(1);;
		}catch(Exception e) {
			e.getMessage();
		}
	}

	@Test
	void getParticipantById() throws ParticipantException {
		try {
			Participant p1 = new Participant(1,"Sumanth","Hyderabad",7893290187L,"ravi@gmail.com");
			when(participantRepository.getById(1)).thenReturn(p1);
			assertEquals(p1,participantService.getParticipantById(1));
		}catch(Exception e) {
			e.getMessage();
		}
	}
}



