package com.cvd.calendartransfer.domain.transaction;

import lombok.Getter;

@Getter
public enum TransactionType {

	TRANSFER("T","Transferência"), 
	PAYMENT("P","Pagamento"), 
	WITHDRAW("S","Saque"), 
	DEPOSIT("D","Depósito");
	
	private String simbol;
	private String desc;

	TransactionType(String simbol,String desc) {
		this.simbol = simbol;
		this.desc = desc;
	}

	
}
