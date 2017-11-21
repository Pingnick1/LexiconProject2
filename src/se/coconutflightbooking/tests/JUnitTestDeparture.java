package se.coconutflightbooking.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import se.coconutflightbooking.AirPlane;
import se.coconutflightbooking.AirPlaneStatus;
import se.coconutflightbooking.Departure;

class JUnitTestDeparture {

	@Test
	void testCreateDeparture() {
		AirPlane a1 = new AirPlane("CCC000001", 5, 5, AirPlaneStatus.HANGAR);
		
		Departure d1 = new Departure("DDD000001", a1, 20000, 5000);
		
		assertTrue(d1.getDepartureID().toString().equals("DDD000001"));
		
		
		System.out.println(d1);
		
		
	}

}
