package se.coconutflightbooking.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;


import se.coconutflightbooking.AirPlane;
import se.coconutflightbooking.AirPlaneStatus;
import se.coconutflightbooking.Departure;
import se.coconutflightbooking.FoodMenuItem;
import se.coconutflightbooking.FoodOrderItem;
import se.coconutflightbooking.Reservation;
import se.coconutflightbooking.TicketType;

public class OurDatabasConnection {
	private Connection conn = null;
	private PreparedStatement pstm = null;
	//private Statement stm = null;
	//private ResultSet rs = null;
	
	public OurDatabasConnection() {
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		}
		catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		
		
		/*
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
				
		}
		catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException");
			System.out.println(e);
		}
		
		try {
			this.conn = DriverManager.getConnection("jdbc:derby://localhost:50000/library");
		}
		catch (SQLException e) {
			System.out.println("SQLException");
			System.out.println(e);
		}	
		*/
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		
		OurDatabasConnection dbConnection = new OurDatabasConnection();
		
		
		/*
		
		//String sql = "Select * from MYTABLE";
		for(int i=0;i<10;i++) {
			
			dbConnection.addData("CCC00000"+ (i), "Niklas" + i, 5, 5, "HANGAR","AIRPLANES");
		}
		*/
		//String sql = "Select * from \"USER\".\"AIRPLANES\"";
		//HashMap<String, HashMap<String, String>> result = dbConnection.retrieveResultSet(sql);
		
		
		HashMap<String, Departure> departureList = dbConnection.getDepartures(); 
		
		for(Departure departure : departureList.values()) {
			System.out.println(departure);
		}
		
		
		HashMap<String, AirPlane> airPlaneList = dbConnection.getAirPlanes(); 
		
		for(AirPlane plane : airPlaneList.values()) {
			System.out.println(plane);
		}
		
		
		HashMap<String, FoodMenuItem> foodMenuList = dbConnection.getFoodMenu(); 
		
		for(FoodMenuItem foodMenuItem : foodMenuList.values()) {
			System.out.println(foodMenuItem);
		}
		
		HashMap<String, Reservation> reservationList = dbConnection.getReservations(); 
		
		for(Reservation reservationItem : reservationList.values()) {
			System.out.println(reservationItem);
		}
		
		HashMap<String, FoodOrderItem> foodorderList = dbConnection.getFoodOrders(); 
		
		for(FoodOrderItem foodorderItem : foodorderList.values()) {
			System.out.println(foodorderItem);
		}
	}
	
	public HashMap<String, AirPlane> getAirPlanes(){
		HashMap<String, AirPlane> airPlaneList = new HashMap<String, AirPlane>(); 
		String sql = "Select * from \"USER\".\"AIRPLANES\"";
		try {		
			try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:50000/Coconut")) {
				//System.out.println("Connection");
				try(Statement stm = conn.createStatement()){
					//System.out.println("Statement");
					try(ResultSet rs = stm.executeQuery(sql)){
						//System.out.println("ResultSet:" + sql + " rader:" + rs.getFetchSize());
						while (rs.next()) {
							String airPlaneID = rs.getString("PLANE_ID");
							String name = rs.getString("name");
							Integer economic_seat_amount = rs.getInt("ECONOMIC_SEAT_AMOUNT");
							Integer firstclass_seat_amount = rs.getInt("FIRSTCLASS_SEAT_AMOUNT");
							AirPlaneStatus status =AirPlaneStatus.valueOf(rs.getString("STATUS"));
							
							AirPlane airplane = new AirPlane(airPlaneID, name, economic_seat_amount, firstclass_seat_amount, status);
														
							//System.out.println(airPlaneID + " " + name + " " + economic_seat_amount + " " + firstclass_seat_amount + " " + status);
							airPlaneList.put(airPlaneID, airplane);
						}	
					}
					finally {
						if (stm != null) stm.close();
						if (conn != null) conn.close();
						return airPlaneList;
					}
				}
			}	
		}
		catch (SQLException e) {

			System.out.println("Something went wrong");
			System.out.println(e);
		}
		return null;
	}
	
	public HashMap<String, Departure> getDepartures(){
		HashMap<String, Departure> departureList = new HashMap<String, Departure>(); 
		String sql = "SELECT * FROM \"USER\".\"DEPARTURES\""; // SELECT * FROM "USER"."DEPARTURES";
		try {		
			try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:50000/Coconut")) {
				try(Statement stm = conn.createStatement()){
					try(ResultSet rs = stm.executeQuery(sql)){						
						while (rs.next()) {
							String departureID = rs.getString("DEPARTURE_ID");
							String departureDateTime = rs.getString("DEPARTURE_DATETIME").substring(0, 19);
							String airPlaneID = rs.getString("AIRPLANE_ID");
							String destination = rs.getString("DESTINATION");
							Integer economicTicketPrice = rs.getInt("ECONOMIC_TICKET_PRICE");
							Integer firstClassTicketPrice = rs.getInt("FIRSTCLASS_TICKET_PRICE");
							
							DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");	// Använd denna istället: DateTimeFormatter.ISO_LOCAL_DATE
							LocalDateTime dateTime = LocalDateTime.parse(departureDateTime, formatter);
							
							Departure departure = new Departure(departureID, dateTime, destination, airPlaneID,  firstClassTicketPrice, economicTicketPrice);
														
							departureList.put(departureID, departure);
						}	
					}
					finally {
						if (stm != null) stm.close();
						if (conn != null) conn.close();
						return departureList;
					}
				}
			}	
		}
		catch (SQLException e) {

			System.out.println("Something went wrong");
			System.out.println(e);
		}
		return null;
	}
	
	
	public HashMap<String, FoodMenuItem> getFoodMenu(){
		HashMap<String, FoodMenuItem> foodMenuList = new HashMap<String, FoodMenuItem>(); 
		String sql = "Select * from \"USER\".\"FOODMENU\"";
		try {		
			try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:50000/Coconut")) {
				try(Statement stm = conn.createStatement()){
					try(ResultSet rs = stm.executeQuery(sql)){
						while (rs.next()) {
							String foodMenuID = rs.getString("FOODMENU_ID");
							String name = rs.getString("NAME");
							Integer price = rs.getInt("PRICE");
							boolean isFirstClass = rs.getBoolean("IS_FIRSTCLASS");
						
							FoodMenuItem foodMenuItem = new FoodMenuItem(foodMenuID, name, price, isFirstClass);
														
							foodMenuList.put(foodMenuID, foodMenuItem);
						}	
					}
					finally {
						if (stm != null) stm.close();
						if (conn != null) conn.close();
						return foodMenuList;
					}
				}
			}	
		}
		catch (SQLException e) {

			System.out.println("Something went wrong");
			System.out.println(e);
		}
		return null;
	}
	
	
	public HashMap<String, Reservation> getReservations(){
		HashMap<String, Reservation> reservationList = new HashMap<String, Reservation>(); 
		String sql = "Select * from \"USER\".\"RESERVATIONS\"";
		try {		
			try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:50000/Coconut")) {
				try(Statement stm = conn.createStatement()){
					try(ResultSet rs = stm.executeQuery(sql)){
						while (rs.next()) {
							String reservationID = rs.getString("RESERVATION_ID");
							String reservationDateTime = rs.getString("RESERVATION_DATETIME").substring(0, 19);
							String customerName = rs.getString("CUSTOMER_NAME");
							String departureId = rs.getString("DEPARTURE_ID");
							TicketType ticketType = TicketType.valueOf(rs.getString("TICKET_TYPE"));
							Integer ticketCost = rs.getInt("COST");
														
							DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");	// Använd denna istället: DateTimeFormatter.ISO_LOCAL_DATE
							LocalDateTime dateTime = LocalDateTime.parse(reservationDateTime, formatter);
							
							Reservation reservation = new Reservation(reservationID, dateTime,  customerName, departureId, ticketType, ticketCost);
							
							reservationList.put(reservationID, reservation);
						}	
					}
					finally {
						if (stm != null) stm.close();
						if (conn != null) conn.close();
						return reservationList;
					}
				}
			}	
		}
		catch (SQLException e) {

			System.out.println("Something went wrong");
			System.out.println(e);
		}
		return null;
	}
	
	
	public HashMap<String, FoodOrderItem> getFoodOrders(){
		HashMap<String, FoodOrderItem> foodOrderList = new HashMap<String, FoodOrderItem>(); 
		String sql = "Select * from \"USER\".\"FOODORDER\"";
		try {		
			try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:50000/Coconut")) {
				try(Statement stm = conn.createStatement()){
					try(ResultSet rs = stm.executeQuery(sql)){
						while (rs.next()) {
							String foodorderID = rs.getString("FOODORDER_ID");
							String reservationID = rs.getString("RESERVATION_ID");
							String foodMenuId = rs.getString("FOODMENU_ID");
							boolean isFirstClass = rs.getBoolean("IS_FIRSTCLASS");
							Integer cost = rs.getInt("COST");								
							
							FoodOrderItem foodorder = new FoodOrderItem(foodorderID, reservationID, foodMenuId, isFirstClass, cost);
							
							foodOrderList.put(foodorderID, foodorder);
						}	
					}
					finally {
						if (stm != null) stm.close();
						if (conn != null) conn.close();
						return foodOrderList;
					}
				}
			}	
		}
		catch (SQLException e) {

			System.out.println("Something went wrong");
			System.out.println(e);
		}
		return null;
	}
	
	private void createTable() {
		
	}
	
	
	public void removeData(String sql, String title, int id) {
		
			try {
				//Class.forName("org.apache.derby.jdbc.ClientDriver");
				//this.conn = DriverManager.getConnection("jdbc:derby://localhost/library");
				this.pstm = this.conn.prepareStatement(sql);
				this.pstm.setString(1,title);
				this.pstm.setInt(2, id);
				
				int results = this.pstm.executeUpdate();
				System.out.println("Records amended: " + results);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			finally {
				
				if (this.pstm != null)
					try {
						this.pstm.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				if (this.conn != null)
					try {
						this.conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
	
	}
	
	public void addData(String airPlaneID, String name, int economicSeatAmount, int firstClassSeatAmount, String status, String tableName) {
		Connection conn = null;
		PreparedStatement pstm = null;
		//title = "Niklas234324";
		String sql = "insert into "+ tableName + " (PLANE_ID, NAME, ECONOMIC_SEAT_AMOUNT, FIRSTCLASS_SEAT_AMOUNT, STATUS) values (?,?,?,?,?)";
		
		try { 

			try {
				
				conn = DriverManager.getConnection("jdbc:derby://localhost:50000/test");
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, airPlaneID);
				pstm.setString(2, name);
				pstm.setInt(3, economicSeatAmount);
				pstm.setInt(4, firstClassSeatAmount);
				pstm.setString(5, status);
				
				int results = pstm.executeUpdate();
				System.out.println("Records amended: " + results);
				
			} 
			finally {
				
				if (pstm != null) pstm.close();
				if (conn != null) conn.close();
			}
		}

		catch (SQLException e) {

			System.out.println("Something went wrong");
			System.out.println(e);
		}
	}
	
	/*
	public void ChangeData(String sql, String title, int id) {

		try {

			try {
				this.conn = DriverManager.getConnection("jdbc:derby://localhost:50000/library");
				this.pstm = this.conn.prepareStatement(sql);
				this.pstm.setString(1,title);
				this.pstm.setInt(2, id);
				
				int results = this.pstm.executeUpdate();
				System.out.println("Records amended: " + results);
				
			}
			finally {
				
				if (this.pstm != null) this.stm.close();
				if (this.conn != null) this.conn.close();
			}
		}
		catch (SQLException e) {

			System.out.println("Something went wrong");
			System.out.println(e);
		}
	}
	*/
	
	public HashMap<String, HashMap<String, String>> retrieveResultSet (String sql) {
		//HashMap<String,String> retrieveMap = new HashMap<String, String>();
		HashMap<String, HashMap<String, String>> retrieveMap = new HashMap<String, HashMap<String, String>>();
		
		//ArrayList <String, ArrayList<String>> minArray = new ArrayList<String, ArrayList<String>>();
		try {
			//Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
			
			try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:50000/Coconut")) {
				try(Statement stm = conn.createStatement()){
					try(ResultSet rs = stm.executeQuery(sql)){
						while (rs.next()) {
							HashMap<String, String> row = new HashMap<String, String>();
							row.put("PLANE_ID", rs.getString("PLANE_ID"));
							row.put("name", rs.getString("name"));
							row.put("ECONOMIC_SEAT_AMOUNT", rs.getString("ECONOMIC_SEAT_AMOUNT"));
							row.put("FIRSTCLASS_SEAT_AMOUNT", rs.getString("FIRSTCLASS_SEAT_AMOUNT"));
							row.put("STATUS", rs.getString("STATUS"));
							
							System.out.println(rs.getString("PLANE_ID") + " " + rs.getString("name") + " " + rs.getString("ECONOMIC_SEAT_AMOUNT") + " " + rs.getString("FIRSTCLASS_SEAT_AMOUNT") + " " + rs.getString("STATUS"));
							retrieveMap.put(rs.getString("PLANE_ID"), row);
						}	
					}
					finally {
						return retrieveMap;
					}
				}
			}	
		}
		catch (SQLException e) {

			System.out.println("Something went wrong");
			System.out.println(e);
		}
		return null;

	}
	
}
