package com.cvd.calendartransfer.useCase.impl;

import java.util.List;

import com.cvd.calendartransfer.domain.transaction.FinancialTransaction;
import com.cvd.calendartransfer.gateway.TransferGateway;
import com.cvd.calendartransfer.useCase.GetAllTransferCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetAllTransferCaseImpl implements GetAllTransferCase {

	@Autowired
	private TransferGateway transferGateway;
	
	@Override
	public List<FinancialTransaction> execute() {
		return transferGateway.getAll();
	}

}
