package com.cg.fms.exception;

public class FeedbackMasterException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FeedbackMasterException() {

	}

	public FeedbackMasterException(String errMessage) {
		super(errMessage);
	}

	public FeedbackMasterException(String errMessage, Throwable t) {
		super(errMessage,t);
	}
}

