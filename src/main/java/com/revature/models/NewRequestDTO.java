package com.revature.models;

public class NewRequestDTO {
	

	private int r_amount;
	private String r_description;
	private int r_type_id;
	public NewRequestDTO() {
		super();
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + r_amount;
		result = prime * result + ((r_description == null) ? 0 : r_description.hashCode());
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
		NewRequestDTO other = (NewRequestDTO) obj;
		if (r_amount != other.r_amount)
			return false;
		if (r_description == null) {
			if (other.r_description != null)
				return false;
		} else if (!r_description.equals(other.r_description))
			return false;
		if (r_type_id != other.r_type_id)
			return false;
		return true;
	}
	public int getR_amount() {
		return r_amount;
	}
	public void setR_amount(int r_amount) {
		this.r_amount = r_amount;
	}
	public String getR_description() {
		return r_description;
	}
	public void setR_description(String r_description) {
		this.r_description = r_description;
	}
	public int getR_type_id() {
		return r_type_id;
	}
	public void setR_type_id(int r_type_id) {
		this.r_type_id = r_type_id;
	}
	public NewRequestDTO(int r_amount, String r_description, int r_type_id) {
		super();
		this.r_amount = r_amount;
		this.r_description = r_description;
		this.r_type_id = r_type_id;
	}

	@Override
	public String toString() {
		return "NewRequestDTO [r_amount=" + r_amount + ", r_description=" + r_description + ", r_type_id=" + r_type_id
				+ "]";
	}
	
	
	
	

}
