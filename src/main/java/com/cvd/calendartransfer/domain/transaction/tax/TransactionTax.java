package com.cvd.calendartransfer.domain.transaction.tax;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import com.cvd.calendartransfer.domain.Value;

import lombok.Data;

@Data
public abstract class TransactionTax implements FinancialTax {
	
	public TransactionTax(final FinancialTax nextTaxRule) {
		if (null != nextTaxRule) {
			nextTaxRule.setInfoCalcTransactionTax(this.infoCalcTransactionTax);
			this.nextTaxRule = nextTaxRule;
		}
	}
	
	private final String FORMAT_DATE = "yyyy-MM-dd";
	protected final LocalDate CURRENT_DATE = LocalDate.now();

	private FinancialTax nextTaxRule;
	private InfoCalcTransactionTax infoCalcTransactionTax;

	public abstract double getValueCalc(final Value value);

	@Override
	public abstract boolean isTaxApplicable();

	@Override
	public Value applyValueTax(final Value value) {
		return Value.builder()
				.number(getValueCalc(value))
				.type(value.getType())
				.build();
	}

	@Override
	public Value configTax(final Value initValue) {
		if (this.isTaxApplicable()) return nextVerify(this.applyValueTax(initValue));
		return initValue;
	}
	
	public Value nextVerify(final Value value) {
		return null != nextTaxRule ? nextTaxRule.configTax(value) : value;
	}

	@Override
	public FinancialTax setNextTax(FinancialTax nextTaxRule) {
		this.nextTaxRule = nextTaxRule;
		return this;
	}
	
	public LocalDate convert(final Date date) {
		return LocalDate.parse(new SimpleDateFormat(FORMAT_DATE).format(date));
	}
	
	public LocalDate getDateTransfer() {
		/* Transfer date */
		return convert(getInfoCalcTransactionTax().getExecutionDate());
	}
	
	public long getDaysDifference() {
		/* Difference days between Transfer date and Current/Scheduling date */
		return ChronoUnit.DAYS.between(CURRENT_DATE, getDateTransfer());
	}
	
	public Value getValueTransaction() {
		return this.infoCalcTransactionTax.getRequestValue();
	}

}