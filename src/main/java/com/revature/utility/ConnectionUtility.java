package com.revature.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class ConnectionUtility {
	
	

			private static Logger log = Logger.getLogger(ConnectionUtility.class);	
			private static Connection connection;
		
			
			
			public static Connection getConnection() throws SQLException {
				
				//Connection connection=null;
				//Step 1 - Load/Register the Driver
			try {	
				Class.forName(DBUtilityProperties.DRIVER);
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
				log.error("Driver Loaded Successfully");
					
				//Step 2 - Open Connection(url,username,password)
				
				String url= DBUtilityProperties.URL;	
				String username = System.getenv("postgresUsername");
				String password = System.getenv("postgresPassword");
				connection = DriverManager.getConnection(url, username, password);
				 log.error("Connection Successfull");
				return connection;
			}// Single Ton- Single TON Java Class.Single Ton maintains only one instance of entire application.
				//reutilizing the connection again and again.
								

//					public static void main(String[] args) {
//						
//						//Try with resources block. The try statement will stake a method that creates a resource, that will
//						//automatically be closed at the end of the try or catch block. It avoids the need for a finally block.
//						try(Connection conn = ConnectionUtility.getConnection()){
//							System.out.println("connection successful");
//						} catch(SQLException e) {
//							e.printStackTrace();
//						}
//					}
}




