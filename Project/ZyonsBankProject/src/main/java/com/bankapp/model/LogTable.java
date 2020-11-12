package com.bankapp.model;


public class LogTable {		
		
		private int logid;
		private int accountno;
		private String transactiontype;
		private String remarks;
		private String date;
		private int amt;
		public LogTable() {
		}
		public int getLogid() {
			return logid;
		}
		public void setLogid(int logid) {
			this.logid = logid;
		}
		public int getAccountno() {
			return accountno;
		}
		public void setAccountno(int accountno) {
			this.accountno = accountno;
		}
		public String getTransactiontype() {
			return transactiontype;
		}
		public void setTransactiontype(String transactiontype) {
			this.transactiontype = transactiontype;
		}
		public String getRemarks() {
			return remarks;
		}
		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public int getAmt() {
			return amt;
		}
		public void setAmt(int amt) {
			this.amt = amt;
		}
		public LogTable(int logid, int accountno, String transactiontype, String remarks, String date, int amt) {
			super();
			this.logid = logid;
			this.accountno = accountno;
			this.transactiontype = transactiontype;
			this.remarks = remarks;
			this.date = date;
			this.amt = amt;
		}
		@Override
		public String toString() {
			return "LogTable [logid=" + logid + ", accountno=" + accountno + ", transactiontype=" + transactiontype
					+ ", remarks=" + remarks + ", date=" + date + ", amt=" + amt + "]";
		}
		
		
}			


