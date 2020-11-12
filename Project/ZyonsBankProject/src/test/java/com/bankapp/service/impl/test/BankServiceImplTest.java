package com.bankapp.service.impl.test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.bankapp.dao.impl.BankDAOImpl;
import com.bankapp.exception.BusinessException;
import com.bankapp.model.Accounts;
import com.bankapp.model.Customer;
import com.bankapp.service.impl.BankServiceImpl;

public class BankServiceImplTest {
	
	BankServiceImpl bankService = null;
	
	@Test
	void testValidateCustomerCreation() throws BusinessException {
		Customer cust = new Customer();
		Accounts acc = new Accounts();
		bankService = new BankServiceImpl();
		acc.setBalance(400); 
		bankService.ValidateCustomerCreation(cust, acc);
		
}

	@Test
	void viewBalanceOnAccountNumber() throws NumberFormatException, BusinessException {
		bankService = new BankServiceImpl();
		Double balance = bankService.viewBalanceOnAccountNumber(Integer.valueOf("213"));
		
		assertTrue(balance >500);
	}
	
	@Test
	void makeADepositOnAccountNumber() throws NumberFormatException, BusinessException {
		bankService = new BankServiceImpl();
		Double acBal = bankService.makeADepositOnAccountNumber(Integer.valueOf("213"), Double.valueOf("500"));
		assertNotNull(acBal);
	}
	
	
	@Test
	void makeAWithdrawalOnAccountNumber() throws NumberFormatException, BusinessException {
		bankService = new BankServiceImpl();
		bankService.makeAWithdrawalOnAccountNumber(Integer.valueOf("213"), Double.valueOf("500"));
		
	}

	@Test
	void makeAMoneyTransferToSavingsOrCheckingAccount() throws NumberFormatException, BusinessException {
		bankService = new BankServiceImpl();
		bankService.makeAMoneyTransferToSavingsOrCheckingAccount(Integer.valueOf("213"),Integer.valueOf("90217"), Double.valueOf("500"));
		
	}
}
