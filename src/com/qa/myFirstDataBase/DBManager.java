package com.qa.myFirstDataBase;

import java.sql.*;
import java.util.Scanner;

public class DBManager {


	Constants c = new Constants();
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs;
	private Scanner scans = new Scanner(System.in);
	//connect
	
	public void accessDB() throws ClassNotFoundException, SQLException {
		
		Class.forName(c.JDBC_DRIVER);
		conn = DriverManager.getConnection(c.DB_URL,c.USER,c.PASS);	
		stmt = conn.createStatement();
	}
	
	public void createTable() throws ClassNotFoundException, SQLException {
		
		System.out.println("Input name for table");
		String table = scans.nextLine();
		System.out.println("Input name for first field");
		String first_feild = scans.nextLine();
		System.out.println("Input int for second field");
		int second_field = scans.nextInt();

		System.out.println("Creating Table..");
		
		String sql = "CREATE TABLE " + table + "(id PRIMARY KEY AUTO_INCREMENT, ";
		while(true) {
			System.out.println("Input a name for a field");
			String name = scans.nextLine();
			
			sql += name + ","; 
			
			System.out.println("Would you like to add another field? y/n");
			String loop = scans.nextLine();
			if (loop == "n") {
				sql += ")";
			break;	
			}
		}
		stmt.executeUpdate(sql);
	}
	
	public void createBand() throws ClassNotFoundException, SQLException {
		
		System.out.println("Input name of Table:");
		String table = scans.nextLine();
		
		System.out.println("Input band name for database:");
		String bandName = scans.nextLine();
		
		System.out.println("Input date of band:");
		int bandDate = scans.nextInt();
		scans.nextLine(); // fix for nextInt()
		
		System.out.println("Inserting into table: " + table);
		String sql = "INSERT INTO " + table + "(name, date) " +  "VALUES('" + bandName + "'," + bandDate + ")";
		stmt.executeUpdate(sql);
	}
	
	public void read(String table) throws ClassNotFoundException, SQLException {
		System.out.println("Reading from table: " + table);
		String sql2 = "SELECT * FROM " + table;
		rs = stmt.executeQuery(sql2);
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String bandName = rs.getString("name");
			int bandDate = rs.getInt("date");
			System.out.println("ID: " + id + " Name: " + bandName + " Date: " + bandDate);
		}
		rs.close();
	}
	
	public void update(String table) throws ClassNotFoundException, SQLException {
		
		System.out.println("Updating table: " + table);
		String sql3 = "UPDATE " + table + " SET date = 1960 WHERE id IN (1,2)";
		stmt.execute(sql3);
	}
	
	public void delete(String table) throws ClassNotFoundException, SQLException{
		
		System.out.println("What ID would you like to delete");
		int id = scans.nextInt();
		
		System.out.println("Deleting ID: " + id + " in table: " + table);
		String sql4 = "DELETE FROM " + table + " WHERE id =" + id;
		stmt.executeUpdate(sql4);
	}
	
}
