package com.revature.models;

public class R_reimbursement_status {
	
	
			private int r_status_id;
			private String r_status;
			public R_reimbursement_status() {
				super();
				// TODO Auto-generated constructor stub
			}
			public R_reimbursement_status(int r_status_id, String r_status) {
				super();
				this.r_status_id = r_status_id;
				this.r_status = r_status;
			}
			public int getR_status_id() {
				return r_status_id;
			}
			public void setR_status_id(int r_status_id) {
				this.r_status_id = r_status_id;
			}
			public String getR_status() {
				return r_status;
			}
			public void setR_status(String r_status) {
				this.r_status = r_status;
			}
			@Override
			public String toString() {
				return "R_reimbursement_status [r_status_id=" + r_status_id + ", r_status=" + r_status + "]";
			}
			
			

}
