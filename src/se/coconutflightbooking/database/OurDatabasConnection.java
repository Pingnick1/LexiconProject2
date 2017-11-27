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
	
	private String adress = ""; 
	private String port = "";
	private String database = ""; 
	
	
	public OurDatabasConnection(String adress, String port, String database) {
		this.adress = adress;
		this.port = port;
		this.database = database;
		
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
		}
		catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println("Hello World");
		
		OurDatabasConnection dbConnection = new OurDatabasConnection("localhost", "50000", "Coconut");
		
		
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
	
	public ArrayList<HashMap<String, Object>> retrieveResult (String sql) {
		Connection conn = null; 
		Statement stm = null; 
		ResultSet rs = null; 
		
		ArrayList<HashMap<String, Object>> returnArray = new ArrayList<HashMap<String, Object>>();
		
		int startColumn = 2;
		
		System.out.println(sql);
		
		try {	
			try {
				conn = DriverManager.getConnection("jdbc:derby://" + this.adress + ":" + this.port +"/" + this.database);
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
