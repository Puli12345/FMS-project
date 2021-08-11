package com.cg.fms.exception;

public class SkillsException extends Exception  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SkillsException() {

	}

	public SkillsException(String errMessage) {
		super(errMessage);
	}

	public SkillsException(String errMessage, Throwable t) {
		super(errMessage,t);
	}
}
