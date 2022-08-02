package com.cvd.calendartransfer.domain.transaction;

import com.cvd.calendartransfer.domain.BaseFinancialFactory;
import com.cvd.calendartransfer.domain.Value;
import com.cvd.calendartransfer.domain.ValueType;
import com.cvd.calendartransfer.domain.transaction.tax.FinancialTax;
import com.cvd.calendartransfer.domain.transaction.transfer.RequestTransactionTransfer;
import com.cvd.calendartransfer.domain.transaction.transfer.Transfer;
import com.cvd.calendartransfer.domain.transaction.transfer.TransferComplete;
import com.cvd.calendartransfer.domain.transaction.withdraw.RequestTransactionWithdraw;
import com.cvd.calendartransfer.domain.transaction.withdraw.Withdraw;
import com.cvd.calendartransfer.domain.transaction.withdraw.WithdrawComplete;

public class FinancialTransactionFactory extends BaseFinancialFactory {

	@Override
	public FinancialTransaction create(final RequestTransaction request,final FinancialTax tax) {
	
		if (request instanceof RequestTransactionTransfer requestTransfer) {
			var taxApplicated = tax.configTax(Value.ZERO);
			var sumValue = requestTransfer.getRequestValue().getNumber() + taxApplicated.getNumber();
			return TransferComplete.builder()
					.transfer(Transfer.builder()
							.accountFrom(requestTransfer.getRequestAccountFrom())
							.accountTo(requestTransfer.getRequestAccountTo())
							.dateSchedule(requestTransfer.getCurrentDate())
							.dateExecution(requestTransfer.getExecutionDate())
							.value(requestTransfer.getRequestValue())
							.sumValue(Value.builder()
									.number(sumValue)
									.type(ValueType.getByValue(sumValue))
									.build())
							.type(requestTransfer.getType())
							.tax(taxApplicated)
							.build())
					.tax(taxApplicated)
					
					.build();
	    }
		else if (request instanceof RequestTransactionWithdraw requestWithdraw) {
			return WithdrawComplete.builder()
					.withdraw(Withdraw.builder()
							.accountFrom(requestWithdraw.getRequestAccountFrom())
							.dateExecution(requestWithdraw.getCurrentDate())
							.build())
					.tax(tax.configTax(requestWithdraw.getRequestValue()))
					.build();
	    }
		
		throw new IllegalArgumentException("Unexpected request transaction: " + request.getType());
	}
	

}
