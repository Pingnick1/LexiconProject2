package se.coconutflightbooking.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.coconutflightbooking.AirPlane;
import se.coconutflightbooking.AirPlaneStatus;
import se.coconutflightbooking.Departure;
import se.coconutflightbooking.Reservation;
import se.coconutflightbooking.ReservationListHandler;
import se.coconutflightbooking.TicketType;
import se.coconutflightbooking.exceptions.ReservationAlreadyExistInListException;
import se.coconutflightbooking.exceptions.ReservationNotFoundException;

class JUnitTestReservationListHandler {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGetReservation() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");	// Använd denna istället: DateTimeFormatter.ISO_LOCAL_DATE
		
		ReservationListHandler reservationHandler = new ReservationListHandler();
		String customer = "Lars Nilsson";
		AirPlane a1 = new AirPlane("CCN000001", 5, 5, AirPlaneStatus.HANGAR);

		LocalDateTime dateTime1 = LocalDateTime.parse("2017-11-25 12:30", formatter);
		
		Departure d1 = new Departure("DDD001", dateTime1, "London", a1.getAirPlaneID(), 20000, 5000);
		
		reservationHandler.addReservation(customer, d1, TicketType.FIRSTCLASS, 200000);
			
		try {
			System.out.println(reservationHandler.getReservation("RRR001"));
			assertTrue(reservationHandler.getReservation("RRR001").getReservationID().equals("RRR001"));
		} catch (ReservationNotFoundException e) {
			System.out.println("ReservationNotFoundException");
			e.printStackTrace();
		}
		
	}

	@Test
	void testGetNextUniqueReservationID() {
		ReservationListHandler reservationHandler = new ReservationListHandler();
		String newReservationID = reservationHandler.getNextUniqueReservationID();
		System.out.println("Next unique Reservation ID: " + newReservationID);
		assertTrue(newReservationID.equals("RRR001"));
	}

	@Test
	void testReservationIdExistInList() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");	// Använd denna istället: DateTimeFormatter.ISO_LOCAL_DATE
		
		ReservationListHandler reservationHandler = new ReservationListHandler();
		String customer = "Lars Nilsson";
		AirPlane a1 = new AirPlane("CCN000001", 5, 5, AirPlaneStatus.HANGAR);
		AirPlane a2 = new AirPlane("CCN000002", 5, 5, AirPlaneStatus.HANGAR);
		AirPlane a3 = new AirPlane("CCN000003", 5, 5, AirPlaneStatus.HANGAR);

		LocalDateTime dateTime1 = LocalDateTime.parse("2017-11-25 12:30", formatter);
		LocalDateTime dateTime2 = LocalDateTime.parse("2017-11-25 12:30", formatter);
		LocalDateTime dateTime3 = LocalDateTime.parse("2017-11-25 12:30", formatter);
		
		Departure d1 = new Departure("DDD001", dateTime1, "London", a1.getAirPlaneID(), 20000, 5000);
		Departure d2 = new Departure("DDD002", dateTime2, "London", a2.getAirPlaneID(), 20000, 5000);
		Departure d3 = new Departure("DDD003", dateTime3, "London", a3.getAirPlaneID(), 20000, 5000);
		
		reservationHandler.addReservation(customer, d1, TicketType.FIRSTCLASS, 200000);
		reservationHandler.addReservation(customer, d2, TicketType.ECONOMYCLASS, 5000);
		reservationHandler.addReservation(customer, d3, TicketType.FIRSTCLASS, 200000);
		
		assertTrue(reservationHandler.reservationIdExistInList("RRR002"));
		assertFalse(reservationHandler.reservationIdExistInList("RRR0"));
	}

	@Test
	void testAddReservationReservation() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");	// Använd denna istället: DateTimeFormatter.ISO_LOCAL_DATE
		
		ReservationListHandler reservationHandler = new ReservationListHandler();
		String customer = "Lars Nilsson";
		AirPlane a1 = new AirPlane("CCN000001", 5, 5, AirPlaneStatus.HANGAR);

		LocalDateTime dateTime1 = LocalDateTime.parse("2017-11-25 12:30", formatter);
		
		Departure d1 = new Departure("DDD001", dateTime1, "London", a1.getAirPlaneID(), 20000, 5000);
		
		reservationHandler.addReservation(customer, d1, TicketType.FIRSTCLASS, 200000);
			
		try {
			System.out.println(reservationHandler.getReservation("RRR001"));
			assertTrue(reservationHandler.getReservation("RRR001").getReservationID().equals("RRR001"));
			assertTrue(reservationHandler.size() == 1);
		} catch (ReservationNotFoundException e) {
			System.out.println("ReservationNotFoundException");
			e.printStackTrace();
		}
	}


	@Test
	void testAddReservationStringLocalDateTimeStringDepartureTicketTypeInteger() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");	// Använd denna istället: DateTimeFormatter.ISO_LOCAL_DATE
		
		ReservationListHandler reservationHandler = new ReservationListHandler();
		String customer1 = "Lars Nilsson";
		String customer2 = "Sune Olsson";
		String customer3 = "Pelle Svensson";
		AirPlane a1 = new AirPlane("CCN000001", 5, 5, AirPlaneStatus.HANGAR);
		AirPlane a2 = new AirPlane("CCN000002", 5, 5, AirPlaneStatus.HANGAR);
		AirPlane a3 = new AirPlane("CCN000003", 5, 5, AirPlaneStatus.HANGAR);

		LocalDateTime dateTime1 = LocalDateTime.parse("2017-11-25 12:30", formatter);
		LocalDateTime dateTime2 = LocalDateTime.parse("2017-11-25 12:30", formatter);
		LocalDateTime dateTime3 = LocalDateTime.parse("2017-11-25 12:30", formatter);
		
		Departure d1 = new Departure("DDD001", dateTime1, "London", a1.getAirPlaneID(), 20000, 5000);
		Departure d2 = new Departure("DDD002", dateTime2, "London", a2.getAirPlaneID(), 20000, 5000);
		Departure d3 = new Departure("DDD003", dateTime3, "London", a3.getAirPlaneID(), 20000, 5000);
		
		try {
			reservationHandler.addReservation("RRR001", dateTime1, customer1, d1, TicketType.FIRSTCLASS, 200000);
			reservationHandler.addReservation("RRR002", dateTime2, customer2, d2, TicketType.ECONOMYCLASS, 5000);
			reservationHandler.addReservation("RRR003", dateTime3, customer3, d3, TicketType.FIRSTCLASS, 200000);
			//reservationHandler.addReservation("RRR003", dateTime3, customer3, d3, TicketType.FIRSTCLASS, 200000);
		} catch (ReservationAlreadyExistInListException e) {
			System.out.println("ReservationAlreadyExistInListException");
			e.printStackTrace();
		}
		
		
		assertThrows(ReservationAlreadyExistInListException.class,
	            ()->{
	            	reservationHandler.addReservation("RRR003", dateTime3, customer3, d3, TicketType.FIRSTCLASS, 200000);
	            	
	            //do whatever you want to do here
	            //ex : objectName.thisMethodShoulThrowNullPointerExceptionForNullParameter(null);
	            });
		
		
		
		//assertTrue(reservationHandler.reservationIdExistInList("RRR002"));
		//assertFalse(reservationHandler.reservationIdExistInList("RRR0"));
	}

	@Test
	void testGetReservationList() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");	// Använd denna istället: DateTimeFormatter.ISO_LOCAL_DATE
		
		ReservationListHandler reservationHandler = new ReservationListHandler();
		String customer1 = "Lars Nilsson";
		String customer2 = "Sune Olsson";
		String customer3 = "Pelle Svensson";
		AirPlane a1 = new AirPlane("CCN000001", 5, 5, AirPlaneStatus.HANGAR);
		AirPlane a2 = new AirPlane("CCN000002", 5, 5, AirPlaneStatus.HANGAR);
		AirPlane a3 = new AirPlane("CCN000003", 5, 5, AirPlaneStatus.HANGAR);

		LocalDateTime dateTime1 = LocalDateTime.parse("2017-11-25 12:30", formatter);
		LocalDateTime dateTime2 = LocalDateTime.parse("2017-11-25 12:30", formatter);
		LocalDateTime dateTime3 = LocalDateTime.parse("2017-11-25 12:30", formatter);
		
		Departure d1 = new Departure("DDD001", dateTime1, "London", a1.getAirPlaneID(), 20000, 5000);
		Departure d2 = new Departure("DDD002", dateTime2, "London", a2.getAirPlaneID(), 20000, 5000);
		Departure d3 = new Departure("DDD003", dateTime3, "London", a3.getAirPlaneID(), 20000, 5000);
		
		try {
			reservationHandler.addReservation("RRR001", dateTime1, customer1, d1, TicketType.FIRSTCLASS, 200000);
			reservationHandler.addReservation("RRR002", dateTime2, customer2, d2, TicketType.ECONOMYCLASS, 5000);
			reservationHandler.addReservation("RRR003", dateTime3, customer3, d3, TicketType.FIRSTCLASS, 200000);
			
		} catch (ReservationAlreadyExistInListException e) {
			System.out.println("ReservationAlreadyExistInListException");
			e.printStackTrace();
		}
		
		HashMap<String, Reservation> result = reservationHandler.getReservationList();
		
		assertTrue(result.size()==3);
		
		
	}

	@Test
	void testSetReservationList() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");	// Använd denna istället: DateTimeFormatter.ISO_LOCAL_DATE
		
		ReservationListHandler reservationHandler = new ReservationListHandler();
		String customer1 = "Lars Nilsson";
		String customer2 = "Sune Olsson";
		String customer3 = "Pelle Svensson";
		AirPlane a1 = new AirPlane("CCN000001", 5, 5, AirPlaneStatus.HANGAR);
		AirPlane a2 = new AirPlane("CCN000002", 5, 5, AirPlaneStatus.HANGAR);
		AirPlane a3 = new AirPlane("CCN000003", 5, 5, AirPlaneStatus.HANGAR);

		LocalDateTime dateTime1 = LocalDateTime.parse("2017-11-25 12:30", formatter);
		LocalDateTime dateTime2 = LocalDateTime.parse("2017-11-25 12:30", formatter);
		LocalDateTime dateTime3 = LocalDateTime.parse("2017-11-25 12:30", formatter);
		
		Departure d1 = new Departure("DDD001", dateTime1, "London", a1.getAirPlaneID(), 20000, 5000);
		Departure d2 = new Departure("DDD002", dateTime2, "London", a2.getAirPlaneID(), 20000, 5000);
		Departure d3 = new Departure("DDD003", dateTime3, "London", a3.getAirPlaneID(), 20000, 5000);
		
		HashMap<String, Reservation> newReservationList = new HashMap<String, Reservation>();
		
		try {
			reservationHandler.addReservation("RRR001", dateTime1, customer1, d1, TicketType.FIRSTCLASS, 200000);
			reservationHandler.addReservation("RRR002", dateTime2, customer2, d2, TicketType.ECONOMYCLASS, 5000);
			reservationHandler.addReservation("RRR003", dateTime3, customer3, d3, TicketType.FIRSTCLASS, 200000);
			
		} catch (ReservationAlreadyExistInListException e) {
			System.out.println("ReservationAlreadyExistInListException");
			e.printStackTrace();
		}
		
		HashMap<String, Reservation> result = reservationHandler.getReservationList();
		
		assertTrue(result.size()==3);
		
		ReservationListHandler reservationHandler2 = new ReservationListHandler();
		
		reservationHandler2.setReservationList(result);
		
		assertTrue(reservationHandler2.size()==3);
	}

	@Test
	void testSetPrefixReservationID() {
		ReservationListHandler reservationHandler = new ReservationListHandler();
		reservationHandler.setPrefixReservationID("TTT000");
		System.out.println("New Prefix: " + reservationHandler.getPrefixReservationID());
		assertTrue(reservationHandler.getPrefixReservationID().equals("TTT000"));
	}

}
