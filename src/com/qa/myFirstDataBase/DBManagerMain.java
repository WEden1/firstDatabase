package com.qa.myFirstDataBase;

import java.sql.SQLException;
import java.util.Scanner;


public class DBManagerMain {

	
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		
		Scanner scan = new Scanner(System.in);
		DBManager dbManager = new DBManager();
		
		int selection;		
		
		System.out.println("What would you like to do?\n"
				+ "1. Create table\n"
				+ "2. Insert Band into database\n"
				+ "3. Read from Database\n"
				+ "4. Update database\n"
				+ "5. Delete from database\n");
		
		dbManager.accessDB();
		
		selection = scan.nextInt();
		
		switch (selection) {
		
		case 1:
		{
			dbManager.createTable();
			break;
		}
		
		case 2:
		{
			dbManager.createBand();
			break;
		}
		case 3:
		{
			dbManager.read("recordCollection");
			break;
		}
		case 4:
		{
			dbManager.update("recordCollection");
			break;
		}
		case 5:
		{
			dbManager.delete("recordCollection");
			break;
		}
		default:
		{
			break;
		}
		}
	}
}
