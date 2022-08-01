package com.cvd.calendartransfer.useCase;

import java.util.List;

import com.cvd.calendartransfer.domain.transaction.FinancialTransaction;

public interface GetAllTransferCase {
	
	public List<FinancialTransaction> execute();

}
