package com.cvd.calendartransfer.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Value {
	
	public static final Value ZERO = Value.builder()
			.number(0)
			.type(ValueType.CREDIT)
			.build();

	private double number;
	private ValueType type;
	
	public double getValueCalc() {
		return this.number < 0 ? this.number * -1 : this.number;
	}
}
