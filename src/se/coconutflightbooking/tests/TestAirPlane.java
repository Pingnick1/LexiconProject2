package se.coconutflightbooking.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


import se.coconutflightbooking.AirPlane;
import se.coconutflightbooking.AirPlaneListHandler;
import se.coconutflightbooking.AirPlaneStatus;

class TestAirPlane {

	@Test
	void testCreateAirPlane() {
		
		AirPlane plane1 = new AirPlane("CC001", 5, 5, AirPlaneStatus.HANGAR);
		
		System.out.println(plane1);
		
	
	}
	
	

}
