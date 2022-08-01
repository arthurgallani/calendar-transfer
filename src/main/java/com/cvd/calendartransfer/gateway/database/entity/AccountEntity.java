package com.cvd.calendartransfer.gateway.database.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Entity(name = "tb_account")
public class AccountEntity {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_account")
	private int idAccount;

	@Column(name = "nr_agency")
	private int nrAgency;

	@Column(name = "nr_account")
	private int nrAccount;

	@Column(name = "value_balance")
	private double valueBalance;
	
}
