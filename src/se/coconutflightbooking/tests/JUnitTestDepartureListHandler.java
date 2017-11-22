package se.coconutflightbooking.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import se.coconutflightbooking.AirPlane;
import se.coconutflightbooking.AirPlaneStatus;
import se.coconutflightbooking.Departure;
import se.coconutflightbooking.DepartureListHandler;
import se.coconutflightbooking.exceptions.DepartureAlreadyExistInListException;
import se.coconutflightbooking.exceptions.DepartureNotFoundException;

class JUnitTestDepartureListHandler {

	
	@Test
	void testNextDepartureIdGenerator() {
		System.out.println("Test NextDepartureIdGenerator():");
		
		DepartureListHandler departureListHandler = new DepartureListHandler();
		
		AirPlane a1 = new AirPlane("CCN000001", 5, 5, AirPlaneStatus.HANGAR);
		AirPlane a2 = new AirPlane("CCN000002", 5, 5, AirPlaneStatus.HANGAR);
		AirPlane a3 = new AirPlane("CCN000003", 5, 5, AirPlaneStatus.HANGAR);
				
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");	// Använd denna istället: DateTimeFormatter.ISO_LOCAL_DATE
		
		LocalDateTime dateTime1 = LocalDateTime.parse("2017-11-25 12:30", formatter);
		LocalDateTime dateTime2 = LocalDateTime.parse("2017-11-25 16:30", formatter);
		LocalDateTime dateTime3 = LocalDateTime.parse("2017-11-25 17:30", formatter);
		LocalDateTime dateTime4 = LocalDateTime.parse("2017-11-25 18:30", formatter);
		
		departureListHandler.addDeparture(dateTime1, "London", a1, 20000, 5000);
		departureListHandler.addDeparture(dateTime2, "Bombay", a2, 20000, 5000);
		departureListHandler.addDeparture(dateTime3, "Panama", a3, 20000, 5000);
		departureListHandler.addDeparture(dateTime4, "New York", a1, 20000, 5000);
		
		String newName = departureListHandler.getNextUniqueDepartureID();
		System.out.println("Nytt namn: " + newName);
		assertTrue(newName.equals("DDD005"));
		
		Departure d5 = new Departure("DDD005", dateTime4, "Sidney", a1, 20000, 5000);
		
		try {
			departureListHandler.addDeparture(d5);
		} catch (DepartureAlreadyExistInListException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		newName = departureListHandler.getNextUniqueDepartureID();
		System.out.println("Nytt namn: " + newName);
		assertTrue(newName.equals("DDD006"));
	}
	

	
	@Test
	void testAddDeparture1() {
		System.out.println("Test AddDeparture1():");
		DepartureListHandler departureListHandler = new DepartureListHandler();
		
		AirPlane a1 = new AirPlane("CCN000001", 5, 5, AirPlaneStatus.HANGAR);
		AirPlane a2 = new AirPlane("CCN000002", 5, 5, AirPlaneStatus.HANGAR);
			
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");	// Använd denna istället: DateTimeFormatter.ISO_LOCAL_DATE
		
		LocalDateTime dateTime1 = LocalDateTime.parse("2017-11-25 12:30", formatter);
		LocalDateTime dateTime2 = LocalDateTime.parse("2017-11-25 16:30", formatter);
		
		Departure d1 = new Departure("DDD001", dateTime1, "London", a1, 20000, 5000);
		Departure d2 = new Departure("DDD002", dateTime2, "New York", a2, 20000, 5000);		
		
		try {
			assertTrue(departureListHandler.addDeparture(d1));
			assertTrue(departureListHandler.addDeparture(d2));
		} catch (DepartureAlreadyExistInListException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	void testAddDeparture2() {
		System.out.println("Test AddDeparture2():");
		DepartureListHandler departureListHandler = new DepartureListHandler();
		
		AirPlane a1 = new AirPlane("CCN000001", 5, 5, AirPlaneStatus.HANGAR);
		AirPlane a2 = new AirPlane("CCN000002", 5, 5, AirPlaneStatus.HANGAR);
		AirPlane a3 = new AirPlane("CCN000003", 5, 5, AirPlaneStatus.HANGAR);
			
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");	// Använd denna istället: DateTimeFormatter.ISO_LOCAL_DATE
		
		LocalDateTime dateTime1 = LocalDateTime.parse("2017-11-25 12:30", formatter);
		LocalDateTime dateTime2 = LocalDateTime.parse("2017-11-25 16:30", formatter);
		LocalDateTime dateTime3 = LocalDateTime.parse("2017-11-25 17:30", formatter);
		LocalDateTime dateTime4 = LocalDateTime.parse("2017-11-25 18:30", formatter);
			
		assertTrue(departureListHandler.addDeparture(dateTime1, "London", a1, 20000, 5000));
		assertTrue(departureListHandler.addDeparture(dateTime2, "Bombay", a2, 20000, 5000));
		assertTrue(departureListHandler.addDeparture(dateTime3, "Panama", a3, 20000, 5000));
		assertTrue(departureListHandler.addDeparture(dateTime4, "New York", a1, 20000, 5000));

	}
	
	@Test
	void testAddDeparture3() {
		System.out.println("Test AddDeparture3():");
		DepartureListHandler departureListHandler = new DepartureListHandler();
		
		AirPlane a1 = new AirPlane("CCN000001", 5, 5, AirPlaneStatus.HANGAR);
		AirPlane a2 = new AirPlane("CCN000002", 5, 5, AirPlaneStatus.HANGAR);
		AirPlane a3 = new AirPlane("CCN000003", 5, 5, AirPlaneStatus.HANGAR);
			
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");	// Använd denna istället: DateTimeFormatter.ISO_LOCAL_DATE
		
		LocalDateTime dateTime1 = LocalDateTime.parse("2017-11-25 12:30", formatter);
		LocalDateTime dateTime2 = LocalDateTime.parse("2017-11-25 16:30", formatter);
		LocalDateTime dateTime3 = LocalDateTime.parse("2017-11-25 17:30", formatter);
		LocalDateTime dateTime4 = LocalDateTime.parse("2017-11-25 18:30", formatter);
			
		try {
			assertTrue(departureListHandler.addDeparture("DDD001", dateTime1, "London", a1, 20000, 5000));
			assertTrue(departureListHandler.addDeparture("DDD002",dateTime2, "Bombay", a2, 20000, 5000));
			assertTrue(departureListHandler.addDeparture("DDD003",dateTime3, "Panama", a3, 20000, 5000));
			assertTrue(departureListHandler.addDeparture("DDD004",dateTime4, "New York", a1, 20000, 5000));
		} catch (DepartureAlreadyExistInListException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Test
	void testGetDeparture() {
		System.out.println("Test GetDeparture():");
		DepartureListHandler departureListHandler = new DepartureListHandler();
		
		AirPlane a1 = new AirPlane("CCC000001", 5, 5, AirPlaneStatus.HANGAR);
		AirPlane a2 = new AirPlane("CCC000001", 5, 5, AirPlaneStatus.HANGAR);
		AirPlane a3 = new AirPlane("CCC000001", 5, 5, AirPlaneStatus.HANGAR);
				
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");	// Använd denna istället: DateTimeFormatter.ISO_LOCAL_DATE
		
		LocalDateTime dateTime1 = LocalDateTime.parse("2017-11-25 12:30", formatter);
		LocalDateTime dateTime2 = LocalDateTime.parse("2017-11-25 16:30", formatter);
		LocalDateTime dateTime3 = LocalDateTime.parse("2017-11-25 17:30", formatter);
		LocalDateTime dateTime4 = LocalDateTime.parse("2017-11-25 18:30", formatter);
			
		departureListHandler.addDeparture(dateTime1, "London", a1, 20000, 5000);
		departureListHandler.addDeparture(dateTime2, "Bombay", a2, 20000, 5000);
		departureListHandler.addDeparture(dateTime3, "Panama", a3, 20000, 5000);
		departureListHandler.addDeparture(dateTime4, "New York", a1, 20000, 5000);
		
		Departure d2 = new Departure("DDD002", dateTime2, "Bombay", a2, 20000, 5000);
		
		try {
			Departure test = departureListHandler.getDeparture("DDD002");
			System.out.println(test);
			System.out.println(d2);
			assertTrue(test.equals(d2));
			
		} catch (DepartureNotFoundException e) {
			System.out.println("DepartureNotFoundException");
			fail("DepartureNotFoundException");
			e.printStackTrace();
		}
	}

	@Test
	void testGetDepartureList() {
		System.out.println("Test getDepartureList():");
		//HashMap<String, Departure> departureList = new HashMap<String, Departure>();
		DepartureListHandler departureListHandler = new DepartureListHandler();
		
		AirPlane a1 = new AirPlane("CCC000001", 5, 5, AirPlaneStatus.HANGAR);
		AirPlane a2 = new AirPlane("CCC000001", 5, 5, AirPlaneStatus.HANGAR);
		AirPlane a3 = new AirPlane("CCC000001", 5, 5, AirPlaneStatus.HANGAR);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");	// Använd denna istället: DateTimeFormatter.ISO_LOCAL_DATE
		
		LocalDateTime dateTime1 = LocalDateTime.parse("2017-11-25 12:30", formatter);
		LocalDateTime dateTime2 = LocalDateTime.parse("2017-11-25 16:30", formatter);
		LocalDateTime dateTime3 = LocalDateTime.parse("2017-11-25 17:30", formatter);
		LocalDateTime dateTime4 = LocalDateTime.parse("2017-11-25 18:30", formatter);
		
		
		departureListHandler.addDeparture(dateTime1, "London", a1, 20000, 5000);
		departureListHandler.addDeparture(dateTime2, "Bombay", a2, 20000, 5000);
		departureListHandler.addDeparture(dateTime3, "Panama", a3, 20000, 5000);
		departureListHandler.addDeparture(dateTime4, "New York", a1, 20000, 5000);
			
		HashMap<String, Departure> departureList = departureListHandler.getDepartureList();
		
		assertTrue(departureList.size() == departureListHandler.size());
		
		for(Departure departureObject : departureList.values()) {
			System.out.println(departureObject);
		}
	}

	@Test
	void testSetDepartureList() {
		System.out.println("Test setDepartureList():");
		HashMap<String, Departure> departureList = new HashMap<String, Departure>();
		DepartureListHandler departureListHandler = new DepartureListHandler();
		
		AirPlane a1 = new AirPlane("CCC000001", 5, 5, AirPlaneStatus.HANGAR);
		AirPlane a2 = new AirPlane("CCC000001", 5, 5, AirPlaneStatus.HANGAR);
		AirPlane a3 = new AirPlane("CCC000001", 5, 5, AirPlaneStatus.HANGAR);
				
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");	// Använd denna istället: DateTimeFormatter.ISO_LOCAL_DATE
		
		LocalDateTime dateTime1 = LocalDateTime.parse("2017-11-25 12:30", formatter);
		LocalDateTime dateTime2 = LocalDateTime.parse("2017-11-25 16:30", formatter);
		LocalDateTime dateTime3 = LocalDateTime.parse("2017-11-25 17:30", formatter);
		LocalDateTime dateTime4 = LocalDateTime.parse("2017-11-25 18:30", formatter);
		
		Departure d1 = new Departure("DDD001", dateTime1, "London", a1, 20000, 5000);
		Departure d2 = new Departure("DDD002", dateTime2, "Bombay", a2, 20000, 5000);
		Departure d3 = new Departure("DDD003", dateTime3, "Panama", a3, 20000, 5000);
		Departure d4 = new Departure("DDD004", dateTime4, "New York", a1, 20000, 5000);
		
		
		departureList.put(d1.getDepartureID(), d1);
		departureList.put(d2.getDepartureID(), d2);
		departureList.put(d3.getDepartureID(), d3);
		departureList.put(d4.getDepartureID(), d4);
		
		
		assertTrue(departureListHandler.setDepartureList(departureList));

		//System.out.println(departureListHandler);
	}

	@Test
	void testSize() {
		
		System.out.println("Test size():");
		DepartureListHandler departureList = new DepartureListHandler();
		int testSize1 = departureList.size();
		
		System.out.println("Antal departures före: " + testSize1);
		
		assertTrue(testSize1==0);

		AirPlane a1 = new AirPlane("CCC000001", 5, 5, AirPlaneStatus.HANGAR);
		AirPlane a2 = new AirPlane("CCC000001", 5, 5, AirPlaneStatus.HANGAR);
		AirPlane a3 = new AirPlane("CCC000001", 5, 5, AirPlaneStatus.HANGAR);
				
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");	// Använd denna istället: DateTimeFormatter.ISO_LOCAL_DATE
		
		LocalDateTime dateTime1 = LocalDateTime.parse("2017-11-25 12:30", formatter);
		LocalDateTime dateTime2 = LocalDateTime.parse("2017-11-25 16:30", formatter);
		LocalDateTime dateTime3 = LocalDateTime.parse("2017-11-25 17:30", formatter);
		LocalDateTime dateTime4 = LocalDateTime.parse("2017-11-25 18:30", formatter);
		
		Departure d1 = new Departure("CNN001", dateTime1, "London", a1, 20000, 5000);
		Departure d2 = new Departure("CNN002", dateTime2, "Bombay", a2, 20000, 5000);
		Departure d3 = new Departure("CNN003", dateTime3, "Panama", a3, 20000, 5000);
		Departure d4 = new Departure("CNN004", dateTime4, "New York", a1, 20000, 5000);
		
		try {
			departureList.addDeparture(d1);
			departureList.addDeparture(d2);
			departureList.addDeparture(d3);
			departureList.addDeparture(d4);
			
		} catch (DepartureAlreadyExistInListException e) {
			System.out.println("DepartureAlreadyExistInListException");
			e.printStackTrace();
		}
		
		int testSize = departureList.size();
		
		System.out.println("Antal departures efter: " + testSize);
		
		assertTrue(testSize==4);
		
		
	}

	@Test
	void testRemoveDepartureFromList() {
		System.out.println("Test testRemoveDepartureFromList():");
		DepartureListHandler departureList = new DepartureListHandler();
		
		AirPlane a1 = new AirPlane("CCC000001", 5, 5, AirPlaneStatus.HANGAR);
		AirPlane a2 = new AirPlane("CCC000001", 5, 5, AirPlaneStatus.HANGAR);
		AirPlane a3 = new AirPlane("CCC000001", 5, 5, AirPlaneStatus.HANGAR);
				
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");	// Använd denna istället: DateTimeFormatter.ISO_LOCAL_DATE
		
		LocalDateTime dateTime1 = LocalDateTime.parse("2017-11-25 12:30", formatter);
		LocalDateTime dateTime2 = LocalDateTime.parse("2017-11-25 16:30", formatter);
		LocalDateTime dateTime3 = LocalDateTime.parse("2017-11-25 17:30", formatter);
		LocalDateTime dateTime4 = LocalDateTime.parse("2017-11-25 18:30", formatter);
		
		Departure d1 = new Departure("CNN001", dateTime1, "London", a1, 20000, 5000);
		Departure d2 = new Departure("CNN002",dateTime2, "Bombay", a2, 20000, 5000);
		Departure d3 = new Departure("CNN003",dateTime3, "Panama", a3, 20000, 5000);
		Departure d4 = new Departure("CNN004",dateTime4, "New York", a1, 20000, 5000);
		
		try {
			departureList.addDeparture(d1);
			departureList.addDeparture(d2);
			departureList.addDeparture(d3);
			departureList.addDeparture(d4);
			
		} catch (DepartureAlreadyExistInListException e) {
			System.out.println("DepartureAlreadyExistInListException");
			e.printStackTrace();
		}
			
		System.out.println(departureList);
		
		try {
			//Boolean result = departureList.removeDepartureFromList(d2);
			assertTrue(departureList.removeDepartureFromList(d2));
		} catch (DepartureNotFoundException e) {
			System.out.println("DepartureNotFoundException");
			fail("DepartureNotFoundException");
			e.printStackTrace();
		}
		
		System.out.println(departureList);
		
		
		
	}

}
