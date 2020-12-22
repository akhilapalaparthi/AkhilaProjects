package com.revature.models;


import java.util.Date;

public class Reimbursement{
	
	
		private int	r_id;
		private int r_amount;
		private String d_submitted;
		private String d_resolved;
		private String r_description;
		private int r_author;
		private int r_resolver;
		private int r_status_id;
		private int r_type_id;
		public Reimbursement() {
			super();
			
		}
		public Reimbursement(int r_id, int r_amount, String d_submitted, String d_resolved, String r_description,
				int r_author, int r_resolver, int r_status_id, int r_type_id) {
			super();
			this.r_id = r_id;
			this.r_amount = r_amount;
			this.d_submitted = d_submitted;
			this.d_resolved = d_resolved;
			this.r_description = r_description;
			this.r_author = r_author;
			this.r_resolver = r_resolver;
			this.r_status_id = r_status_id;
			this.r_type_id = r_type_id;
		}
		public int getR_id() {
			return r_id;
		}
		public void setR_id(int r_id) {
			this.r_id = r_id;
		}
		public int getR_amount() {
			return r_amount;
		}
		public void setR_amount(int r_amount) {
			this.r_amount = r_amount;
		}
		public String getD_submitted() {
			return d_submitted;
		}
		public void setD_submitted(String d_submitted) {
			this.d_submitted = d_submitted;
		}
		public String getD_resolved() {
			return d_resolved;
		}
		public void setD_resolved(String d_resolved) {
			this.d_resolved = d_resolved;
		}
		public String getR_description() {
			return r_description;
		}
		public void setR_description(String r_description) {
			this.r_description = r_description;
		}
		public int getR_author() {
			return r_author;
		}
		public void setR_author(int r_author) {
			this.r_author = r_author;
		}
		public int getR_resolver() {
			return r_resolver;
		}
		public void setR_resolver(int r_resolver) {
			this.r_resolver = r_resolver;
		}
		public int getR_status_id() {
			return r_status_id;
		}
		public void setR_status_id(int r_status_id) {
			this.r_status_id = r_status_id;
		}
		public int getR_type_id() {
			return r_type_id;
		}
		public void setR_type_id(int r_type_id) {
			this.r_type_id = r_type_id;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((d_resolved == null) ? 0 : d_resolved.hashCode());
			result = prime * result + ((d_submitted == null) ? 0 : d_submitted.hashCode());
			result = prime * result + r_amount;
			result = prime * result + r_author;
			result = prime * result + ((r_description == null) ? 0 : r_description.hashCode());
			result = prime * result + r_id;
			result = prime * result + r_resolver;
			result = prime * result + r_status_id;
			result = prime * result + r_type_id;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Reimbursement other = (Reimbursement) obj;
			if (d_resolved == null) {
				if (other.d_resolved != null)
					return false;
			} else if (!d_resolved.equals(other.d_resolved))
				return false;
			if (d_submitted == null) {
				if (other.d_submitted != null)
					return false;
			} else if (!d_submitted.equals(other.d_submitted))
				return false;
			if (r_amount != other.r_amount)
				return false;
			if (r_author != other.r_author)
				return false;
			if (r_description == null) {
				if (other.r_description != null)
					return false;
			} else if (!r_description.equals(other.r_description))
				return false;
			if (r_id != other.r_id)
				return false;
			if (r_resolver != other.r_resolver)
				return false;
			if (r_status_id != other.r_status_id)
				return false;
			if (r_type_id != other.r_type_id)
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "Reimbursement [r_id=" + r_id + ", r_amount=" + r_amount + ", d_submitted=" + d_submitted
					+ ", d_resolved=" + d_resolved + ", r_description=" + r_description + ", r_author=" + r_author
					+ ", r_resolver=" + r_resolver + ", r_status_id=" + r_status_id + ", r_type_id=" + r_type_id + "]";
		}
		
		
		

}
