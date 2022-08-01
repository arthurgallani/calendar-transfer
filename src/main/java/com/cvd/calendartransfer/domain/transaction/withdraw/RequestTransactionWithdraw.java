package com.cvd.calendartransfer.domain.transaction.withdraw;

import static com.cvd.calendartransfer.domain.transaction.TransactionType.WITHDRAW;
import java.util.Date;
import com.cvd.calendartransfer.domain.Account;
import com.cvd.calendartransfer.domain.transaction.TransactionType;
import com.cvd.calendartransfer.domain.Value;
import com.cvd.calendartransfer.domain.transaction.RequestTransaction;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RequestTransactionWithdraw implements RequestTransaction {

	private final TransactionType type = WITHDRAW;
	
	private Account requestAccountFrom;
	private Value requestValue;
	private final Date currentDate = new Date();
	
	@Builder.Default
	private final Date executionDate = new Date();

}
