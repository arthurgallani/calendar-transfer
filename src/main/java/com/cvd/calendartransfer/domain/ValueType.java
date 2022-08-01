package com.cvd.calendartransfer.domain;

import lombok.Getter;

@Getter
public enum ValueType {

	CREDIT("C", "Crédito") {
		public double getValueCalc(double value) {
			return value * 1;
		}	
	}, 
	DEBIT("D", "Débito") {
		public double getValueCalc(double value) {
			return value * -1;
		}
	};
	
	private String simbol;
	private String desc;

	ValueType(String simbol,String desc) {
		this.simbol = simbol;
		this.desc = desc;
	}
	
	public double getValueCalc(double value) {
		return value;
	}
	
	public static ValueType getByValue(double value) {
		return value >= 0 ? ValueType.CREDIT: ValueType.DEBIT;
	}
}
