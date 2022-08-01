package com.cvd.calendartransfer.host.converter;

import java.util.List;

import com.cvd.calendartransfer.domain.transaction.FinancialTransaction;
import com.cvd.calendartransfer.host.data.TransferResponse;

public interface TransferResponseConverter {

	public TransferResponse convert(FinancialTransaction transaction);
	public List<TransferResponse> convert(List<FinancialTransaction> transaction);
	
}
