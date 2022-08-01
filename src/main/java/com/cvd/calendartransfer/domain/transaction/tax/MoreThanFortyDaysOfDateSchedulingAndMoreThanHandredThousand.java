package com.cvd.calendartransfer.domain.transaction.tax;

public class MoreThanFortyDaysOfDateSchedulingAndMoreThanHandredThousand extends RangeDaysTransactionTax {

	public MoreThanFortyDaysOfDateSchedulingAndMoreThanHandredThousand(TransactionTax nextTaxRule) {
		super(nextTaxRule);
	}

	private final double MORE_THAN_A_HANDRED_THOUSAND_VALUE = 100000.0;
	private final int MORE_THAN_FORTY_DAYS = 40;
	private final double TWO_PERCENT_TAX_VALUE_TRANSFER = 0.02;
	
	/* 
	 * More than 40 days from the scheduling date and value greater than 100000 value 
	 * Tax of 2% 
	 */
	
	@Override
	Integer getFromDaysRange() {
		return MORE_THAN_FORTY_DAYS;
	}

	@Override
	Integer getToDaysRange() {
		return null;
	}

	@Override
	double getValuePercentTax() {
		return TWO_PERCENT_TAX_VALUE_TRANSFER;
	}

	@Override
	public boolean isTaxApplicable() {
		return getDaysDifference() > MORE_THAN_FORTY_DAYS && 
				getValueTransaction().getNumber() > MORE_THAN_A_HANDRED_THOUSAND_VALUE;
	}

}
