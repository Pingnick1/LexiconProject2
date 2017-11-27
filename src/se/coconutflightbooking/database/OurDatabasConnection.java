package se.coconutflightbooking.database;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
	
	/*
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
	}*/
	
	
	
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
	
	
	/*
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
	*/
	
	
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
	
	/*
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
	*/
	
	
	
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
	
	/*
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
	*/
	
	
	
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
	
	/*
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
	*/
	
	
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
	
	public ArrayList<HashMap<String, Object>> retrieveResult (String sql) {
		Connection conn = null; 
		Statement stm = null; 
		ResultSet rs = null; 
		
		//ArrayList<ArrayList<Object>> returnArray = new ArrayList<ArrayList<Object>>();
		
		ArrayList<HashMap<String, Object>> returnArray = new ArrayList<HashMap<String, Object>>();
		
		int startColumn = 2;
		
		System.out.println(sql);
		
		try {	
			try {
				conn = DriverManager.getConnection("jdbc:derby://localhost:50000/Coconut");
				stm = conn.createStatement();
				rs = stm.executeQuery(sql);

				System.out.println("getTableName: " + rs.getMetaData().getTableName(1));		
				
				//System.out.println("getColumnType: " + rs.getMetaData().getColumnType(1));
		        System.out.println("getColumnTypeName: " + rs.getMetaData().getColumnTypeName(1).toString());
		        //System.out.println("getColumnName: " + rs.getMetaData().getColumnName(1));
	            System.out.println("getColumnCount: "+ rs.getMetaData().getColumnCount());
	            //System.out.println("getColumnClassName: " + rs.getMetaData().getColumnClassName(1));
		           
		        
	            System.out.println("getColumnDisplaySize: " + rs.getMetaData().getColumnDisplaySize(1));
	            int nrOfColumns = rs.getMetaData().getColumnCount();
		       	for(int i = startColumn; i<=nrOfColumns ;i++) {
	               System.out.print("\t " + rs.getMetaData().getColumnName(i) + "[");
          
	               System.out.print("" + rs.getMetaData().getColumnTypeName(i).toString() + "] \t| ");	                
	                
	            }
		       	System.out.print("\n");
		       	System.out.println("-----------------------------------------------------------------------------------------");
				while (rs.next()) {
					HashMap<String, Object> rowArray = new HashMap<String, Object>();
					
					System.out.print("Rad " + rs.getRow() + ": ");
	                for(int i = startColumn; i<=nrOfColumns ;i++) {
	                	
	                	if(rs.getObject(i).getClass().getName().equals("java.lang.String")) {
	                		rowArray.put(rs.getMetaData().getColumnName(i), rs.getString(i));
	                	}
	                	else if(rs.getMetaData().getColumnTypeName(i).toString().equals("SMALLINT")) {
	                		System.out.print(rs.getMetaData().getColumnTypeName(i).toString());
	                		rowArray.put(rs.getMetaData().getColumnName(i), rs.getBoolean(i));
	                	}
	                	else if(rs.getObject(i).getClass().getName().equals("java.lang.Integer")) {	                		
	                		rowArray.put(rs.getMetaData().getColumnName(i), rs.getInt(i));
	                	}
	                	else if(rs.getObject(i).getClass().getName().equals("java.sql.Timestamp")) {
	                		rowArray.put(rs.getMetaData().getColumnName(i), rs.getTimestamp(i));
	                	}
	                	else {
	                		System.out.print(",\t Uknown!, " + rs.getMetaData().getColumnTypeName(i).toString());
	                		System.out.print(rs.getObject(i).getClass().getName());
	                	}	
	                }
	                System.out.print(rowArray);
	                System.out.print("\n");
	                returnArray.add(rowArray);
				}	
				return returnArray;
			}
			finally {
				if(conn != null) conn.close();
				if(stm != null) stm.close();
				if(rs != null) rs.close();
				System.out.println("Closing connection...");
			}
		}
		catch(SQLException e) {
			System.out.println("SQLException");
			System.out.println(e);
		}
		return null;
	}
	
}
