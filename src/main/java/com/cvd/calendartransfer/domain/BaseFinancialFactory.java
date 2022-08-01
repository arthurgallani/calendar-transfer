package com.cvd.calendartransfer.domain;

import com.cvd.calendartransfer.domain.transaction.FinancialTransaction;
import com.cvd.calendartransfer.domain.transaction.RequestTransaction;
import com.cvd.calendartransfer.domain.transaction.tax.FinancialTax;

public abstract class BaseFinancialFactory {
	
	public abstract FinancialTransaction create(final RequestTransaction request, final FinancialTax tax);

}
