package com.cvd.calendartransfer.domain.transaction.tax;

import com.cvd.calendartransfer.domain.Value;

public class UntilTenDaysDateSchedulingTransfer extends TransactionTax {
	
	public UntilTenDaysDateSchedulingTransfer(TransactionTax nextTaxRule) {
		super(nextTaxRule);
	}
	
	private final int FIX_TAX_TRANSFER = 12;
	private final int DAYS_MAX_TRANSFER = 10;

	@Override
	public boolean isTaxApplicable() {
		/*
		 * Transfers after current/scheduling date 
		 * Transfers until 10 days from the current/scheduling date
		 * */	
		return (getDaysDifference() > 0 || getDaysDifference() <= DAYS_MAX_TRANSFER);
	}

	@Override
	public double getValueCalc(Value value) {
		/*
		 * Tax of $12 multiplied by:
		 * the number of days from the current/scheduling date to the transfer date
		 */
		return (getDaysDifference() * FIX_TAX_TRANSFER) + value.getNumber();
	}
		

}
