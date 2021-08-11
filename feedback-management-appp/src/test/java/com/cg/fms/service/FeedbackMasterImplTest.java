package com.cg.fms.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.fms.dao.FeedbackMasterRepository;
import com.cg.fms.entities.FeedbackMaster;
import com.cg.fms.exception.FacultyException;
import com.cg.fms.exception.FeedbackMasterException;

class FeedbackMasterImplTest {

	@Autowired
	private FeedbackMasterService feedbackMasterService;

	@MockBean
	private FeedbackMasterRepository feedbackMasterRepository;

	@Test
	void addFeedbackMasterTest() throws FeedbackMasterException {
		try {
			FeedbackMaster fm1 = new FeedbackMaster(1,"question1","question2","question3","question4","question5");
			when(feedbackMasterRepository.save(fm1)).thenReturn(fm1);
			feedbackMasterService.addFeedbackMaster(fm1);
			verify(feedbackMasterRepository,times(1)).save(fm1);
		}catch(Exception e) {
			e.getMessage();
		}
	}

	@Test
	void updateFacultyTest() throws FacultyException {
		try {
			FeedbackMaster fm1 = new FeedbackMaster(1,"question1","question2","question3","question4","question5");
			feedbackMasterService.updateFeedbackMaster(fm1);
			verify(feedbackMasterRepository,times(1)).save(fm1);
		}catch(Exception e) {
			e.getMessage();
		}
	}
}

