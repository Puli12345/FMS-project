package com.cg.fms.exception;

public class ParticipantFeedbackException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ParticipantFeedbackException() {

	}

	public ParticipantFeedbackException(String errMessage) {
		super(errMessage);
	}

	public ParticipantFeedbackException(String errMessage, Throwable t) {
		super(errMessage,t);
	}
}
