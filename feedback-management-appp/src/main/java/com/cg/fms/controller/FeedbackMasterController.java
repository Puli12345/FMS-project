package com.cg.fms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cg.fms.entities.FeedbackMaster;
import com.cg.fms.exception.FeedbackMasterException;
import com.cg.fms.service.FeedbackMasterService;

import io.swagger.annotations.Api;

@Api
@RestController
@Transactional
@RequestMapping("/v1")
@CrossOrigin("*")
public class FeedbackMasterController {

	@Autowired
	private FeedbackMasterService feedbackMasterService;

	@PostMapping("/addfeedback")
	public ResponseEntity<FeedbackMaster> addFeedback(@Valid @RequestBody FeedbackMaster  feedback) {
		try{
			FeedbackMaster f = feedbackMasterService.addFeedbackMaster(feedback);
			return new ResponseEntity<>(f,HttpStatus.OK);
		}catch(FeedbackMasterException e) {
			throw new ResponseStatusException(
					HttpStatus.INTERNAL_SERVER_ERROR, "Unable to add feedback", e);
		}
	}
	@PutMapping("/updatefeedback")
	public ResponseEntity<FeedbackMaster> updateFeedback(@Valid @RequestBody FeedbackMaster feedback) {
		try{
			FeedbackMaster f = feedbackMasterService.updateFeedbackMaster(feedback);
			return new ResponseEntity<>(f,HttpStatus.OK);
		}catch(FeedbackMasterException e) {
			throw new ResponseStatusException(
					HttpStatus.INTERNAL_SERVER_ERROR, "Unable to update feedback", e);
		}
	}


}
