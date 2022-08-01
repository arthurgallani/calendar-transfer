package com.cvd.calendartransfer.gateway;

import java.util.List;

import com.cvd.calendartransfer.domain.transaction.FinancialTransaction;

public interface TransferGateway {
	
	public FinancialTransaction create(final FinancialTransaction transfer);
	public List<FinancialTransaction> getAll();

}
