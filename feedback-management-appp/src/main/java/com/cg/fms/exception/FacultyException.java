package com.cg.fms.exception;

public class FacultyException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FacultyException() {

	}

	public FacultyException(String errMessage) {
		super(errMessage);
	}

	public FacultyException(String errMessage, Throwable t) {
		super(errMessage,t);
	}
}

