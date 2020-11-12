package com.bankapp.main;

import org.apache.log4j.Logger;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import com.bankapp.dao.BankDAO;
import com.bankapp.dao.dbutilities.QueriesPlayer;
import com.bankapp.dao.impl.BankDAOImpl;
import com.bankapp.exception.BusinessException;
import com.bankapp.model.Accounts;
import com.bankapp.model.Customer;
import com.bankapp.model.LogTable;
import com.bankapp.service.BankService;
import com.bankapp.service.impl.BankServiceImpl;



public class BankMain {
		
				public static void main(String[] args)  {
				//private static Logger log = Logger.getLogger(BankMain.class);
				Logger log = Logger.getLogger(BankMain.class);
				Scanner scanner= new Scanner(System.in);
				
				log.info("--------------------------------");
				log.info(" Welcome to Zion Banking Service");
				log.info("---------------------------------");
				int ch=0;
				BankDAO bankAcc = new BankDAOImpl();
				BankService bankService = new BankServiceImpl();
				
				
				do {
					
					log.info("Press 1.  For Customer/User Login");
					log.info("Press 2.  For Employee Login");
					log.info("Press 3.  To Exit Banking Service");
					log.info("Please enter appropriate choices(1 to 3)");
					
					try {
						
					ch= Integer.parseInt(scanner.nextLine());
					}catch(NumberFormatException e){
						log.debug("Application exits if don't use your choices between 1 to 3\n"+e);
						break;
					}
					
					switch(ch) {
					case 1:
						log.info("Press 1. For New Customer Login ");
						log.info("Press 2. For Customer Login");
						try {
							Customer cust = new Customer();
							Accounts account = new Accounts();
							ch= Integer.parseInt(scanner.nextLine());
							if(ch==1) {
								
								log.info("Please enter your first name");
								String firstname = scanner.nextLine();
								cust.setFirstname(firstname);
								log.info("Please enter your last name");
								String lastname = scanner.nextLine();
								cust.setLastname(lastname);
								log.info("Please enter your middle initial");
								String middleInitial = scanner.nextLine();
								cust.setMiddleInitial(middleInitial);
								
								log.info("Please enter your Date of Birth as yyyy-MM-dd");
								String dateOfBirth = scanner.nextLine();
								cust.setDateOfBirth(dateOfBirth);
								
								log.info("Please enter your street");
								String street = scanner.nextLine();
								cust.setStreet(street);
								log.info("Please enter your city");
								String city = scanner.nextLine();
								cust.setCity(city);
								log.info("Please enter your state");
								String state = scanner.nextLine();
								cust.setState(state);
								
								log.info("Please enter your zipcode");
								Integer zip = Integer.parseInt(scanner.nextLine());
								cust.setZip(zip);
								
								log.info("Please enter your phone number");
								Integer phoneStr = Integer.parseInt(scanner.nextLine());
								cust.setPhone(phoneStr);
								
								log.info("Please enter your valid email address");
								String email = scanner.nextLine();
								cust.setEmail(email);
								
								log.info("Do you want to enter Savings Account or Checking Account");
								String accountype = scanner.nextLine();
								account.setAccountype(accountype);
								
								log.info("Please enter your initial balance amount");
								Double balance = Double.parseDouble(scanner.nextLine());
								account.setBalance(balance);
								
								bankService.ValidateCustomerCreation(cust, account);
								
								 						

							}else if(ch==2) {
								log.info("=================================");
								log.info("Customer options are given below");
								log.info("==================================");
								log.info("Press 1. To View Your Balance");
								log.info("Press 2. For Depositing the Amount");
								log.info("Press 3. For Withdrawing the Amount");
								log.info("Press 4. Transferring Amount from Saving/Checking to Checking/Saving");
								log.info("Press 5. Transferring Amount to your Friends Account");
								int i= Integer.parseInt(scanner.nextLine());
								switch(i) {
								case 1:log.info("Enter Your Account No to view your balance");
								
								Integer accountno = Integer.parseInt(scanner.nextLine());
										
								
								Double balance = bankService.viewBalanceOnAccountNumber(accountno);
										log.info(" Your Current Balance is "+balance);
								break;
								case 2: log.info("Please enter your Account no to deposit the amount");
								
								log.info("Enter Your Account No ");
								
								Integer accountNum = Integer.parseInt(scanner.nextLine());
								log.info("Please Enter the Amount to be deposited");	
								Double amt = Double.parseDouble(scanner.nextLine());
								Double currentBalance = bankService.makeADepositOnAccountNumber(accountNum, amt);
								log.info("Your Current Balance after depositing is "+currentBalance);
								break;
								case 3: log.info("Please enter your Account no to withdraw the amount");
								
								log.info("Enter Your Account No ");
								
								Integer acountNum = Integer.parseInt(scanner.nextLine());
							    log.info("Please Enter the Amount to be withdrawn");	
								Double amount = Double.parseDouble(scanner.nextLine());
							//	bankAcc.makeAWithdrawalOnAccountNumber(acountNum, amount);
								bankService.makeAWithdrawalOnAccountNumber(acountNum,amount);
								break;
								
								case 4: log.info("Trasferring Amount from Savings/Checking to Checking/Savings");
										log.info("Enter Your Savings Account No ");
										Integer acountNo = Integer.parseInt(scanner.nextLine());
								log.info("Please Enter the Amount to be Transferred");
								Double amont = Double.parseDouble(scanner.nextLine());
								log.info("Enter Your Checking Account No to transfer the amount  $"+amont);
								Integer acountNo1 = Integer.parseInt(scanner.nextLine());
								bankService.makeAMoneyTransferToSavingsOrCheckingAccount(acountNo, acountNo1, amont);
						
								break;
								case 5: log.info("Transfering Money to Another Account");
								log.info(" Please Enter your Account No:");
								Integer acctNo = Integer.parseInt(scanner.nextLine());
								log.info("Please Enter the Amount to be Transferred");
								Double amnt = Double.parseDouble(scanner.nextLine());
								log.info("Enter Account Number to Transfer the amount $ "+amnt );
								Integer acctNo1 = Integer.parseInt(scanner.nextLine());
								bankAcc.makeMoneyTransferToAnotherAccount(acctNo, acctNo1, amnt);
						
								break;
								default: log.debug("Your choices are 1 to 5");
								break;
								
								}}					
								
						}catch(NumberFormatException e){
								log.debug("Application exits if don't use valid number.\n "+e);
						}
							 catch(BusinessException e) {
							log.debug("business exception  "+e);
							e.printStackTrace();
						}
						catch(DateTimeParseException e)
						{       log.debug("Invalid Date: Please enter Valid Date: "+e);
						}
						
						break;
					case 2: 
						log.info("=================================");
						log.info("Employee options are given below");
						log.info("==================================");
						log.info("Press 1. To view a log of all transactions");
						log.info("Press 2. To view Customer's account details based on account number");
						log.info("==================================");
						int j= Integer.parseInt(scanner.nextLine());
						if(j==1) {
							log.info("Viewing  a log of All Transactions");
						 try {
								List<LogTable> loglist = bankAcc.viewLogOfAllTransactions();
								if( loglist!= null && loglist.size()>0) {
									for(LogTable l:loglist) {
										log.info(l);
									}}}
							 catch (BusinessException e) {
								log.debug(e.getMessage());
							}break;
						 
						 
						}else if (j==2) {
							log.info("Viewing Customer Account Details based on Account Number");
							log.info("Please enter Account No to view Account Details.");
							Integer acctNo = Integer.parseInt(scanner.nextLine());
							try {
								 Accounts account1 = bankAcc.viewCustomerBankAccounts(acctNo);
								 log.debug("Account Details of "+ acctNo+ "  Account Number are \n"  + account1);
							} catch (BusinessException e) {
								
								e.printStackTrace();
								log.debug("e= "+e);
							}
						}
						break;
					
					case 3:log.info("Thank you for using this application\n\n");
						break;
					default:log.debug("Invalid number please enter 1 to 3\n\n");
						break;
					}
					break;
				} while( ch != 3);

			}

		}


