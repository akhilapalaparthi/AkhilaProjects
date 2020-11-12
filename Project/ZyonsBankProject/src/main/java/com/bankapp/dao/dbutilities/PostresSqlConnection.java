package com.bankapp.dao.dbutilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.bankapp.main.BankMain;
import org.apache.log4j.Logger;	

	public class PostresSqlConnection {
		
			private static Logger log = Logger.getLogger(PostresSqlConnection.class);	
			private static Connection connection;
		
			private PostresSqlConnection() {
			// TODO Auto-generated constructor stub
			}
		
			
			public static Connection getConnection() throws ClassNotFoundException, SQLException {
				
				//Connection connection=null;
				//Step 1 - Load/Register the Driver
				Class.forName(DBUtilityProperties.DRIVER);
			//	log.error("Driver Loaded Successfully");
					
				//Step 2 - Open Connection(url,username,password)
				
				String url= DBUtilityProperties.URL;	
				String username = System.getenv("postgresUsername");
				String password = System.getenv("postgresPassword");
				connection = DriverManager.getConnection(url, username, password);
			//	 log.error("Connection Successfull");
				return connection;
			}// Single Ton- Single TON Java Class.Single Ton maintains only one instance of entire application.
				//reutilizing the connection again and again.
	}							





