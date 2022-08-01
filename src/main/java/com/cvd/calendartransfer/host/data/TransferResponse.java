package com.cvd.calendartransfer.host.data;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TransferResponse {

	private long id;
	private Integer accountFrom;
	private Integer accountTo;
	private Double value;
	private String valueType;
	private String transactionType;
	private Double valueTax;
	private Double sumValue;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dateTransfer;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	
	private Date dateSchedule;
	private Double balance;
	
}
