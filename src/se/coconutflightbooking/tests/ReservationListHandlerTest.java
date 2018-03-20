package se.coconutflightbooking.tests;

import se.coconutflightbooking.*;
import se.coconutflightbooking.exceptions.ReservationAlreadyExistInListException;
import se.coconutflightbooking.exceptions.ReservationNotFoundException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ReservationListHandlerTest {

    @org.junit.jupiter.api.Test
    void getReservation() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");	// Anv�nd denna ist�llet: DateTimeFormatter.ISO_LOCAL_DATE

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

    @org.junit.jupiter.api.Test
    void getNextUniqueReservationID() {
        ReservationListHandler reservationHandler = new ReservationListHandler();
        String newReservationID = reservationHandler.getNextUniqueReservationID();
        System.out.println("Next unique Reservation ID: " + newReservationID);
        assertTrue(newReservationID.equals("RRR001"));
    }

    @org.junit.jupiter.api.Test
    void reservationIdExistInList() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");	// Anv�nd denna ist�llet: DateTimeFormatter.ISO_LOCAL_DATE

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

    @org.junit.jupiter.api.Test
    void addReservation() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");	// Anv�nd denna ist�llet: DateTimeFormatter.ISO_LOCAL_DATE

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

    @org.junit.jupiter.api.Test
    void addReservation1() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");	// Anv�nd denna ist�llet: DateTimeFormatter.ISO_LOCAL_DATE

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

		/*
		assertThrows(ReservationAlreadyExistInListException.class,
	            ()->{
	            	reservationHandler.addReservation("RRR003", dateTime3, customer3, d3, TicketType.FIRSTCLASS, 200000);

	            //do whatever you want to do here
	            //ex : objectName.thisMethodShoulThrowNullPointerExceptionForNullParameter(null);
	            });
		*/


        //assertTrue(reservationHandler.reservationIdExistInList("RRR002"));
        //assertFalse(reservationHandler.reservationIdExistInList("RRR0"));
    }

    @org.junit.jupiter.api.Test
    void addReservation2() {
    }

    @org.junit.jupiter.api.Test
    void size() {
    }

    @org.junit.jupiter.api.Test
    void getReservationList() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");	// Anv�nd denna ist�llet: DateTimeFormatter.ISO_LOCAL_DATE

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

    @org.junit.jupiter.api.Test
    void setReservationList() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");	// Anv�nd denna ist�llet: DateTimeFormatter.ISO_LOCAL_DATE

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

    @org.junit.jupiter.api.Test
    void getPrefixReservationID() {
    }

    @org.junit.jupiter.api.Test
    void setPrefixReservationID() {
        ReservationListHandler reservationHandler = new ReservationListHandler();
        reservationHandler.setPrefixReservationID("TTT000");
        System.out.println("New Prefix: " + reservationHandler.getPrefixReservationID());
        assertTrue(reservationHandler.getPrefixReservationID().equals("TTT000"));
        assertTrue(reservationHandler.getPrefixReservationID().equals("TTT000"));
    }
}