package com.bankapp.dao.dbutilities;


public class QueriesPlayer {
	
	public static final String CUSTOMERINSERTQUERY= "INSERT INTO bank.customers"
			+ "(customerid, firstname, lastname, middleInitial, street, city, state, zip, phone, email,transcreateddate, dateOfBirth) "
			+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
	public static final String SELECTQUERYCUST = "SELECT customerid from bank.customers where firstname=? and lastname=? and middleInitial=? and dateOfBirth = ?";
	public static final String SELECTACCBASEDONCUSTID = "SELECT customerid, accountype, balance from bank.accounts where customerid = ?";
	public static final String SELECTQUERY = "SELECT balance from bank.accounts where accountno = ?";
	public static final String UPDATEQUERY = "UPDATE bank.accounts set balance= ? where accountno = ?";
	public static final String MAXOFCUSTOMERID = " SELECT max(customerid) as customerid from bank.customers";
	public static final String UPDATELOG = "INSERT INTO bank.logtable(logid, accountno, transactiontype, amt, remarks, date1)" 
			+"VALUES(?,?,?,?,?,?)";
	public static final String SELECTLOGTABLE = " SELECT accountno, transactiontype, amount, remarks, date1 from bank.logtable "
				+"WHERE accountno = ? ";
	public static final String SELECTACCOUNTSTABLE = "INSERT INTO bank.accounts(customerid, accountno, balance, accountype)"
			+"VALUES(?,?,?,?)";
	public static final String MAXOFLOGID = " SELECT max(logid) as logid from bank.logtable";
	public static final String VIEWLOG  = " SELECT logid, accountno, transactiontype, remarks, date1, amt from bank.logtable";
	public static final String ACCOUNTSQUERY = "SELECT customerid, accountno, balance, accountype FROM bank.accounts WHERE accountno = ? ";
}


