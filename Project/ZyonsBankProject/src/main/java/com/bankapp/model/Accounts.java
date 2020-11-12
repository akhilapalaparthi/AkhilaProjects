package com.bankapp.model;

public class Accounts {
			
		private int customerid;
		private int accountno;
		private double balance;
		private String accountype;
		public Accounts() {
			// TODO Auto-generated constructor stub
		}
		public int getCustomerid() {
			return customerid;
		}
		public void setCustomerid(int customerid) {
			this.customerid = customerid;
		}
		public int getAccountno() {
			return accountno;
		}
		public void setAccountno(int accountno) {
			this.accountno = accountno;
		}
		public double getBalance() {
			return balance;
		}
		public void setBalance(double balance) {
			this.balance = balance;
		}
		public String getAccountype() {
			return accountype;
		}
		public void setAccountype(String accountype) {
			this.accountype = accountype;
		}
		public Accounts(int customerid, int accountno, double balance, String accountype) {
			super();
			this.customerid = customerid;
			this.accountno = accountno;
			this.balance = balance;
			this.accountype = accountype;
		}
		@Override
		public String toString() {
			return "Accounts [customerid=" + customerid + ", accountno=" + accountno + ", balance=" + balance
					+ ", accountype=" + accountype + "]";
		}
		
}


