package com.cvd.calendartransfer.domain.transaction.transfer;

import static com.cvd.calendartransfer.domain.transaction.TransactionType.TRANSFER;
import java.util.Date;
import com.cvd.calendartransfer.domain.Account;
import com.cvd.calendartransfer.domain.transaction.TransactionType;
import com.cvd.calendartransfer.domain.Value;
import com.cvd.calendartransfer.domain.transaction.RequestTransaction;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RequestTransactionTransfer implements RequestTransaction {

	private final TransactionType type = TRANSFER;
	
	private Account requestAccountFrom;
	private Account requestAccountTo;
	private Value requestValue;
	private Date executionDate;
	
	@Builder.Default
	private final Date currentDate = new Date();
}
