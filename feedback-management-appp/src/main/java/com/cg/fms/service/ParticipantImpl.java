package com.cg.fms.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.cg.fms.dao.ParticipantRepository;
import com.cg.fms.entities.Participant;
import com.cg.fms.exception.ParticipantException;
@Service
@Transactional
public class ParticipantImpl implements ParticipantService{

	@Autowired
	private ParticipantRepository repository;
	
	@Override
	public List<Participant> getAllparticipants() throws ParticipantException {
		try{
			List<Participant> participantList=repository.findAll();
			return participantList;
		}catch(DataAccessException e) {
			throw new ParticipantException(e.getMessage(),e);
		}
	}


	@Override
	public Participant addParticipant(Participant participant) throws ParticipantException {
		try{
			participant.setParticipantId(null);
			Participant savedParticipant= repository.save(participant);
			return savedParticipant;
		}catch(DataAccessException e) {
			throw new ParticipantException(e.getMessage(),e);
		}
	}


	@Override
	public void removeParticipant(Integer participantId) throws ParticipantException {
		try{
			repository.deleteById(participantId);
			System.out.println(participantId+"is deleted");
		}catch(DataAccessException e) {
			throw new ParticipantException(e.getMessage(),e);
		}

	}

	@Override
	public Participant getParticipantById(Integer participantId) throws ParticipantException {
		try{
			Optional<Participant> optional= repository.findById(participantId);
			if(optional.isPresent()) {
				return optional.get();
			}else {
				throw new ParticipantException("Invalid participantId");
			}
		}catch(DataAccessException e) {
			throw new ParticipantException(e.getMessage(),e);
		}	
	}

	@Override
	public Participant updateParticipant(Participant participant) throws ParticipantException {
		try {
			Participant savedEmployee= repository.save(participant);
			return savedEmployee;
		}catch(DataAccessException e) {
			throw new ParticipantException(e.getMessage(),e);
		}

	}
}