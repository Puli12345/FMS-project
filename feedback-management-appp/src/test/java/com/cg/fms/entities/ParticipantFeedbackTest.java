package com.cg.fms.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ParticipantFeedbackTest {
	
	
	private ParticipantFeedback participantFeedback;

	@BeforeEach
	void setUp() throws Exception {
		participantFeedback= new ParticipantFeedback(11,3,4,2,5,3,3.4);		
	}
	
	@AfterEach
	void reset() throws Exception {
		participantFeedback= null;		
	}


	@Test
	void testGetFeedbackNo() {
		assertEquals(11,participantFeedback.getFeedbackNo());
	}

	@Test
	void testGetMarksQuestion1() {
		assertEquals(3,participantFeedback.getMarksQuestion1());
	}

	@Test
	void testGetMarksQuestion2() {
		assertEquals(4,participantFeedback.getMarksQuestion2());
	}

	@Test
	void testGetMarksQuestion3() {
		assertEquals(2,participantFeedback.getMarksQuestion3());
	}

	@Test
	void testGetMarksQuestion4() {
		assertEquals(5,participantFeedback.getMarksQuestion4());
	}

	@Test
	void testGetMarksQuestion5() {
		assertEquals(3,participantFeedback.getMarksQuestion5());
	}

	@Test
	void testGetAverageRating() {
		assertEquals(3.4,participantFeedback.getAverageRating());
	}


}
