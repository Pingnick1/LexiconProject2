package se.coconutflightbooking.tests;

import se.coconutflightbooking.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ReservationTest {

    @org.junit.jupiter.api.Test
    void getReservationDateTime() {
    }

    @org.junit.jupiter.api.Test
    void getDeparture() {
    }

    @org.junit.jupiter.api.Test
    void setDeparture() {
    }

    @org.junit.jupiter.api.Test
    void getCustomer() {
    }

    @org.junit.jupiter.api.Test
    void setCustomer() {
    }

    @org.junit.jupiter.api.Test
    void getReservationStatus() {
    }

    @org.junit.jupiter.api.Test
    void setReservationStatus() {
    }

    @org.junit.jupiter.api.Test
    void getTicketType() {
    }

    @org.junit.jupiter.api.Test
    void setTicketType() {
    }

    @org.junit.jupiter.api.Test
    void getTicketCost() {
    }

    @org.junit.jupiter.api.Test
    void setTicketCost() {
    }

    @org.junit.jupiter.api.Test
    void getReservationID() {
    }

    @org.junit.jupiter.api.Test
    void getterAndSetters() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");	// Anv�nd denna ist�llet: DateTimeFormatter.ISO_LOCAL_DATE

        AirPlane a1 = new AirPlane("CCN000001", 5, 5, AirPlaneStatus.HANGAR);
        AirPlane a2 = new AirPlane("CCN000002", 5, 5, AirPlaneStatus.HANGAR);

        LocalDateTime dateTime1 = LocalDateTime.parse("2017-11-25 12:30", formatter);
        LocalDateTime dateTime2 = LocalDateTime.parse("2017-11-27 12:30", formatter);

        LocalDateTime dateTime3 = LocalDateTime.parse("2017-11-25 12:30", formatter);

        Departure d1 = new Departure("", dateTime1, "London", a1.getAirPlaneID(), 20000,5000);
        Departure d2 = new Departure("", dateTime2, "Madrid", a2.getAirPlaneID(), 20000,5000);

        Reservation r1 = new Reservation("CCNB001", dateTime3, "Niklas Svensson", d1.getDepartureID(), TicketType.ECONOMYCLASS, 5000);
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
		r1.setDeparture(d2.getDepartureID());
		r1.setTicketCost(20000);
		r1.setTicketType(TicketType.FIRSTCLASS);
		r1.setCustomer("Lars �kesson");

        assertTrue(r1.getReservationID().equals("CCNB001"));
        assertTrue(r1.getReservationStatus() == ReservationStatus.USED);
        assertTrue(r1.getDeparture().equals(d2));
        assertTrue(r1.getTicketCost() == 20000);
        assertTrue(r1.getTicketType().equals(TicketType.FIRSTCLASS));
        assertTrue(r1.getCustomer().equals("Lars �kesson"));
		System.out.println(r1);
    }
}