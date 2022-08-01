package com.cvd.calendartransfer.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Value {

	private double number;
	private ValueType type;
}
