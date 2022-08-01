package com.cvd.calendartransfer.host.converter;

import com.cvd.calendartransfer.domain.transaction.Transaction;
import com.cvd.calendartransfer.host.data.TransferRequest;

public interface TransferRequestConverter {
	
	public Transaction convert(final TransferRequest transferRequest);

}
