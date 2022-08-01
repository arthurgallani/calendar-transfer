package com.cvd.calendartransfer.gateway.impl;

import java.util.List;

import com.cvd.calendartransfer.domain.transaction.FinancialTransaction;
import com.cvd.calendartransfer.gateway.TransferGateway;
import com.cvd.calendartransfer.gateway.converter.TransferConverter;
import com.cvd.calendartransfer.gateway.database.repository.TransferRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransferGatewayImpl implements TransferGateway {
	
	@Autowired
	private TransferRepository transferRepository;
	@Autowired
	private TransferConverter transferConverter; 
	

	@Override
	public FinancialTransaction create(final FinancialTransaction transfer) {
		return transferConverter.convert(
				transferRepository.save(transferConverter.convert(transfer)));
	}

	@Override
	public List<FinancialTransaction> getAll() {
		return transferConverter.convert(transferRepository.findAll());
	}

	@Override
	public FinancialTransaction get(Integer idTransaction) {
		return transferConverter.convert(transferRepository.findById(idTransaction).get());
	}
	
}
