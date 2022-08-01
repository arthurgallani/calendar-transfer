package com.cvd.calendartransfer.useCase;

import com.cvd.calendartransfer.domain.transaction.FinancialTransaction;

public interface GetByIdTransferCase {
	
	public FinancialTransaction execute(final Integer idTransaction);

}
