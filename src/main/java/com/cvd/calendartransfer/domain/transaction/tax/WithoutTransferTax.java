package com.cvd.calendartransfer.domain.transaction.tax;

import com.cvd.calendartransfer.domain.Value;
import com.cvd.calendartransfer.domain.transaction.tax.TransactionTax;

public class WithoutTransferTax extends TransactionTax {

	public WithoutTransferTax(TransactionTax nextTaxRule) {
		super(nextTaxRule);
	}

	@Override
	public double getValueCalc(Value value) {
		return value.getNumber();
	}

	@Override
	public boolean isTaxApplicable() {
		return true;
	}


}
