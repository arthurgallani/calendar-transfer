package com.cvd.calendartransfer.domain;

import com.cvd.calendartransfer.domain.transaction.TransactionType;

public interface FinancialRequest {
	
	public TransactionType type();
	
}
