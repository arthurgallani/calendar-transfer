package com.cvd.calendartransfer.host.converter.impl;

import com.cvd.calendartransfer.domain.Account;
import com.cvd.calendartransfer.domain.Value;
import com.cvd.calendartransfer.domain.ValueType;
import com.cvd.calendartransfer.domain.transaction.Transaction;
import com.cvd.calendartransfer.domain.transaction.TransactionType;
import com.cvd.calendartransfer.domain.transaction.transfer.Transfer;
import com.cvd.calendartransfer.host.converter.TransferRequestConverter;
import com.cvd.calendartransfer.host.data.TransferRequest;

import org.springframework.stereotype.Component;

@Component
public class TransferRequestConverterImpl implements TransferRequestConverter {

	@Override
	public Transaction convert(final TransferRequest transferRequest) {
		return Transfer.builder()
				.accountFrom(Account.builder().nrAccount(transferRequest.getAccountFrom()).build())
				.accountTo(Account.builder().nrAccount(transferRequest.getAccountTo()).build())
				.dateExecution(transferRequest.getDateTransfer())
				.type(TransactionType.TRANSFER)
				.value(Value.builder()
						.number(Math.abs(transferRequest.getValue()))
						.type(ValueType.getByValue(transferRequest.getValue()))
						.build())
				.id(null == transferRequest.getId() ? 0 : transferRequest.getId())
				.build();
	}

}
