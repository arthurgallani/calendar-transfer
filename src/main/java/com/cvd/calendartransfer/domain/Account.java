package com.cvd.calendartransfer.domain;

import com.cvd.calendartransfer.domain.transaction.FinancialTransaction;
import com.cvd.calendartransfer.domain.transaction.Transaction;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Account {

	private int idAccount;
	private int nrAgency;
	private int nrAccount;
	private float valueBalance;
	
	public FinancialTransaction executeTransaction(final Transaction transactionExec) {
		return transactionExec.getTransaction();
	}
	
}
