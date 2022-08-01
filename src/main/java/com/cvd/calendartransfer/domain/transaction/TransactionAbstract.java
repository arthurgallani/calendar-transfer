package com.cvd.calendartransfer.domain.transaction;

import java.util.Date;

import com.cvd.calendartransfer.domain.Account;
import com.cvd.calendartransfer.domain.Value;
import com.cvd.calendartransfer.domain.transaction.tax.TransactionTax;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class TransactionAbstract implements Transaction {

	private FinancialTransactionFactory financialTransactionFactory = new FinancialTransactionFactory();
	
	public abstract TransactionTax getTaxRules();
	public abstract RequestTransaction getRequestTransaction();

	public abstract Account getAccountFrom();
	public abstract Account getAccountTo();
	public abstract Value getValue();
	public abstract Date getDateExecution();

	@Override
	public FinancialTransaction getTransaction() {
		var requestTransaction = getRequestTransaction();
		var taxRules = getTaxRules();
		taxRules.setInfoCalcTransactionTax(requestTransaction);
		
		return financialTransactionFactory.create(requestTransaction, taxRules);
	}
	
	
	
}
