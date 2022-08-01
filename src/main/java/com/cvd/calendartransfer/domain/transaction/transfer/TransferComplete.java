package com.cvd.calendartransfer.domain.transaction.transfer;

import com.cvd.calendartransfer.domain.Value;
import com.cvd.calendartransfer.domain.transaction.FinancialTransaction;
import com.cvd.calendartransfer.domain.transaction.withdraw.Withdraw;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TransferComplete implements FinancialTransaction {

	private Transfer transfer;
	private Value tax;
	
	@Override
	public Withdraw getWithdraw() {
		return null;
	}

}
