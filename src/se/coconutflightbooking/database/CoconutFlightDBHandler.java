package se.coconutflightbooking.database;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import se.coconutflightbooking.AirPlane;
import se.coconutflightbooking.AirPlaneStatus;
import se.coconutflightbooking.Departure;
import se.coconutflightbooking.FoodMenuItem;
import se.coconutflightbooking.FoodOrderItem;
import se.coconutflightbooking.Reservation;
import se.coconutflightbooking.TicketType;

public class CoconutFlightDBHandler extends OurDatabasConnection {

	public CoconutFlightDBHandler() {
		super("localhost", "50000", "Coconut");
		
	}
	

	public static void main(String[] args) {
		System.out.println("Hello World");
		
		CoconutFlightDBHandler dbConnection = new CoconutFlightDBHandler();

		// Collect and print Departure from DB
		HashMap<String, Departure> departureList = dbConnection.getDepartures(); 
		
		for(Departure departure : departureList.values()) {
			System.out.println(departure);
		}
		
				
		
		// Collect and print AirPlane from DB
		HashMap<String, AirPlane> airPlaneList = dbConnection.getAirPlanes(); 
		
		for(AirPlane plane : airPlaneList.values()) {
			System.out.println(plane);
		}
		
		// Collect and print FoodMenuItem from DB
		HashMap<String, FoodMenuItem> foodMenuList = dbConnection.getFoodMenu(); 
		
		for(FoodMenuItem foodMenuItem : foodMenuList.values()) {
			System.out.println(foodMenuItem);
		}
		
		
		// Collect and print Reservation from DB
		HashMap<String, Reservation> reservationList = dbConnection.getReservations(); 
		
		for(Reservation reservationItem : reservationList.values()) {
			System.out.println(reservationItem);
		}
		
		
		// Collect and print FoodOrderItem from DB
		HashMap<String, FoodOrderItem> foodorderList = dbConnection.getFoodOrders(); 
		
		for(FoodOrderItem foodorderItem : foodorderList.values()) {
			System.out.println(foodorderItem);
		}
		
	}
	
	
	
	public HashMap<String, AirPlane> getAirPlanes(){
		HashMap<String, AirPlane> airPlaneList = new HashMap<String, AirPlane>(); 
		String sql = "Select * from \"USER\".\"AIRPLANES\"";
		
		ArrayList<HashMap<String, Object>> rs = this.retrieveResult (sql);
		
		Iterator<HashMap<String, Object>> iterator = rs.iterator();
		
		while(iterator.hasNext()) {
			HashMap<String, Object> element = iterator.next();
			
			String airPlaneID = (String) element.get("PLANE_ID");
			String name = (String) element.get("name");
			Integer economic_seat_amount = (Integer) element.get("ECONOMIC_SEAT_AMOUNT");
			Integer firstclass_seat_amount = (Integer) element.get("FIRSTCLASS_SEAT_AMOUNT");
			AirPlaneStatus status = AirPlaneStatus.valueOf((String) element.get("STATUS"));
						
			AirPlane airplane = new AirPlane(airPlaneID, name, economic_seat_amount, firstclass_seat_amount, status);													
			airPlaneList.put(airPlaneID, airplane);
		}
		return airPlaneList;		
	}
	
	public HashMap<String, Departure> getDepartures(){
		HashMap<String, Departure> departureList = new HashMap<String, Departure>(); 
		String sql = "Select * from \"USER\".\"DEPARTURES\"";
		
		ArrayList<HashMap<String, Object>> rs = this.retrieveResult (sql);
		
		Iterator<HashMap<String, Object>> iterator = rs.iterator();
		
		while(iterator.hasNext()) {
			HashMap<String, Object> element = iterator.next();
			
			String departureID = (String) element.get("DEPARTURE_ID");
			String airPlaneID = (String) element.get("AIRPLANE_ID");
			String destination = (String) element.get("DESTINATION");
			Integer economicTicketPrice = (Integer) element.get("ECONOMIC_TICKET_PRICE");
			Integer firstClassTicketPrice = (Integer) element.get("FIRSTCLASS_TICKET_PRICE");
			
			//String departureDateTime = ((String) element.get("DEPARTURE_DATETIME")).substring(0, 19);
			Timestamp departureDateTime = (Timestamp) (element.get("DEPARTURE_DATETIME"));
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");	// Använd denna istället: DateTimeFormatter.ISO_LOCAL_DATE
			LocalDateTime dateTime = LocalDateTime.parse(departureDateTime.toString().substring(0, 19), formatter);
			
			Departure departure = new Departure(departureID, dateTime, destination, airPlaneID,  firstClassTicketPrice, economicTicketPrice);
										
			departureList.put(departureID, departure);
		}
		return departureList;		
	}
	
	public HashMap<String, FoodMenuItem> getFoodMenu(){
		HashMap<String, FoodMenuItem> foodMenuList = new HashMap<String, FoodMenuItem>(); 
		String sql = "Select * from \"USER\".\"FOODMENU\"";
		
		ArrayList<HashMap<String, Object>> rs = this.retrieveResult (sql);
		
		Iterator<HashMap<String, Object>> iterator = rs.iterator();
		
		while(iterator.hasNext()) {
			HashMap<String, Object> element = iterator.next();
						
			String foodMenuID = (String) element.get("FOODMENU_ID");
			String name = (String) element.get("NAME");
			Integer price = (Integer) element.get("PRICE");
			
			boolean isFirstClass = (boolean) element.get("IS_FIRSTCLASS");
		
			FoodMenuItem foodMenuItem = new FoodMenuItem(foodMenuID, name, price, isFirstClass);
										
			foodMenuList.put(foodMenuID, foodMenuItem);
			
		}
		return foodMenuList;		
	}
	
	public HashMap<String, Reservation> getReservations(){
		HashMap<String, Reservation> reservationList = new HashMap<String, Reservation>(); 
		String sql = "Select * from \"USER\".\"RESERVATIONS\"";
		
		ArrayList<HashMap<String, Object>> rs = this.retrieveResult (sql);
		
		Iterator<HashMap<String, Object>> iterator = rs.iterator();
		
		while(iterator.hasNext()) {
			HashMap<String, Object> element = iterator.next();
									
			String reservationID = (String) element.get("RESERVATION_ID");
			
			String customerName = (String) element.get("CUSTOMER_NAME");
			String departureId = (String) element.get("DEPARTURE_ID");
			TicketType ticketType = TicketType.valueOf(element.get("TICKET_TYPE").toString());
			Integer ticketCost = (Integer) element.get("COST");
				
			Timestamp reservationDateTime = (Timestamp) element.get("RESERVATION_DATETIME");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");	// Använd denna istället: DateTimeFormatter.ISO_LOCAL_DATE
			LocalDateTime dateTime = LocalDateTime.parse(reservationDateTime.toString().substring(0, 19), formatter);
			
			Reservation reservation = new Reservation(reservationID, dateTime,  customerName, departureId, ticketType, ticketCost);
			
			reservationList.put(reservationID, reservation);			
		}
		return reservationList;		
	}
	
	public HashMap<String, FoodOrderItem> getFoodOrders(){
		HashMap<String, FoodOrderItem> foodOrderList = new HashMap<String, FoodOrderItem>(); 
		String sql = "Select * from \"USER\".\"FOODORDER\"";
		
		ArrayList<HashMap<String, Object>> rs = this.retrieveResult (sql);
		
		Iterator<HashMap<String, Object>> iterator = rs.iterator();
		
		while(iterator.hasNext()) {
			HashMap<String, Object> element = iterator.next();
									
			
			String foodorderID = (String) element.get("FOODORDER_ID");
			String reservationID = (String) element.get("RESERVATION_ID");
			String foodMenuId = (String) element.get("FOODMENU_ID");
			boolean isFirstClass = (boolean) element.get("IS_FIRSTCLASS");
			Integer cost = (Integer) element.get("COST");								
			
			FoodOrderItem foodorder = new FoodOrderItem(foodorderID, reservationID, foodMenuId, isFirstClass, cost);
			
			foodOrderList.put(foodorderID, foodorder);
						
		}
		return foodOrderList;
	
	}
	

}
