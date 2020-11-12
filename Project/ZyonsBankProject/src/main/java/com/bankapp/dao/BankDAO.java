package com.bankapp.dao;

import java.util.List;

import com.bankapp.exception.BusinessException;
import com.bankapp.model.Accounts;
import com.bankapp.model.Customer;
import com.bankapp.model.LogTable;

	public interface BankDAO {
		

		public Boolean newCustomerCreation(Customer cust, Accounts account) throws BusinessException;

		public Double viewBalanceOnAccountNumber(Integer accountNo) throws BusinessException;
		public Double makeADepositOnAccountNumber(Integer accountNo, Double amount) throws BusinessException;
		public Double makeAWithdrawalOnAccountNumber(Integer accountNo, Double amount) throws BusinessException;
		public void makeAMoneyTransferToSavingsOrCheckingAccount(Integer accountNo1,Integer accountNo2, Double amount1) throws BusinessException;
		public Double makeMoneyTransferToAnotherAccount(Integer accountNo, Integer accountNo1, Double amount) throws BusinessException;
		
		public void viewLogTableBasedOnAccountNo(Integer accountNo) throws BusinessException;
		public void updatingAccountsTable(Integer customerid, Integer accountno, Double balance, String accountype);
		
		public List<LogTable> viewLogOfAllTransactions() throws BusinessException;
		public Accounts viewCustomerBankAccounts(Integer accountNo) throws BusinessException;
	}




