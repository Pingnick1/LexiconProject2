package se.coconutflightbooking.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class OurDatabasConnection {
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private Statement stm = null;
	private ResultSet rs = null;
	
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
		String sql = "Select * from AIRPLANES";
		HashMap<String, HashMap<String, String>> result = dbConnection.retrieveResultSet(sql);
		
		if(result.size()>0) {
			for (String airPlaneID : result.keySet()) {
				
				HashMap<String, String> result2 = result.get(airPlaneID); 
				
				System.out.println("AirPlaneID:" + airPlaneID + 
									" NickName: " + result2.get("name") + 
									", Firstclass: " + result2.get("FIRSTCLASS_SEAT_AMOUNT") + 
									", Economicclass: " + result2.get("ECONOMIC_SEAT_AMOUNT") +
									", Status: " + result2.get("STATUS"));	
			}
		}
		else {
			System.out.println("Nothing retieved..");
		}
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
	
	public HashMap<String, HashMap<String, String>> retrieveResultSet (String sql) {
		//HashMap<String,String> retrieveMap = new HashMap<String, String>();
		HashMap<String, HashMap<String, String>> retrieveMap = new HashMap<String, HashMap<String, String>>();
		
		//ArrayList <String, ArrayList<String>> minArray = new ArrayList<String, ArrayList<String>>();
		try {
			//Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
			
			try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:50000/test")) {
				try(Statement stm = conn.createStatement()){
					try(ResultSet rs = stm.executeQuery(sql)){
						while (rs.next()) {
							HashMap<String, String> row = new HashMap<String, String>();
							row.put("PLANE_ID", rs.getString("PLANE_ID"));
							row.put("name", rs.getString("name"));
							row.put("ECONOMIC_SEAT_AMOUNT", rs.getString("ECONOMIC_SEAT_AMOUNT"));
							row.put("FIRSTCLASS_SEAT_AMOUNT", rs.getString("FIRSTCLASS_SEAT_AMOUNT"));
							row.put("STATUS", rs.getString("STATUS"));
							
							//System.out.println(rs.getString("PLANE_ID") + " " + rs.getString("name") + " " + rs.getString("ECONOMIC_SEAT_AMOUNT") + " " + rs.getString("FIRSTCLASS_SEAT_AMOUNT") + " " + rs.getString("STATUS"));
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
