package com.cvd.calendartransfer.domain.transaction.tax;

public class FromTenToTwentyDaysOfDateScheduling extends RangeDaysTransactionTax {

	public FromTenToTwentyDaysOfDateScheduling(FinancialTax nextTaxRule) {
		super(nextTaxRule);
	}
	
	private final int MIN_TEN_DAYS = 10;
	private final int MAX_TWENTY_DAYS = 20;
	private final double EIGHT_PERCENT_TAX_VALUE_TRANSFER = 0.08;

	/* 
	 * More than 10 to 20 days from the scheduling date 
	 * Apply tax of 8% 
	 */

	@Override
	Integer getFromDaysRange() {
		return MIN_TEN_DAYS;
	}

	@Override
	Integer getToDaysRange() {
		return MAX_TWENTY_DAYS;
	}

	@Override
	double getValuePercentTax() {
		return EIGHT_PERCENT_TAX_VALUE_TRANSFER;
	}

	
}
