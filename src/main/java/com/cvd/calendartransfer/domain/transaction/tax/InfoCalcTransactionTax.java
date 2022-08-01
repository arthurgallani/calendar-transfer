package com.cvd.calendartransfer.domain.transaction.tax;

import java.util.Date;

import com.cvd.calendartransfer.domain.Value;

public interface InfoCalcTransactionTax {

	Date getCurrentDate();

	Value getRequestValue();

	Date getExecutionDate();

}