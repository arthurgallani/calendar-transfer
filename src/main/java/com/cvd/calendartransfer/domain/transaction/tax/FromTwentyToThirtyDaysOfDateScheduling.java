package com.cvd.calendartransfer.domain.transaction.tax;

public class FromTwentyToThirtyDaysOfDateScheduling extends RangeDaysTransactionTax {

	public FromTwentyToThirtyDaysOfDateScheduling(TransactionTax nextTaxRule) {
		super(nextTaxRule);
	}

	private final int MIN_TWENTY_DAYS = 20;
	private final int MAX_THIRTY_DAYS = 30;
	private final double SIX_PERCENT_TAX_VALUE_TRANSFER = 0.06;
	
	/* 
	 * More than 20 to 30 days from the scheduling date 
	 * Apply tax of 6% 
	 */
	
	@Override
	Integer getFromDaysRange() {
		return MIN_TWENTY_DAYS;
	}

	@Override
	Integer getToDaysRange() {
		return MAX_THIRTY_DAYS;
	}

	@Override
	double getValuePercentTax() {
		return SIX_PERCENT_TAX_VALUE_TRANSFER;
	}

}
