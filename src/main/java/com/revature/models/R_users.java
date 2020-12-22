package com.revature.models;

public class R_users {
	
	
			private int r_user_id;
			private String r_username;
			private String r_password;
			private String r_first_name;
			private String r_last_name;
			private String email;
			private int r_user_role_id;
			public R_users() {
				super();
				// TODO Auto-generated constructor stub
			}
			public R_users(int r_user_id, String r_username, String r_password, String r_first_name, String r_last_name,
					String email, int r_user_role_id) {
				super();
				this.r_user_id = r_user_id;
				this.r_username = r_username;
				this.r_password = r_password;
				this.r_first_name = r_first_name;
				this.r_last_name = r_last_name;
				this.email = email;
				this.r_user_role_id = r_user_role_id;
			}
			public int getR_user_id() {
				return r_user_id;
			}
			public void setR_user_id(int r_user_id) {
				this.r_user_id = r_user_id;
			}
			public String getR_username() {
				return r_username;
			}
			public void setR_username(String r_username) {
				this.r_username = r_username;
			}
			public String getR_password() {
				return r_password;
			}
			public void setR_password(String r_password) {
				this.r_password = r_password;
			}
			public String getR_first_name() {
				return r_first_name;
			}
			public void setR_first_name(String r_first_name) {
				this.r_first_name = r_first_name;
			}
			public String getR_last_name() {
				return r_last_name;
			}
			public void setR_last_name(String r_last_name) {
				this.r_last_name = r_last_name;
			}
			public String getEmail() {
				return email;
			}
			public void setEmail(String email) {
				this.email = email;
			}
			public int getR_user_role_id() {
				return r_user_role_id;
			}
			public void setR_user_role_id(int r_user_role_id) {
				this.r_user_role_id = r_user_role_id;
			}
			@Override
			public String toString() {
				return "R_users [r_user_id=" + r_user_id + ", r_username=" + r_username + ", r_password=" + r_password
						+ ", r_first_name=" + r_first_name + ", r_last_name=" + r_last_name + ", email=" + email
						+ ", r_user_role_id=" + r_user_role_id + "]";
			}
			
			
			

}
