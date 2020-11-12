package com.bankapp.service;

import com.bankapp.exception.BusinessException;
import com.bankapp.model.Accounts;
import com.bankapp.model.Customer;

public interface BankService {

		public void ValidateCustomerCreation(Customer cust, Accounts acct) throws BusinessException;
		public double viewBalanceOnAccountNumber(int accountNo) throws BusinessException;
		public void makeAWithdrawalOnAccountNumber(int accountNo, double amount) throws BusinessException;
		double makeADepositOnAccountNumber(int accountNo, Double amount) throws BusinessException;
		public void makeAMoneyTransferToSavingsOrCheckingAccount(Integer acountNo, Integer acountNo1, Double amont) throws BusinessException;
}

