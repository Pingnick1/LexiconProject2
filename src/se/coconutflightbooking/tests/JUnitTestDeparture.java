package se.coconutflightbooking.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

import se.coconutflightbooking.AirPlane;
import se.coconutflightbooking.AirPlaneStatus;
import se.coconutflightbooking.Departure;

class JUnitTestDeparture {

	@Test
	void testCreateDeparture() {
		AirPlane a1 = new AirPlane("CCC000001", 5, 5, AirPlaneStatus.HANGAR);
		
		String str = "1986-04-08 12:30";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");	// Använd denna istället: DateTimeFormatter.ISO_LOCAL_DATE

		LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
		
		
		Departure d1 = new Departure("DDD001", dateTime,"Panama" , a1.getAirPlaneID(), 20000, 5000);
		
		//assertTrue(d1.getDepartureID().toString().equals("DDD000001"));
		
		
		System.out.println(d1);
		
		
	}

}
