package com.qa.myFirstDataBase;
import java.sql.*;
public class JDB_Main {
	
	    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	    static final String DB_URL = "jdbc:mysql://35.189.76.28/records?useSSL=false";

	    static final String USER = "root";
	    static final String PASS = "root";

	    public static void main(String[] args) throws ClassNotFoundException, SQLException {
	        Connection conn = null;
	        Statement stmt = null;
	        Class.forName("com.mysql.jdbc.Driver");

	        System.out.println("Connecting to database...");
	        conn = DriverManager.getConnection(DB_URL,USER,PASS);

	        System.out.println("Creating statement...");
	        stmt = conn.createStatement();
	        String sql;
	        sql = "SELECT * FROM recordPlayer";
	        ResultSet rs = stmt.executeQuery(sql);

	        while(rs.next()){
	            int id  = rs.getInt("id");
	            String band = rs.getString("band");
	            String price = rs.getString("price");
	            //Display values
	            System.out.print("ID: " + id + " Band: " + band + " Price: " + price + "\n");
	        }

	        rs.close();
	        stmt.close();
	        conn.close();
	    }
}
