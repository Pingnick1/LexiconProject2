package se.coconutflightbooking.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.coconutflightbooking.AirPlane;
import se.coconutflightbooking.AirPlaneStatus;
import se.coconutflightbooking.Departure;
import se.coconutflightbooking.FoodMenuItem;
import se.coconutflightbooking.FoodOrderItem;
import se.coconutflightbooking.Reservation;
import se.coconutflightbooking.database.CoconutFlightDBHandler;

class JUnitTestCoconutFlightDBHandler {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testConnection() {
		CoconutFlightDBHandler cFDBH = new CoconutFlightDBHandler();
		
		
		
		
	}
	
	@Test
	void testGetAirPlanes() {
		CoconutFlightDBHandler cFDBH = new CoconutFlightDBHandler();
		HashMap<String, AirPlane> airPlaneList = cFDBH.getAirPlanes();	
		
		assertTrue(airPlaneList.size()>0);
		
		System.out.println("Number of airplanes in list: " + airPlaneList.size());
		/*
		for(AirPlane plane : airPlaneList.values()) {
			System.out.println(plane);
		}
		*/
	}
	
	@Test
	void testGetDepartures() {
		CoconutFlightDBHandler cFDBH = new CoconutFlightDBHandler();
		
		// Collect Departure from DB
		HashMap<String, Departure> departureList = cFDBH.getDepartures(); 
				
		/*
		for(Departure departure : departureList.values()) {
			System.out.println(departure);
		}
		*/
		
		assertTrue(departureList.size()>0);
		
		System.out.println("Number of departure in list: " + departureList.size());
	}
	
	@Test
	void testGetFoodMenu() {
		CoconutFlightDBHandler cFDBH = new CoconutFlightDBHandler();

		// Collect FoodMenuItem from DB
		HashMap<String, FoodMenuItem> foodMenuList = cFDBH.getFoodMenu(); 
				
		/*
		for(FoodMenuItem foodMenuItem : foodMenuList.values()) {
					System.out.println(foodMenuItem);
		}
		*/
		
		assertTrue(foodMenuList.size()>0);
		
		System.out.println("Number of foodmenu items in list: " + foodMenuList.size());
	}
	
	@Test
	void testGetReservations() {
		CoconutFlightDBHandler cFDBH = new CoconutFlightDBHandler();

		// Collect Reservation from DB
		HashMap<String, Reservation> reservationList = cFDBH.getReservations(); 
				
		/*
		for(Reservation reservationItem : reservationList.values()) {
			System.out.println(reservationItem);
		}
		*/
		
		assertTrue(reservationList.size()>0);
		
		System.out.println("Number of reservations in list: " + reservationList.size());
	}
	
	@Test
	void testGetFoodOrders() {
		CoconutFlightDBHandler cFDBH = new CoconutFlightDBHandler();

		// Collect FoodOrderItem from DB
		HashMap<String, FoodOrderItem> foodOrderList = cFDBH.getFoodOrders(); 
				
		/*
		for(FoodOrderItem foodorderItem : foodorderList.values()) {
			System.out.println(foodorderItem);
		}
		*/
		
		assertTrue(foodOrderList.size()>0);
		
		System.out.println("Number of foodorders in list: " + foodOrderList.size());
	}
	
	@Test
	void testAddAirPlane() {
		CoconutFlightDBHandler cFDBH = new CoconutFlightDBHandler();

		// Collect FoodOrderItem from DB
		HashMap<String, AirPlane> airPlaneList = cFDBH.getAirPlanes(); 
		
		int sizeBefore = airPlaneList.size();
		System.out.println("Number of airplanes before adding: " + sizeBefore);
		
		AirPlane plane1 = new AirPlane("CCC00003", 5, 5, AirPlaneStatus.HANGAR);
		
		assertTrue(cFDBH.addAirPlane(plane1));
		
		airPlaneList = cFDBH.getAirPlanes(); 
		/*
		for(FoodOrderItem foodorderItem : foodorderList.values()) {
			System.out.println(foodorderItem);
		}
		*/
		int sizeAfter = airPlaneList.size();
		System.out.println("Number of airplanes after adding: " + sizeAfter);
		//assertTrue((sizeAfter - sizeBefore) == 1);
		
		
	}

}
