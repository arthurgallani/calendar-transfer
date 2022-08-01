package com.cvd.calendartransfer.useCase;

import com.cvd.calendartransfer.domain.transaction.FinancialTransaction;
import com.cvd.calendartransfer.domain.transaction.Transaction;

public interface CreateTransferCase {
	
	public FinancialTransaction execute(final Transaction transfer);

}
