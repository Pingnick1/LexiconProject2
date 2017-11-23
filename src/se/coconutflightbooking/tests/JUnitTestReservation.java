package se.coconutflightbooking.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.coconutflightbooking.AirPlane;
import se.coconutflightbooking.AirPlaneStatus;
import se.coconutflightbooking.Departure;
import se.coconutflightbooking.Reservation;
import se.coconutflightbooking.ReservationStatus;
import se.coconutflightbooking.TicketType;

class JUnitTestReservation {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGettersAndSetters() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");	// Använd denna istället: DateTimeFormatter.ISO_LOCAL_DATE
		
		AirPlane a1 = new AirPlane("CCN000001", 5, 5, AirPlaneStatus.HANGAR);
		AirPlane a2 = new AirPlane("CCN000002", 5, 5, AirPlaneStatus.HANGAR);
		
		LocalDateTime dateTime1 = LocalDateTime.parse("2017-11-25 12:30", formatter);
		LocalDateTime dateTime2 = LocalDateTime.parse("2017-11-27 12:30", formatter);
		
		LocalDateTime dateTime3 = LocalDateTime.parse("2017-11-25 12:30", formatter);
		
		Departure d1 = new Departure("", dateTime1, "London", a1, 20000,5000);
		Departure d2 = new Departure("", dateTime2, "Madrid", a2, 20000,5000);
		
		Reservation r1 = new Reservation("CCNB001", dateTime3, "Niklas Svensson", d1, TicketType.ECONOMYCLASS, 5000);
		//Reservation r2 = new Reservation("CCNB002", "David Svensson", d1, TicketType.FIRSTCLASS, 20000);
		
		/*
		assertTrue(r1.getReservationID().equals("CCNB001"));
		assertTrue(r1.getReservationStatus() == ReservationStatus.PAYED);
		assertTrue(r1.getDeparture().equals(d1));
		assertTrue(r1.getTicketCost() == 5000);
		assertTrue(r1.getTicketType().equals(TicketType.ECONOMYCLASS));
		assertTrue(r1.getCustomer().equals("Niklas Svensson"));
		*/
		System.out.println(r1);
		
		r1.setReservationStatus(ReservationStatus.USED);
		r1.setDeparture(d2);
		r1.setTicketCost(20000);
		r1.setTicketType(TicketType.FIRSTCLASS);
		r1.setCustomer("Lars Åkesson");
		
		assertTrue(r1.getReservationID().equals("CCNB001"));
		assertTrue(r1.getReservationStatus() == ReservationStatus.USED);
		assertTrue(r1.getDeparture().equals(d2));
		assertTrue(r1.getTicketCost() == 20000);
		assertTrue(r1.getTicketType().equals(TicketType.FIRSTCLASS));
		assertTrue(r1.getCustomer().equals("Lars Åkesson"));
		System.out.println(r1);	
	}

}
