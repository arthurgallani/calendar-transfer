package com.cvd.calendartransfer.domain.transaction.transfer;

import com.cvd.calendartransfer.domain.transaction.RequestTransaction;
import com.cvd.calendartransfer.domain.transaction.TransactionAbstract;
import com.cvd.calendartransfer.domain.transaction.tax.RegressiveTaxOfCreditTransferDate;
import com.cvd.calendartransfer.domain.transaction.tax.SameDayTransferTax;
import com.cvd.calendartransfer.domain.transaction.tax.TransactionTax;
import com.cvd.calendartransfer.domain.transaction.tax.UntilTenDaysDateSchedulingTransfer;

public abstract class TransferTransaction extends TransactionAbstract {
	
	@Override
	public TransactionTax getTaxRules() {
		return new SameDayTransferTax(
				new UntilTenDaysDateSchedulingTransfer(
						new RegressiveTaxOfCreditTransferDate()));
	}
	
	@Override
	public RequestTransaction getRequestTransaction() {
		return RequestTransactionTransfer.builder()
				.requestAccountFrom(getAccountFrom())
				.requestAccountTo(getAccountTo())
				.requestValue(getValue())
				.executionDate(getDateExecution())
				.build();
	}
	
}
