package app.jdbc.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostresSqlConnection {

			private static Connection connection;
			
			private PostresSqlConnection() {
				// TODO Auto-generated constructor stub
			}
			
				
			public static Connection getConnection() throws ClassNotFoundException, SQLException {
					//Connection connection=null;
					//Step 1 - Load/Register the Driver
					Class.forName("org.postgresql.Driver");
					System.out.println("Driver Loaded Successfully");
						
					//Step 2 - Open Connection(url,username,password)
					String url="jdbc:postgresql://localhost:5432/postgres";			
					String username ="postgres";
					String password ="Smyrna07";
					connection = DriverManager.getConnection(url, username, password);
					System.out.println("Connection Successfull");
					return connection;
				}// Single Ton- Single TON Java Class.Single Ton maintains only one instance of entire application.
					//reutilizing the connection again and again.
}							
		
	

