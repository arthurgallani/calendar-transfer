package com.cvd.calendartransfer.domain.transaction.tax;

import com.cvd.calendartransfer.domain.Value;
import com.cvd.calendartransfer.domain.ValueType;

public class RegressiveTaxOfCreditTransferDate extends TransactionTax {
	
	public RegressiveTaxOfCreditTransferDate() {
		super(
				new FromTenToTwentyDaysOfDateScheduling(
						new FromTenToTwentyDaysOfDateScheduling(
								new FromThirtyToFortyDaysOfDateScheduling(
										new MoreThanFortyDaysOfDateSchedulingAndMoreThanHandredThousand(null)))));
	}

	@Override
	public boolean isTaxApplicable() {
		/*Type C operations have a tax*/
		return ValueType.CREDIT == getValueTransaction().getType();
	}

	@Override
	public double getValueCalc(Value value) {
		return value.getNumber();
	}

}
