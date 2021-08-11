package com.cg.fms.service;

import java.util.List;

import com.cg.fms.entities.Participant;
import com.cg.fms.exception.ParticipantException;

public interface ParticipantService {
	public abstract Participant getParticipantById(Integer participantId ) throws ParticipantException;
	public abstract List<Participant> getAllparticipants() throws ParticipantException;
	public abstract Participant addParticipant(Participant participant) throws ParticipantException;
	public abstract void removeParticipant(Integer participantId) throws ParticipantException;
	public abstract Participant updateParticipant(Participant participant) throws ParticipantException;

}