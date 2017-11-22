package se.coconutflightbooking.tests;

import static org.junit.jupiter.api.Assertions.*;

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
		
		
		Departure d1 = new Departure("DDD001", a1, 20000, 5000);
		Departure d2 = new Departure("DDD002", a2, 20000, 5000);
		Departure d3 = new Departure("DDD003", a3, 20000, 5000);
		Departure d4 = new Departure("DDD004", a1, 20000, 5000);
		
		try {
			departureListHandler.addDeparture(d1);
			departureListHandler.addDeparture(d2);
			departureListHandler.addDeparture(d3);
			departureListHandler.addDeparture(d4);
			
		} catch (DepartureAlreadyExistInListException e) {
			System.out.println("DepartureAlreadyExistInListException");
			e.printStackTrace();
		}
		
		
		String newName = departureListHandler.getNextUniqueDepartureID();
		System.out.println("Nytt namn: " + newName);
		assertTrue(newName.equals("DDD005"));
		
		Departure d5 = new Departure(newName, a1, 20000, 5000);
		
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
	void testAddDeparture() {
		DepartureListHandler departureListHandler = new DepartureListHandler();
		
		AirPlane a1 = new AirPlane("CCN000001", 5, 5, AirPlaneStatus.HANGAR);
		AirPlane a2 = new AirPlane("CCN000002", 5, 5, AirPlaneStatus.HANGAR);
		AirPlane a3 = new AirPlane("CCN000003", 5, 5, AirPlaneStatus.HANGAR);
		
		
		Departure d1 = new Departure("DDD000001", a1, 20000, 5000);
		Departure d2 = new Departure("DDD000002", a2, 20000, 5000);
		Departure d3 = new Departure("DDD000003", a3, 20000, 5000);
		Departure d4 = new Departure("DDD000004", a1, 20000, 5000);
		
		try {
			assertTrue(departureListHandler.addDeparture(d1));
			assertTrue(departureListHandler.addDeparture(d2));
			assertTrue(departureListHandler.addDeparture(d3));
			assertTrue(departureListHandler.addDeparture(d4));
			
		} catch (DepartureAlreadyExistInListException e) {
			System.out.println("DepartureAlreadyExistInListException");
			e.printStackTrace();
		}
	}
	
	
	@Test
	void testGetDeparture() {
		DepartureListHandler departureListHandler = new DepartureListHandler();
		
		AirPlane a1 = new AirPlane("CCC000001", 5, 5, AirPlaneStatus.HANGAR);
		AirPlane a2 = new AirPlane("CCC000001", 5, 5, AirPlaneStatus.HANGAR);
		AirPlane a3 = new AirPlane("CCC000001", 5, 5, AirPlaneStatus.HANGAR);
		
		
		Departure d1 = new Departure("DDD000001", a1, 20000, 5000);
		Departure d2 = new Departure("DDD000002", a2, 20000, 5000);
		Departure d3 = new Departure("DDD000003", a3, 20000, 5000);
		Departure d4 = new Departure("DDD000004", a1, 20000, 5000);
		
		try {
			departureListHandler.addDeparture(d1);
			departureListHandler.addDeparture(d2);
			departureListHandler.addDeparture(d3);
			departureListHandler.addDeparture(d4);
			
		} catch (DepartureAlreadyExistInListException e) {
			System.out.println("DepartureAlreadyExistInListException");
			e.printStackTrace();
		}
		
		try {
			Departure test = departureListHandler.getDeparture("DDD000002");
			
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
		
		
		Departure d1 = new Departure("DDD000001", a1, 20000, 5000);
		Departure d2 = new Departure("DDD000002", a2, 20000, 5000);
		Departure d3 = new Departure("DDD000003", a3, 20000, 5000);
		Departure d4 = new Departure("DDD000004", a1, 20000, 5000);
		
		
		try {
			departureListHandler.addDeparture(d1);
			departureListHandler.addDeparture(d2);
			departureListHandler.addDeparture(d3);
			departureListHandler.addDeparture(d4);
			
		} catch (DepartureAlreadyExistInListException e) {
			System.out.println("DepartureAlreadyExistInListException");
			e.printStackTrace();
		}
			
		HashMap<String, Departure> departureList = departureListHandler.getDepartureList();
		
		assertTrue(departureList.size() == departureListHandler.size());

		System.out.println(departureList);
	}

	@Test
	void testSetDepartureList() {
		System.out.println("Test setDepartureList():");
		HashMap<String, Departure> departureList = new HashMap<String, Departure>();
		DepartureListHandler departureListHandler = new DepartureListHandler();
		
		AirPlane a1 = new AirPlane("CCC000001", 5, 5, AirPlaneStatus.HANGAR);
		AirPlane a2 = new AirPlane("CCC000001", 5, 5, AirPlaneStatus.HANGAR);
		AirPlane a3 = new AirPlane("CCC000001", 5, 5, AirPlaneStatus.HANGAR);
		
		
		Departure d1 = new Departure("DDD000001", a1, 20000, 5000);
		Departure d2 = new Departure("DDD000002", a2, 20000, 5000);
		Departure d3 = new Departure("DDD000003", a3, 20000, 5000);
		Departure d4 = new Departure("DDD000004", a1, 20000, 5000);
		
		
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
		
		
		Departure d1 = new Departure("DDD000001", a1, 20000, 5000);
		Departure d2 = new Departure("DDD000002", a2, 20000, 5000);
		Departure d3 = new Departure("DDD000003", a3, 20000, 5000);
		Departure d4 = new Departure("DDD000004", a1, 20000, 5000);
		
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
		DepartureListHandler departureList = new DepartureListHandler();
		
		AirPlane a1 = new AirPlane("CCC000001", 5, 5, AirPlaneStatus.HANGAR);
		AirPlane a2 = new AirPlane("CCC000001", 5, 5, AirPlaneStatus.HANGAR);
		AirPlane a3 = new AirPlane("CCC000001", 5, 5, AirPlaneStatus.HANGAR);
		
		
		Departure d1 = new Departure("DDD000001", a1, 20000, 5000);
		Departure d2 = new Departure("DDD000002", a2, 20000, 5000);
		Departure d3 = new Departure("DDD000003", a3, 20000, 5000);
		Departure d4 = new Departure("DDD000004", a1, 20000, 5000);
		
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
