package com.cvd.calendartransfer.domain.transaction.tax;

import com.cvd.calendartransfer.domain.Value;

public interface FinancialTax {

	public Value configTax(final Value initValue);
	public Value applyValueTax(final Value value);
	public boolean isTaxApplicable();
	public FinancialTax setNextTax(final FinancialTax nextTaxRule);
	public void setInfoCalcTransactionTax(final InfoCalcTransactionTax infoCalcTransactionTax);
}
