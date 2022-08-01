package com.cvd.calendartransfer.domain;

public enum ValueType {

	CREDIT("C") {
		public double getValueCalc(double value) {
			return value * 1;
		}	
	}, 
	DEBIT("D") {
		public double getValueCalc(double value) {
			return value * -1;
		}
	};
	
	private String simbol;

	ValueType(String simbol) {
		this.simbol = simbol;
	}
	
	public double getValueCalc(double value) {
		return value;
	}
	
	public static ValueType getByValue(double value) {
		return value >= 0 ? ValueType.CREDIT: ValueType.DEBIT;
	}
}
