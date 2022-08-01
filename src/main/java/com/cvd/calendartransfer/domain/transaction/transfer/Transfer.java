package com.cvd.calendartransfer.domain.transaction.transfer;

import java.util.Date;

import com.cvd.calendartransfer.domain.Account;
import com.cvd.calendartransfer.domain.Value;
import com.cvd.calendartransfer.domain.transaction.FinancialTransaction;
import com.cvd.calendartransfer.domain.transaction.FinancialTransactionFactory;
import com.cvd.calendartransfer.domain.transaction.TransactionType;
import com.cvd.calendartransfer.domain.transaction.withdraw.Withdraw;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
public class Transfer extends TransferTransaction {

	private Integer id;
	private Account accountFrom;
	private Account accountTo;
	private Value value;
	private Value sumValue;
	private Date dateExecution;
	private Date dateSchedule;
	
	@Builder.Default
	private final TransactionType type = TransactionType.TRANSFER;
	
	private Value tax;
	
	
}
