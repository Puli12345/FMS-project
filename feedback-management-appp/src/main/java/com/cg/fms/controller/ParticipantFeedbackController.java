package com.cg.fms.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cg.fms.entities.ParticipantFeedback;
import com.cg.fms.exception.ParticipantFeedbackException;
import com.cg.fms.service.ParticipantFeedbackService;

import io.swagger.annotations.Api;

@Api
@RestController
@Transactional
@RequestMapping("/v1")
public class ParticipantFeedbackController {



	@Autowired
	private ParticipantFeedbackService participantFeedbackService;

	@GetMapping("/participantfeedbackbyid/{id}")
	public ResponseEntity<ParticipantFeedback> getParticipantFeedbackByNo(@PathVariable(value = "id") Integer feedbackNo){

		try {
			ParticipantFeedback pf= participantFeedbackService.getParticipantFeedbackByNo(feedbackNo);
			return new ResponseEntity<>(pf,HttpStatus.OK);
		}catch(ParticipantFeedbackException e) {
			throw new ResponseStatusException(
					HttpStatus.INTERNAL_SERVER_ERROR, "Unable to get paticipantfeedbackbyno", e);
		}
	}
	
	@GetMapping("/byparticipant/{participantid}")
	public ResponseEntity<List<ParticipantFeedback>> getParticipantById(@PathVariable(value = "participantid") Integer participantId) throws ParticipantFeedbackException {
		try {
			List<ParticipantFeedback> participantFeedbackList= participantFeedbackService.findByParticipantId(participantId);
			return new ResponseEntity<>(participantFeedbackList,HttpStatus.OK);
		}catch(ParticipantFeedbackException e) {
			throw new ResponseStatusException(
			           HttpStatus.INTERNAL_SERVER_ERROR, "Unable to find participantFeedback by participantId", e);
		}
	}

	@GetMapping("/byfaculty/{facultyid}")
	public ResponseEntity<List<ParticipantFeedback>> getFacultyById(@PathVariable(value = "facultyid") Integer facultyId){

	try {
		List<ParticipantFeedback> participantFeedbackList= participantFeedbackService.findByFacultyId(facultyId);
		return new ResponseEntity<>(participantFeedbackList,HttpStatus.OK);
	}catch(ParticipantFeedbackException e) {
		throw new ResponseStatusException(
		           HttpStatus.INTERNAL_SERVER_ERROR, "Unable to find participantFeedback by facultyId", e);
	}
	}

	@GetMapping("/participantfeedbacklist")
	public ResponseEntity<List<ParticipantFeedback>> getParticipantFeedbackList(){

		try {
			List<ParticipantFeedback> pfList=participantFeedbackService.getAllparticipantFeedbacks();
			return new ResponseEntity<>(pfList,HttpStatus.OK);	
		}catch(ParticipantFeedbackException e) {
			throw new ResponseStatusException(
					HttpStatus.INTERNAL_SERVER_ERROR, "Unable to get paticipantfeedbacklist by participantId", e);
		}
	}

	@PostMapping("/addparticipantfeedback")
	public ResponseEntity<ParticipantFeedback> addParticipantFeedback(@Valid @RequestBody ParticipantFeedback participantFeedback) {
		try {
			ParticipantFeedback pf= participantFeedbackService.addParticipantFeedback(participantFeedback);
			return new ResponseEntity<>(pf,HttpStatus.OK);
		}catch(ParticipantFeedbackException e) {
			throw new ResponseStatusException(
					HttpStatus.INTERNAL_SERVER_ERROR, "Unable to add participantfeedback", e);
		}
	}

	@DeleteMapping("/deleteparticipantfeedback/{id}")
	public String deleteParticipantFeedback(@PathVariable(value = "id") Integer feedbackNo) {

		try {
			participantFeedbackService.removeParticipantFeedback(feedbackNo);
			return feedbackNo+ "deleted";
		}catch(ParticipantFeedbackException e) {
			throw new ResponseStatusException(
					HttpStatus.INTERNAL_SERVER_ERROR, "Unable to delete participantfeedback", e);
		}
	}


	@PutMapping("/updateparticipantfeedback")
	public ResponseEntity<ParticipantFeedback> updateParticipant(@Valid @RequestBody ParticipantFeedback participantFeedback) {

		try {
			ParticipantFeedback p = participantFeedbackService.updateParticipantFeedback(participantFeedback);
			return new ResponseEntity<>(p,HttpStatus.OK);
		}catch(ParticipantFeedbackException e) {
			throw new ResponseStatusException(
					HttpStatus.INTERNAL_SERVER_ERROR, "Unable to update participantfeedback", e);
		}
	}
}