package com.cvd.calendartransfer.gateway.converter.impl;

import java.sql.Timestamp;
import java.util.List;

import com.cvd.calendartransfer.domain.Account;
import com.cvd.calendartransfer.domain.Value;
import com.cvd.calendartransfer.domain.ValueType;
import com.cvd.calendartransfer.domain.transaction.FinancialTransaction;
import com.cvd.calendartransfer.domain.transaction.TransactionType;
import com.cvd.calendartransfer.domain.transaction.transfer.Transfer;
import com.cvd.calendartransfer.domain.transaction.transfer.TransferComplete;
import com.cvd.calendartransfer.gateway.converter.TransferConverter;
import com.cvd.calendartransfer.gateway.database.entity.TransactionEntity;

import org.springframework.stereotype.Component;

@Component
public class TransferConverterImpl implements TransferConverter {

	@Override
	public TransactionEntity convert(final FinancialTransaction transferComplete) {
		var transfer = transferComplete.getTransfer();
		return TransactionEntity.builder()
				.accountFrom(transfer.getAccountFrom().getNrAccount())
				.accountTo(transfer.getAccountTo().getNrAccount())
				.executionDate(Timestamp.from(transfer.getDateExecution().toInstant()))
				.currentDate(Timestamp.from(transfer.getDateSchedule().toInstant()))
				.value(transfer.getValue().getType().getValueCalc(transfer.getValue().getNumber()))
				.typeValue(transfer.getValue().getType().name())
				.typeTransaction(transfer.getType().name())
				.build();
	}

	@Override
	public FinancialTransaction convert(final TransactionEntity transferEntity) {
		return TransferComplete.builder() 
				.transfer( Transfer.builder()
						.accountFrom(Account.builder().nrAccount(transferEntity.getAccountFrom()).build())
						.accountTo(Account.builder().nrAccount(transferEntity.getAccountTo()).build())
						.dateExecution(transferEntity.getExecutionDate())
						.dateSchedule(transferEntity.getCurrentDate())
						.type(TransactionType.valueOf(transferEntity.getTypeTransaction()))
						.value(Value.builder()
								.number(transferEntity.getValue())
								.type(ValueType.valueOf(transferEntity.getTypeValue()))
								.build())
						.build())
				.tax(Value.builder()
						.number(transferEntity.getValue())
						.type(ValueType.getByValue(transferEntity.getValue()))
						.build())
				.build();
	}

	@Override
	public List<FinancialTransaction> convert(final List<TransactionEntity> transferEntitys) {
		return transferEntitys.stream()
				.map(t-> convert(t))
				.toList();
	}

	
}
