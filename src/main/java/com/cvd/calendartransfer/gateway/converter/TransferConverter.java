package com.cvd.calendartransfer.gateway.converter;

import java.util.List;

import com.cvd.calendartransfer.domain.transaction.FinancialTransaction;
import com.cvd.calendartransfer.gateway.database.entity.TransactionEntity;

public interface TransferConverter {
	
	public TransactionEntity convert(final FinancialTransaction transfer);
	public FinancialTransaction convert(final TransactionEntity transferEntity);
	public List<FinancialTransaction> convert(final List<TransactionEntity> transferEntitys);

}
