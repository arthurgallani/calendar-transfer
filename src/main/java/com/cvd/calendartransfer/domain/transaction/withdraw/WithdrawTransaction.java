package com.cvd.calendartransfer.domain.transaction.withdraw;

import com.cvd.calendartransfer.domain.transaction.RequestTransaction;
import com.cvd.calendartransfer.domain.transaction.TransactionAbstract;
import com.cvd.calendartransfer.domain.transaction.tax.TransactionTax;
import com.cvd.calendartransfer.domain.transaction.tax.WithoutTransferTax;

public abstract class WithdrawTransaction extends TransactionAbstract {

	@Override
	public TransactionTax getTaxRules() {
		return new WithoutTransferTax(null);
	}

	@Override
	public RequestTransaction getRequestTransaction() {
		return RequestTransactionWithdraw.builder()
				.requestAccountFrom(getAccountFrom())
				.requestValue(getValue())
				.build();
	}
	
}
