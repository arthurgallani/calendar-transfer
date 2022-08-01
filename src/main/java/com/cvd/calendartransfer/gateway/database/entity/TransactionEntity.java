package com.cvd.calendartransfer.gateway.database.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "tb_transaction")
public class TransactionEntity {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_transaction")
	private Integer idTransaction;

	@Nullable
	@Column(name = "account_from")
	private Integer accountFrom;

	@Nullable
	@Column(name = "account_to")
	private Integer accountTo;

	@Column(name = "value_transaction")
	private Double value;
	
	@Column(name = "type_value")
	private String typeValue;
	
	@Column(name = "value_tax")
	private Double valueTax;

	@Column(name = "type_transaction")
	private String typeTransaction;
	
	@Column(name = "dt_execution")
	private Timestamp executionDate;

	@Column(name = "dt_current")
	private Timestamp currentDate;
	
}
