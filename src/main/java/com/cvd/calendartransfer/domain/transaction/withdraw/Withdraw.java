package com.cvd.calendartransfer.domain.transaction.withdraw;

import java.util.Date;

import com.cvd.calendartransfer.domain.Account;
import com.cvd.calendartransfer.domain.Value;
import com.cvd.calendartransfer.domain.transaction.FinancialTransaction;
import com.cvd.calendartransfer.domain.transaction.TransactionType;
import com.cvd.calendartransfer.domain.transaction.transfer.Transfer;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Withdraw extends WithdrawTransaction {

	private long id;

	@Builder.Default
	private Account accountTo = null;
	private Account accountFrom;
	private Value value;
	private Date dateExecution;
	
	@Builder.Default
	private final TransactionType type = TransactionType.WITHDRAW;
	
}