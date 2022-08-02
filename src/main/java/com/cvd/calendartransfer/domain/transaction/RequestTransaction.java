package com.cvd.calendartransfer.domain.transaction;

import com.cvd.calendartransfer.domain.transaction.tax.InfoCalcTransactionTax;

public interface RequestTransaction extends InfoCalcTransactionTax {

	public TransactionType getType();
	
}