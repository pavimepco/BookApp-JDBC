package com.chainsys.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionUtil {

	public static Connection getConnection() {
		// 1. Load the class
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. Get the connection
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			connection = DriverManager.getConnection(url, "hr", "hr");
			System.out.println(connection);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void closeConnection(Connection conn,PreparedStatement stmt,ResultSet rs){
	    try{
	    	if(rs!=null){
	    		rs.close();
	    	}
	    	if(stmt!=null){
	    		stmt.close();
	    	}
	    	if(conn!=null){
	    		conn.close();
	    	}
	    }catch(SQLException e){
	    }
	    }
}
