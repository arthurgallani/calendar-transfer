package com.cvd.calendartransfer.host.converter.impl;

import java.util.List;

import com.cvd.calendartransfer.domain.transaction.FinancialTransaction;
import com.cvd.calendartransfer.host.converter.TransferResponseConverter;
import com.cvd.calendartransfer.host.data.TransferResponse;

import org.springframework.stereotype.Component;

@Component
public class TransferResponseConverterImpl implements TransferResponseConverter {

	@Override
	public TransferResponse convert(final FinancialTransaction transaction) {
		var transfer = transaction.getTransfer();
		return TransferResponse.builder()
				.accountFrom(transfer.getAccountFrom().getNrAccount())
				.accountTo(transfer.getAccountTo().getNrAccount())
				.dateTransfer(transfer.getDateExecution())
				.dateSchedule(transfer.getDateSchedule())
				.value(transfer.getValue().getType().getValueCalc(transfer.getValue().getNumber()))
				.valueType(transfer.getValue().getType().getSimbol())
				.id(transfer.getId())
				.transactionType(transfer.getRequestTransaction().getType().getDesc())
				.sumValue(transfer.getSumValue().getNumber())
				.valueTax(transfer.getTax().getNumber())
				.id(transfer.getId())
				.balance(0.0)
				.build();
	}
	

	@Override
	public List<TransferResponse> convert(final List<FinancialTransaction> transactions) {
		return transactions.stream()
				.map(t-> convert(t))
				.toList();
	}
	
	
	

}
