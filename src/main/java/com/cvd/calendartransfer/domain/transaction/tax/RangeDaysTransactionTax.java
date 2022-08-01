package com.cvd.calendartransfer.domain.transaction.tax;

import com.cvd.calendartransfer.domain.Value;

public abstract class RangeDaysTransactionTax extends TransactionTax {

	public RangeDaysTransactionTax(FinancialTax nextTaxRule) {
		super(nextTaxRule);
	}
	
	abstract Integer getFromDaysRange();
	
	abstract Integer getToDaysRange();
	
	abstract double getValuePercentTax();
	
	private boolean isDefinedFromDaysRange() {
		return null != getFromDaysRange();
	}

	private boolean isDefinedToDaysRange() {
		return null != getToDaysRange();
	}
	
	@Override
	public boolean isTaxApplicable() {
		return (!isDefinedFromDaysRange() || getFromDaysRange() <= getDaysDifference()) && 
				(!isDefinedToDaysRange() || getDaysDifference() <= getToDaysRange());
	}

	@Override
	public double getValueCalc(Value value) {
		return value.getNumber() * getValuePercentTax();
	}

	
	
}
