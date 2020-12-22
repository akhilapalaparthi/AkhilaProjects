package com.revature.models;


	public class LoginDTO {
		
		public String username;  //DTO's are generally public. //DTO is data transfer objects.//don't use DTO's outside the controllers. u can use DTO's to communicate to client.
		public String password; // comparing the front-end data to back-end data. like comparing login, password.// no need of JUNIT testing in controllers.
		
		
		public LoginDTO(String username, String password) {
			super();
			this.username = username;
			this.password = password;
		}
		
		public LoginDTO() {
			super();
			
		}

}



