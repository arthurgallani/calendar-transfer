package com.cvd.calendartransfer.useCase.impl;

import com.cvd.calendartransfer.domain.transaction.FinancialTransaction;
import com.cvd.calendartransfer.gateway.TransferGateway;
import com.cvd.calendartransfer.useCase.GetByIdTransferCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetByIdTransferCaseImpl implements GetByIdTransferCase {

	@Autowired
	private TransferGateway transferGateway;
	
	@Override
	public FinancialTransaction execute(final Integer idTransaction) {
		return transferGateway.get(idTransaction);
	}

}
