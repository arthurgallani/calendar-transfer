package com.cvd.calendartransfer.host.data;

import java.util.Date;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TransferRequest {

	private Integer id;
	
	@NotNull(message = "Origin account is required.")
	private Integer accountFrom;
	
	@NotNull(message = "Destination account is required.")
	private Integer accountTo;
	
	@NotNull(message = "Value is required.")
	private Double value;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@FutureOrPresent(message = "Transfer date must be greater than or equal to the current date.")
	private Date dateTransfer;
	
}
