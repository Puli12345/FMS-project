package com.cg.fms.exception;
public class CourseException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CourseException() {

	}

	public CourseException(String errMessage) {
		super(errMessage);
	}

	public CourseException(String errMessage, Throwable t) {
		super(errMessage,t);
	}
}
