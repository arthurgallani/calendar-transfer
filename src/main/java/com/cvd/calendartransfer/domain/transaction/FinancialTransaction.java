package com.cvd.calendartransfer.domain.transaction;

import com.cvd.calendartransfer.domain.Value;
import com.cvd.calendartransfer.domain.transaction.transfer.Transfer;
import com.cvd.calendartransfer.domain.transaction.transfer.TransferComplete;
import com.cvd.calendartransfer.domain.transaction.withdraw.Withdraw;

public interface FinancialTransaction {

	public Transfer getTransfer();
	public Withdraw getWithdraw();
	public Value getTax();

}