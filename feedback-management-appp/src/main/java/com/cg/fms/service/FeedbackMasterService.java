package com.cg.fms.service;

import com.cg.fms.entities.FeedbackMaster;
import com.cg.fms.exception.FeedbackMasterException;

public interface FeedbackMasterService {
	public abstract FeedbackMaster addFeedbackMaster(FeedbackMaster feedback) throws FeedbackMasterException;
	public abstract FeedbackMaster updateFeedbackMaster(FeedbackMaster feedback) throws FeedbackMasterException;
}
