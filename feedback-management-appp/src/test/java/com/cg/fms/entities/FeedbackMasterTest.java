package com.cg.fms.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FeedbackMasterTest {
	
	private FeedbackMaster feedbackMaster;

	@BeforeEach
	void setUp() throws Exception {
		feedbackMaster= new FeedbackMaster(1,"Communication","Interaction","Explaination","DoubtClarification","Behaviour");		
	}
	
	@AfterEach
	void reset() throws Exception {
		feedbackMaster= null;		
	}

	@Test
	void testGetFeedbackSno() {
		assertEquals(1,feedbackMaster.getFeedbackSno());
	}

	@Test
	void testGetQuestion1() {
		assertEquals("Communication",feedbackMaster.getQuestion1());
	}

	@Test
	void testGetQuestion2() {
		assertEquals("Interaction",feedbackMaster.getQuestion2());
	}

	@Test
	void testGetQuestion3() {
		assertEquals("Explaination",feedbackMaster.getQuestion3());
	}

	@Test
	void testGetQuestion4() {
		assertEquals("DoubtClarification",feedbackMaster.getQuestion4());
	}

	@Test
	void testGetQuestion5() {
		assertEquals("Behaviour",feedbackMaster.getQuestion5());
	}

}
