package com.cg.fms.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.cg.fms.dao.FeedbackMasterRepository;
import com.cg.fms.entities.FeedbackMaster;
import com.cg.fms.exception.FeedbackMasterException;

@Service
@Transactional
public class FeedbackMasterImpl implements FeedbackMasterService {

	@Autowired
	private FeedbackMasterRepository repository;
	
	
	@Override
	public FeedbackMaster addFeedbackMaster(FeedbackMaster feedback) throws FeedbackMasterException {
		try{
			feedback.setFeedbackSno(null);
			FeedbackMaster savedFeedbackMaster=repository.save(feedback);
			return savedFeedbackMaster;
		}catch(DataAccessException e) {
			throw new FeedbackMasterException(e.getMessage(),e);
		}
	}

	
	@Override
	public FeedbackMaster updateFeedbackMaster(FeedbackMaster feedback) throws FeedbackMasterException {
		try{
			FeedbackMaster savedFeedbackMaster=repository.save(feedback);
			return savedFeedbackMaster;
		}catch(DataAccessException e) {
			throw new FeedbackMasterException(e.getMessage(),e);
		}
	}

}
