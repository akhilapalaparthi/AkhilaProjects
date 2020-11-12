package com.bankapp.dao.impl.test;


import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.bankapp.dao.BankDAO;
import com.bankapp.dao.impl.BankDAOImpl;
import com.bankapp.exception.BusinessException;
import com.bankapp.model.Accounts;
import com.bankapp.model.LogTable;



public class BankDAOImplTest {
	BankDAO bankAcc = null;
	/*
	 * @BeforeAll public void helloBeforeAll() { bankAcc = new BankDAOImpl();
	 * System.out.println("from @BeforeAll");
	 * 
	 * }
	 */
	
			
	/**
	 * @throws NumberFormatException
	 * @throws BusinessException
	 */
	@Test
	void viewBalanceOnAccountNumber() throws NumberFormatException, BusinessException {
		bankAcc = new BankDAOImpl();
		Double balance = bankAcc.viewBalanceOnAccountNumber(Integer.valueOf("213"));
		
		assertTrue(balance >500);
	}

	@Test
	void makeADepositOnAccountNumber() throws NumberFormatException, BusinessException {
		bankAcc = new BankDAOImpl();
		Double balance = bankAcc.viewBalanceOnAccountNumber(Integer.valueOf("213"));
		Double acBal = bankAcc.makeADepositOnAccountNumber(Integer.valueOf("213"), Double.valueOf("500"));
		Double currBal = balance + Double.valueOf("500");
		assertEquals(currBal, acBal);
	}
	
		@Test
		void viewLogOfAllTransactions() throws NumberFormatException, BusinessException {
			bankAcc = new BankDAOImpl();
			List<LogTable> logTable = bankAcc.viewLogOfAllTransactions();
			assertNotNull(logTable);
		}
		@Test
		void viewCustomerBankAccounts() throws NumberFormatException, BusinessException {
			bankAcc = new BankDAOImpl();
			Accounts acct = bankAcc.viewCustomerBankAccounts(Integer.valueOf("213"));
			assertNotNull(acct);
		}
		@Test
		void updatingAccountsTable() throws NumberFormatException, BusinessException {
			bankAcc = new BankDAOImpl();
			bankAcc.updatingAccountsTable(Integer.valueOf("15"), Integer.valueOf("56822"), Double.valueOf("1500"),"ldj");
			
		}
	
	
}
