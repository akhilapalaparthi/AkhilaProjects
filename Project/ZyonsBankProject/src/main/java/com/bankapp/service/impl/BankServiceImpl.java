package com.bankapp.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.log4j.Logger;

import com.bankapp.dao.BankDAO;
import com.bankapp.dao.impl.BankDAOImpl;
import com.bankapp.exception.BusinessException;
import com.bankapp.model.Accounts;
import com.bankapp.model.Customer;
import com.bankapp.service.BankService;

	

public class BankServiceImpl implements BankService {
	BankDAO bankAcc = new BankDAOImpl();			
	private static Logger log = Logger.getLogger(BankServiceImpl.class);	
		@Override
		public void ValidateCustomerCreation(Customer cust, Accounts acct) throws BusinessException {
			
			if(acct.getBalance()< 500 ) {
				log.info("Sorry! You cannot open an Account as Minimum Balance is 500$.");
			}else {
				Random rand = new Random();
				int accountno = (int) rand.nextInt(100000);
				acct.setAccountno(accountno);
				log.info("Welcome New Customer..Thank you for choosing Zyon Banking Service.");
				log.info("Your New Account Number is "+accountno+ " with a starting balance of "+acct.getBalance()+ "  and Accounttype is "+acct.getAccountype());
				bankAcc.newCustomerCreation(cust, acct);
			}}

		@Override
		public double viewBalanceOnAccountNumber(int accountNo) throws BusinessException {
			Double balance = bankAcc.viewBalanceOnAccountNumber(accountNo);
			return balance;
		}

		@Override
		public double makeADepositOnAccountNumber(int accountNo,Double amount) throws BusinessException {
			double balance = bankAcc.makeADepositOnAccountNumber(accountNo, amount);
			return balance;
		}

		@Override
		public void makeAWithdrawalOnAccountNumber(int accountNo,double amount) throws BusinessException {
			bankAcc.makeAWithdrawalOnAccountNumber(accountNo, amount);
		}

		

		@Override
		public void makeAMoneyTransferToSavingsOrCheckingAccount(Integer acountNo, Integer acountNo1, Double amont) throws BusinessException{
			
			bankAcc.makeAMoneyTransferToSavingsOrCheckingAccount(acountNo, acountNo1, amont);
			
		}
	}


