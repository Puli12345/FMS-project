package com.cg.fms.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ParticipantTest {

	private Participant participant;

	@BeforeEach
	void setUp() throws Exception {
		participant= new Participant(1,"Praveen","Jagtial",9010766088L,"praveen@gmail.com");		
	}
	
	@AfterEach
	void reset() throws Exception {
		participant= null;		
	}
	@Test
	void testGetParticipantId() {
		assertEquals(1,participant.getParticipantId());
	}

	@Test
	void testGetParticipantName() {
		assertEquals("Praveen",participant.getParticipantName());
	}

	@Test
	void testGetAddress() {
		assertEquals("Jagtial",participant.getAddress());
	}

	@Test
	void testGetMobile() {
		assertEquals(9010766088L,participant.getMobile());
	}

	@Test
	void testGetEmail() {
		assertEquals("praveen@gmail.com",participant.getEmail());
	}

}
