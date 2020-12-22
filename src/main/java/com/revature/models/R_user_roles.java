package com.revature.models;

public class R_user_roles {
	
	
			private int r_user_role_id;
			private String user_role;
			public R_user_roles() {
				super();
				// TODO Auto-generated constructor stub
			}
			public R_user_roles(int r_user_role_id, String user_role) {
				super();
				this.r_user_role_id = r_user_role_id;
				this.user_role = user_role;
			}
			public int getR_user_role_id() {
				return r_user_role_id;
			}
			public void setR_user_role_id(int r_user_role_id) {
				this.r_user_role_id = r_user_role_id;
			}
			public String getUser_role() {
				return user_role;
			}
			public void setUser_role(String user_role) {
				this.user_role = user_role;
			}
			@Override
			public String toString() {
				return "R_user_roles [r_user_role_id=" + r_user_role_id + ", user_role=" + user_role + "]";
			}
			
			

}
