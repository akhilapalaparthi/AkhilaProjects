package com.bankapp.model;

import java.security.Timestamp;
import java.util.Date;

public class Customer {
			
		private int customerid;
		private String firstname;
		private String lastname;
		private String middleInitial;
		private String dateOfBirth;
		private String street;
		private String city;
		private String state;
		private Integer zip;
		private Integer phone;
		private String email;
		private  Timestamp transcreateddate;
		public Customer() {
			// TODO Auto-generated constructor stub
		}
		
		
		
		public int getCustomerid() {
			return customerid;
		}



		public void setCustomerid(int customerid) {
			this.customerid = customerid;
		}



		public String getFirstname() {
			return firstname;
		}



		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}



		public String getLastname() {
			return lastname;
		}



		public void setLastname(String lastname) {
			this.lastname = lastname;
		}



		public String getMiddleInitial() {
			return middleInitial;
		}



		public void setMiddleInitial(String middleInitial) {
			this.middleInitial = middleInitial;
		}



		public String getDateOfBirth() {
			return dateOfBirth;
		}



		public void setDateOfBirth(String dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
			}



		public String getStreet() {
			return street;
		}



		public void setStreet(String street) {
			this.street = street;
		}



		public String getCity() {
			return city;
		}



		public void setCity(String city) {
			this.city = city;
		}



		public String getState() {
			return state;
		}



		public void setState(String state) {
			this.state = state;
		}



		public Integer getZip() {
			return zip;
		}



		public void setZip(Integer zip) {
			this.zip = zip;
		}



		public Integer getPhone() {
			return phone;
		}



		public void setPhone(Integer phone) {
			this.phone = phone;
		}



		public String getEmail() {
			return email;
		}



		public void setEmail(String email) {
			this.email = email;
		}



		public Timestamp getTranscreateddate() {
			return transcreateddate;
		}



		public void setTranscreateddate(Timestamp transcreateddate) {
			this.transcreateddate = transcreateddate;
		}



		@Override
		public String toString() {
			return "Customer [customerid=" + customerid + ", firstname=" + firstname + ", lastname=" + lastname
					+ ", middleInitial=" + middleInitial + ", dateOfBirth=" + dateOfBirth + ", street=" + street
					+ ", city=" + city + ", state=" + state + ", zip=" + zip + ", phone=" + phone + ", email=" + email
					+ ", transcreateddate=" + transcreateddate + "]";
		}
		public Customer(int customerid, String firstname, String lastname, String middleInitial,String dateOfBirth,
				String street, String city, String state, Integer zip, Integer phone, String email,
				Timestamp transcreateddate) {
			super();
			this.customerid = customerid;
			this.firstname = firstname;
			this.lastname = lastname;
			this.middleInitial = middleInitial;
			this.dateOfBirth = dateOfBirth;
			this.street = street;
			this.city = city;
			this.state = state;
			this.zip = zip;
			this.phone = phone;
			this.email = email;
			this.transcreateddate = transcreateddate;
		}
		
		
		
		
		
	}


