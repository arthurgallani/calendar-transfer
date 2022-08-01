package com.cvd.calendartransfer.host.data;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TransferResponse {

	private long id;
	private int accountFrom;
	private int accountTo;
	private double value;
	private Date dateTransfer;
	private Date dateSchedule;
	
}
