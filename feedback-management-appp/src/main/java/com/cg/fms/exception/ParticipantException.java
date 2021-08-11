package com.cg.fms.exception;

public class ParticipantException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ParticipantException() {

	}

	public ParticipantException(String errMessage) {
		super(errMessage);
	}

	public ParticipantException(String errMessage, Throwable t) {
		super(errMessage,t);
	}
}
