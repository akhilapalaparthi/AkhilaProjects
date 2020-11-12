package com.bankapp.dao.impl;

import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;

import com.bankapp.dao.BankDAO;
import com.bankapp.dao.dbutilities.PostresSqlConnection;
import com.bankapp.dao.dbutilities.QueriesPlayer;
import com.bankapp.exception.BusinessException;
import com.bankapp.model.Accounts;
import com.bankapp.model.Customer;
import com.bankapp.model.LogTable;
import com.bankapp.service.impl.BankServiceImpl;


public class BankDAOImpl implements BankDAO {
	
	
	private static Logger log = Logger.getLogger(BankDAOImpl.class);	
	
	@Override
	public Boolean newCustomerCreation(Customer cust, Accounts account) throws BusinessException {
		Boolean isSuccess = Boolean.FALSE;
		 Integer cust2 = null;
		 Integer custId = null;
		 List<String> accountypeList = new ArrayList();
		try (Connection connection = PostresSqlConnection.getConnection()){
			
			String custSql = QueriesPlayer.SELECTQUERYCUST;
			
			PreparedStatement ps = connection.prepareStatement(custSql);
			ps.setString(1, cust.getFirstname());
			ps.setString(2, cust.getLastname());
			ps.setString(3, cust.getMiddleInitial());
			ps.setDate(4, java.sql.Date.valueOf(cust.getDateOfBirth()));
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
			  custId = rs.getInt("customerid");
			
			}
			
			if(custId != null) {
				String accSql = QueriesPlayer.SELECTACCBASEDONCUSTID;
				ps = connection.prepareStatement(accSql);
				ps.setInt(1, custId);
				rs = ps.executeQuery();
				while (rs.next()) {
					accountypeList.add(rs.getString("accountype"));								
				}
				
				
				
				if(accountypeList.size()>0 ) {
					for(String accType: accountypeList) {
						if(accType.equalsIgnoreCase(account.getAccountype())) {
							throw new BusinessException("Already Existing customer.");
						}
					}
					
				}
				else {
					Timestamp formattedDate = this.currentDate();
					String Transactiontype = "New Account Opened";
					String rmk = "ACCEPTED ACCOUNT ";
					updatingAccountsTable(custId, account.getAccountno(), account.getBalance(), account.getAccountype());
					updateLogTable(account.getAccountno(), Transactiontype, account.getBalance(), formattedDate , rmk);
				}
				
			}else {
			
			String sql = QueriesPlayer.CUSTOMERINSERTQUERY;
			Timestamp formattedDate = this.currentDate();
			
			  String sql2 = QueriesPlayer.MAXOFCUSTOMERID;	
			  PreparedStatement preparedStatement = connection.prepareStatement(sql2);
			  ResultSet resultSet = preparedStatement.executeQuery();
			  if (resultSet.next()) {
				 cust2 = resultSet.getInt("customerid")+ 1;
				
			  }
			 preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, cust2);			
			preparedStatement.setString(2, cust.getFirstname());
			preparedStatement.setString(3, cust.getLastname());
			
			preparedStatement.setString(4, cust.getMiddleInitial());
			preparedStatement.setString(5, cust.getStreet());
			preparedStatement.setString(6, cust.getCity());
			preparedStatement.setString(7, cust.getState());
			preparedStatement.setInt(8, cust.getZip());
			preparedStatement.setInt(9, cust.getPhone());
			preparedStatement.setString(10, cust.getEmail());
			preparedStatement.setTimestamp(11, formattedDate);
			preparedStatement.setDate(12, java.sql.Date.valueOf(cust.getDateOfBirth()));
						
			preparedStatement.executeUpdate();
						
			String Transactiontype = "New Account Opened";
			String rmk = "ACCEPTED ACCOUNT ";
			updatingAccountsTable(cust2, account.getAccountno(), account.getBalance(), account.getAccountype());
			updateLogTable(account.getAccountno(), Transactiontype, account.getBalance(), formattedDate , rmk);
			isSuccess = Boolean.TRUE;
			}	
		} catch (ClassNotFoundException | SQLException e) {
			log.debug(e); // take off this line when in production
			throw new BusinessException("Internal error occured.. Kindly contact SYSADMIN");
		}
		return isSuccess;
	}


		
		@Override
	public Double viewBalanceOnAccountNumber(Integer accountNo) throws BusinessException {
		Double balance = null;
		
		try (Connection connection = PostresSqlConnection.getConnection()) {

						String sql = QueriesPlayer.SELECTQUERY;			
						PreparedStatement preparedStatement = connection.prepareStatement(sql);
						preparedStatement.setInt(1, accountNo);
						ResultSet resultSet = preparedStatement.executeQuery();
						if (resultSet.next()) {
							 balance = resultSet.getDouble("balance");
							 String Transactiontype = "Viewed Balance";	
								String rmk = "Viewed Account";
								Timestamp formattedDate = currentDate();
							updateLogTable(accountNo, Transactiontype, balance, formattedDate , rmk);
						
					
						}else {
								throw new BusinessException("Invalid Account Number!!!... No matching records found for the Account Number = "+accountNo);
								}} catch (ClassNotFoundException | SQLException e) {	
												log.debug(e); // take off this line when in production													throw new BusinessException("Internal error occured.. Kindly contact SYSADMIN");
									}	return balance;	}

	@Override
	public Double makeADepositOnAccountNumber(Integer accountNo, Double amount) throws BusinessException{
		
		Double balance = null;
		try (Connection connection = PostresSqlConnection.getConnection()) {

					String sql = QueriesPlayer.SELECTQUERY;		
					String updateSql = QueriesPlayer.UPDATEQUERY;			
					
					PreparedStatement preparedStatement = connection.prepareStatement(sql);
					preparedStatement.setInt(1, accountNo);
					ResultSet resultSet = preparedStatement.executeQuery();
					if (resultSet.next()) {
						 Double accbalance = resultSet.getDouble("balance");
						 balance =accbalance+amount;
						 preparedStatement = connection.prepareStatement(updateSql);
						 preparedStatement.setDouble(1, balance);
					     preparedStatement.setInt(2, accountNo);
						 preparedStatement.executeUpdate();
						 Timestamp formattedDate = currentDate();

						  String Transactiontype = "Deposited";
						  String Rmk = "Amount Deposited ";
						 updateLogTable(accountNo, Transactiontype, amount, formattedDate, Rmk);
							}else {
					throw new BusinessException("Invalid Account Number!!!... No matching records found for the Account Number = "+accountNo);
						}} catch (ClassNotFoundException | SQLException e) {	
							log.debug(e); // take off this line when in production	
							throw new BusinessException("Internal error occured.. Kindly contact SYSADMIN");
							}
			return balance;}
		
	@Override
	public Double makeAWithdrawalOnAccountNumber(Integer accountNo, Double amount) throws BusinessException {
		Double balance = null;
		try (Connection connection = PostresSqlConnection.getConnection()) {

						String sql = QueriesPlayer.SELECTQUERY;		
						String updateSql = QueriesPlayer.UPDATEQUERY;			
					
						PreparedStatement preparedStatement = connection.prepareStatement(sql);
						
						preparedStatement.setInt(1, accountNo);
						ResultSet resultSet = preparedStatement.executeQuery();
						if (resultSet.next()) {
								
						 Double accbalance = resultSet.getDouble("balance");
						 //	 balance =accbalance-amount;
						 	 if(accbalance-amount < 500) {
						 		 log.info("Invalid Transaction..As minimum balance is 500");
						 		 log.info("Sorry Customer, Cannot make this Transaction");
						 		 }else if (accbalance-amount >= 500) {
						 			balance =accbalance-amount;		 
						      preparedStatement = connection.prepareStatement(updateSql);
							  preparedStatement.setDouble(1, balance);
							  preparedStatement.setInt(2, accountNo);
							  preparedStatement.executeUpdate();
							  log.info("Your Current Balance after withdrawal is "+balance);
							  Timestamp formattedDate = currentDate();
							  String Transactiontype = "Withdrawal";
							  String Rmk = "Amount Withdrawn";
							  updateLogTable(accountNo, Transactiontype, amount, formattedDate, Rmk);
							  log.info("The current Balance of Account No "+ accountNo+ " is "+balance);
						 		 }}else {
				throw new BusinessException("Invalid Account Number!!!... No matching records found for the Account Number = "+accountNo);
				}} catch (ClassNotFoundException | SQLException e) {	
					log.debug(e); // take off this line when in production		
					throw new BusinessException("Internal error occured.. Kindly contact SYSADMIN");
				}return balance;
	}

	@Override
	public void makeAMoneyTransferToSavingsOrCheckingAccount(Integer accountNo1, Integer accountNo2, Double amount1)
			throws BusinessException {
		Double amount2 = null;
		Double a =null;
		try (Connection connection = PostresSqlConnection.getConnection()) {

						String sql = QueriesPlayer.SELECTQUERY;		
						String updateSql = QueriesPlayer.UPDATEQUERY;			
					// first account details
						PreparedStatement preparedStatement = connection.prepareStatement(sql);
						preparedStatement.setInt(1, accountNo1);
						ResultSet resultSet = preparedStatement.executeQuery();
						if (resultSet.next()) {
							Double accbalance = resultSet.getDouble("balance");
						
							a = accbalance-amount1;
						}
						//System.out.println("accbalance= "+a);
						if(a <500 ) {
							log.info("Sorry Customer! Cannot make this transaction.As Minimum balance should be 500$");
						}else if (a>=500) {
						 preparedStatement = connection.prepareStatement(updateSql);
							preparedStatement.setDouble(1, a);
							preparedStatement.setInt(2, accountNo1);
							preparedStatement.executeUpdate();
							log.info("The current Balance of Account No "+ accountNo1+ " is "+a);	
						// second account details.
						PreparedStatement preparedStatement1 = connection.prepareStatement(sql);
						preparedStatement1.setInt(1, accountNo2);
						ResultSet resultSet1 = preparedStatement1.executeQuery();
						if (resultSet1.next()) {
							Double accbalance1 = resultSet1.getDouble("balance");
							//System.out.println("2nd a/c balance="+accbalance1);
							Double bal =accbalance1+amount1;
						    preparedStatement = connection.prepareStatement(updateSql);
							preparedStatement.setDouble(1, bal);
							preparedStatement.setInt(2, accountNo2);
							preparedStatement.executeUpdate();
							Timestamp formattedDate = currentDate();

							  String Transactiontype = "Amount Transfered to" +accountNo2;
							  String Rmk = "Amount Transferred";
							 updateLogTable(accountNo1, Transactiontype, amount1, formattedDate, Rmk);
															
						}else {
				throw new BusinessException("Invalid Account Number!!!... No matching records found for the Account Number = ");
				}}} catch (ClassNotFoundException | SQLException e) {	
					log.debug(e); // take off this line when in production		
					throw new BusinessException("Internal error occured.. Kindly contact SYSADMIN");
				}
	}		

	@Override
	public Double makeMoneyTransferToAnotherAccount(Integer accountNo1, Integer accountNo2, Double amount1)
			throws BusinessException {
		Double amount2 = null;
		Double a =null;
		try (Connection connection = PostresSqlConnection.getConnection()) {

						String sql = QueriesPlayer.SELECTQUERY;		
						String updateSql = QueriesPlayer.UPDATEQUERY;			
					// first account details
						PreparedStatement preparedStatement = connection.prepareStatement(sql);
						preparedStatement.setInt(1, accountNo1);
						ResultSet resultSet = preparedStatement.executeQuery();
						if (resultSet.next()) {
							Double accbalance = resultSet.getDouble("balance");
						 a = accbalance-amount1;}
						 if(a<500) {
							 log.info("Sorry Customer! Cannot make this transaction.As Minimum balance should be 500$");
						 } else if (a>=500) {
						 preparedStatement = connection.prepareStatement(updateSql);
							preparedStatement.setDouble(1, a);
							preparedStatement.setInt(2, accountNo1);
							preparedStatement.executeUpdate();
							// second account details.
					
						PreparedStatement preparedStatement1 = connection.prepareStatement(sql);
						preparedStatement1.setInt(1, accountNo2);
						ResultSet resultSet1 = preparedStatement1.executeQuery();
						if (resultSet1.next()) {
							Double accbalance1 = resultSet1.getDouble("balance");
							//System.out.println("2nd a/c balance="+accbalance1);
							Double bal =accbalance1+amount1;
						    preparedStatement = connection.prepareStatement(updateSql);
							preparedStatement.setDouble(1, bal);
							preparedStatement.setInt(2, accountNo2);
							preparedStatement.executeUpdate();
							Timestamp formattedDate = currentDate();

							  String Transactiontype = "Amount Transfered to" +accountNo2;
							  String Rmk = "Amount Transferred";
							 updateLogTable(accountNo1, Transactiontype, amount1, formattedDate, Rmk);
							 log.info("The current Balance of Account No "+ accountNo1+ " is "+a);								
							}else {
				throw new BusinessException("Invalid Account Number!!!... No matching records found for the Account Number = ");
				} }}catch (ClassNotFoundException | SQLException e) {	
					log.debug(e); // take off this line when in production		
					throw new BusinessException("Internal error occured.. Kindly contact SYSADMIN");
				}return a;
	}

	
	private void updateLogTable(Integer accountNo, String Transactiontype, Double amount, Timestamp date, String rmk) throws BusinessException {
		Integer logid = null;
		try (Connection connection = PostresSqlConnection.getConnection()) {
				String remarks= null;
			String updateSql = QueriesPlayer.UPDATELOG;		
			PreparedStatement preparedStatement = connection.prepareStatement(updateSql);
			
			 String sql2 = QueriesPlayer.MAXOFLOGID;	
			  PreparedStatement preparedStatement1 = connection.prepareStatement(sql2);
			  ResultSet resultSet = preparedStatement1.executeQuery();
			  if (resultSet.next()) {
				logid = resultSet.getInt("logid")+ 1;
				
			  }
			preparedStatement.setInt(1, logid);
			preparedStatement.setInt(2, accountNo);
			preparedStatement.setString(3, Transactiontype);
			preparedStatement.setDouble(4, amount);
			preparedStatement.setString(5, rmk);
			preparedStatement.setObject(6, date);
			preparedStatement.executeUpdate();}
		     catch(ClassNotFoundException | SQLException e) {
			log.debug(e); // take off this line when in production
			throw new BusinessException("Internal error occured.. Kindly contact SYSADMIN");
		}}

	@Override
	public void viewLogTableBasedOnAccountNo(Integer accountNo) throws BusinessException {
		try (Connection connection = PostresSqlConnection.getConnection()) {
			
			String sql = QueriesPlayer.SELECTLOGTABLE ;		
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, accountNo);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				
		//		 System.out.println(resultSet.accountno, resultSet.transactiontype,resultSet.amount,resultSet.remarks, resultSet.date1);
					}else {
			throw new BusinessException("Invalid Account Number!!!... No matching records found for the Account Number = "+accountNo);
				}} catch (ClassNotFoundException | SQLException e) {	
					log.debug(e); // take off this line when in production	
					throw new BusinessException("Internal error occured.. Kindly contact SYSADMIN");
					}
	}

	@Override
	public void updatingAccountsTable(Integer customerid, Integer accountno, Double balance, String accountype) {
				try (Connection connection = PostresSqlConnection.getConnection()) {
//					log.info("Welcome New Customer..Thank you for choosing Zyon Banking Service.");
//					log.info("Your New Account Number is "+accountno+ " with a starting balance of "+balance+ "  and Accounttype is "+accountype);
						String sql = QueriesPlayer.SELECTACCOUNTSTABLE;		
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, customerid);
			preparedStatement.setInt(2, accountno);
			preparedStatement.setDouble(3, balance);
			preparedStatement.setString(4, accountype);
			preparedStatement.executeUpdate();
						} catch (ClassNotFoundException | SQLException e) {	
					log.debug(e); // take off this line when in production	
					
				}	
	}

	@Override
	public List<LogTable> viewLogOfAllTransactions() throws BusinessException {
		
		List<LogTable> loglist = new ArrayList<>();
		try (Connection connection = PostresSqlConnection.getConnection()) {

			String sql = QueriesPlayer.VIEWLOG;			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				
				LogTable loglist1 =  new LogTable(resultSet.getInt("logid"),resultSet.getInt("accountno"), resultSet.getString("transactiontype"),resultSet.getString("remarks"),resultSet.getString("date1"),resultSet.getInt("amt"));
				loglist.add(loglist1);								
			}if(loglist.size()==0) {
				
	        	  throw new BusinessException(" ... No order records found in the orders table ");
	
	          }
	} catch (ClassNotFoundException | SQLException e) {
	
		log.debug(e); // take off this line when in production
			throw new BusinessException("Internal error occured.. Kindly contact SYSADMIN");
		}	
		return loglist;
	}

	@Override
	public Accounts viewCustomerBankAccounts(Integer accountNo) throws BusinessException {
		Accounts acct = null;
		try (Connection connection = PostresSqlConnection.getConnection()) {
				String sql = QueriesPlayer.ACCOUNTSQUERY;
								
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, accountNo);
				ResultSet resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {

					acct= new Accounts(resultSet.getInt("customerid"),accountNo, resultSet.getDouble("balance"), resultSet.getString("accountype"));
								
					}else {

						throw new BusinessException("Invalid ID!!!... No matching records found for the ID =  "+accountNo);

					}
						} catch (ClassNotFoundException | SQLException e) {

							log.debug(e); // take off this line when in production
							throw new BusinessException("Internal error occured.. Kindly contact SYSADMIN");
						}
					return acct;
}
	
	private Timestamp currentDate() {
		 Date date= new Date(); //Date object
	     long time = date.getTime();  //getTime() returns current time in milliseconds
	     Timestamp ts = new Timestamp(time); //Passed the milliseconds to constructor of Timestamp class 
	     SimpleDateFormat   sdf = new SimpleDateFormat("yyyy-MM-dd");// hh:mm:ss a");
		 String formattedDate = sdf.format(date);//format takes the dateobj and prints the formatted date as String 
		 java.sql.Date sqlDate = java.sql.Date.valueOf( formattedDate );
		 return ts;
	}}
		




		
	



