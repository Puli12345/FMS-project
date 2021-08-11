package com.cg.fms.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cg.fms.entities.Participant;
import com.cg.fms.exception.ParticipantException;
import com.cg.fms.service.ParticipantService;

import io.swagger.annotations.Api;

@Api
@RestController
@Transactional
@RequestMapping("/v1")
@CrossOrigin("*")
public class ParticipantController {

	@GetMapping("/testparticipant")
	public Participant getParticipant() {
		return new Participant(1,"Hyderabad","kishore@gmail.com",7660889908L,"kishore",null , null) ;		
	}

	@Autowired
	private ParticipantService participantService;

	
	
	@GetMapping("/participantbyid/{id}")
	public ResponseEntity<Participant> getParticipantById(@PathVariable(value = "id") Integer participantId){
		try{
			Participant participant= participantService.getParticipantById(participantId);
			return new ResponseEntity<>(participant,HttpStatus.OK);
		}catch(ParticipantException e) {
			throw new ResponseStatusException(
					HttpStatus.INTERNAL_SERVER_ERROR, "Unable to get participant", e);
		}
	}

	
	@GetMapping("/participantlist")
	public ResponseEntity<List<Participant>> getParticipantList(){
		try{
			List<Participant> participantList=participantService.getAllparticipants();
			return new ResponseEntity<>(participantList,HttpStatus.OK);	
		}catch(ParticipantException e) {
			throw new ResponseStatusException(
					HttpStatus.INTERNAL_SERVER_ERROR, "Unable to get participantList", e);
		}
	}

	
	@PostMapping("/addparticipant")
	public ResponseEntity<Participant> addParticipant(@Valid @RequestBody Participant participant) {
		try{
			Participant p= participantService.addParticipant(participant);
			return new ResponseEntity<>(p,HttpStatus.OK);
		}catch(ParticipantException e) {
			throw new ResponseStatusException(
					HttpStatus.INTERNAL_SERVER_ERROR, "Unable to add participant", e);
		}
	}

	
	
	@DeleteMapping("/deleteparticipant/{id}")
	public String deleteParticipant(@PathVariable(value = "id") Integer participantId) {
		try{
			participantService.removeParticipant(participantId);
			return participantId+ "deleted";
		}catch(ParticipantException e) {
			throw new ResponseStatusException(
					HttpStatus.INTERNAL_SERVER_ERROR, "Unable to delete participant", e);
		}
	}

	
	
	@PutMapping("/updateparticipant")
	public ResponseEntity<Participant> updateParticipant(@Valid @RequestBody Participant participant) {
		try{
			Participant p = participantService.updateParticipant(participant);
			return new ResponseEntity<>(p,HttpStatus.OK);
		}catch(ParticipantException e) {
			throw new ResponseStatusException(
					HttpStatus.INTERNAL_SERVER_ERROR, "Unable to update participant", e);
		}
	}
}