package se.coconutflightbooking.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
		
		
		
		String sql = "Select * from MYTABLE";
		//String sql = "Select * from MYTABLE";
		
		dbConnection.addData("", "", 1);
		dbConnection.retrieveResultSet(sql);
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
	
	public void addData(String sql, String title, int id) {
		Connection conn = null;
		PreparedStatement pstm = null;
		title = "Niklas234324";
		sql = "insert into MYTABLE (ID, name) values (?,?)";
		
		try { 

			try {
				
				conn = DriverManager.getConnection("jdbc:derby://localhost:50000/test");
				pstm = conn.prepareStatement(sql);
				pstm.setInt(1, 2);
				pstm.setString(2,title);
				
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
	
	public void retrieveResultSet (String sql) {

		try {
			//Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
			
			try (Connection conn = DriverManager.getConnection("jdbc:derby://localhost:50000/test")) {
				try(Statement stm = conn.createStatement()){
					try(ResultSet rs = stm.executeQuery(sql)){
						while (rs.next()) {
							System.out.println(rs.getString("name"));
						}
					}
				}
			}	
		}
		catch (SQLException e) {

			System.out.println("Something went wrong");
			System.out.println(e);
		}

	}
	
}
