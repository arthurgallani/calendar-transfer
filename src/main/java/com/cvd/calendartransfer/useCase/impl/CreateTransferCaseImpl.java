package com.cvd.calendartransfer.useCase.impl;

import com.cvd.calendartransfer.domain.transaction.FinancialTransaction;
import com.cvd.calendartransfer.domain.transaction.Transaction;
import com.cvd.calendartransfer.gateway.TransferGateway;
import com.cvd.calendartransfer.useCase.CreateTransferCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateTransferCaseImpl implements CreateTransferCase {

	@Autowired
	private TransferGateway transferGateway;

	@Override
	public FinancialTransaction execute(final Transaction transfer) {
		var transaction = transfer.getTransaction();
		return transferGateway.create(transaction);
	}

}
