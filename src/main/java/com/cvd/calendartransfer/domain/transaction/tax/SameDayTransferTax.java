package com.cvd.calendartransfer.domain.transaction.tax;

import com.cvd.calendartransfer.domain.Value;

public class SameDayTransferTax extends TransactionTax  {

	public SameDayTransferTax(TransactionTax nextTaxRule) {
		super(nextTaxRule);
	}
	
	private final int FIX_TAX = 3;
	private final double PERCENT_TAX_VALUE_TRANSFER = 0.03;
	
	@Override
	public boolean isTaxApplicable() {
		/* Transfers on the same day as the appointment */
		return getDaysDifference() <= 0;
	}

	@Override
	public double getValueCalc(Value value) {
		/* Add a $3 tax */
		var fixTaxApply = value.getNumber() + FIX_TAX;
			
		/* Plus 3% of the amount to be transferred */
		var percentTaxValueTransferApply = value.getNumber() * PERCENT_TAX_VALUE_TRANSFER;
			
		/* Value sum */
		return fixTaxApply + percentTaxValueTransferApply;
	}
	
}
