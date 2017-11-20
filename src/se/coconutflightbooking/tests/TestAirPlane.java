package se.coconutflightbooking.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import se.coconutflightbooking.AirPlane;
import se.coconutflightbooking.AirPlaneListHandler;

class TestAirPlane {

	@Test
	void testCreateAirPlane() {
		
		AirPlane plane1 = new AirPlane("CC001", 5, 5);
		
		System.out.println(plane1);
		
	
	}
	
	@Test
	void testAirPlaneHandler() {
		AirPlane plane1 = new AirPlane("CC001", 5, 5);
		AirPlane plane2 = new AirPlane("CC002", 10, 5);
		AirPlane plane3 = new AirPlane("CC003", 6, 4);
		AirPlane plane4 = new AirPlane("CC004", 1, 9);
		AirPlane plane5 = new AirPlane("CC005", 20, 10);
		
		AirPlaneListHandler airPlaneList = new AirPlaneListHandler();
		
		airPlaneList.addAirPlane(plane1);
		airPlaneList.addAirPlane(plane2);
		airPlaneList.addAirPlane(plane3);
		airPlaneList.addAirPlane(plane4);
		airPlaneList.addAirPlane(plane5);
		
		System.out.println(airPlaneList);
		
	}

}
