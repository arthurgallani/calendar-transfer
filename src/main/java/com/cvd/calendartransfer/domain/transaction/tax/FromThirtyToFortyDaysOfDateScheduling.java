package com.cvd.calendartransfer.domain.transaction.tax;

public class FromThirtyToFortyDaysOfDateScheduling extends RangeDaysTransactionTax {

	public FromThirtyToFortyDaysOfDateScheduling(TransactionTax nextTaxRule) {
		super(nextTaxRule);
	}
	
	private final int MIN_THIRTY_DAYS = 30;
	private final int MAX_FORTY_DAYS = 40;
	private final double FOUR_PERCENT_TAX_VALUE_TRANSFER = 0.04;

	/* 
	 * More than 30 to 40 days from the scheduling date 
	 * Apply tax of 4% 
	 */
	
	@Override
	Integer getFromDaysRange() {
		return MIN_THIRTY_DAYS;
	}

	@Override
	Integer getToDaysRange() {
		return MAX_FORTY_DAYS;
	}

	@Override
	double getValuePercentTax() {
		return FOUR_PERCENT_TAX_VALUE_TRANSFER;
	}

}
