package com.cvd.calendartransfer.domain.transaction.withdraw;

import com.cvd.calendartransfer.domain.Value;
import com.cvd.calendartransfer.domain.transaction.FinancialTransaction;
import com.cvd.calendartransfer.domain.transaction.transfer.Transfer;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class WithdrawComplete implements FinancialTransaction {

	private Withdraw withdraw;
	private Value tax;
	
	@Override
	public Transfer getTransfer() {
		return null;
	}
	
}
