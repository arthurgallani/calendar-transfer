package com.cvd.calendartransfer.domain.transaction.tax;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import com.cvd.calendartransfer.domain.Value;
import com.cvd.calendartransfer.domain.ValueType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

@DisplayName("Test rule tax same day transfer tax")
class SameDayTransferTaxTest {

	private SameDayTransferTax sameDayTransferTax;
	
	@Mock
	private TransactionTax nextTaxRule;
	
	@Mock
	private InfoCalcTransactionTax infoCalcTransactionTax;
	
	

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		
		sameDayTransferTax = new SameDayTransferTax(null);
		sameDayTransferTax.setInfoCalcTransactionTax(infoCalcTransactionTax);
	}

	@Test
	void testSameDateTransferAndDateSchedule() {
		
		// Data configuration
		var requestValue = Value.builder().number(100).type(ValueType.CREDIT).build();
		var currentDate = new Date();
		
		var value = 100.0 ;
		var tax = value * 0.03;
		var fixTax = 3;
		var sumValue = tax + fixTax;
		var valueTaxInit = Value.ZERO;
		
		Mockito.when(infoCalcTransactionTax.getRequestValue()).thenReturn(requestValue);

		Mockito.when(infoCalcTransactionTax.getCurrentDate()).thenReturn(currentDate);
		
		Mockito.when(infoCalcTransactionTax.getExecutionDate()).thenReturn(currentDate);
		
		// Execution
		var valueTax = sameDayTransferTax.configTax(valueTaxInit);

		// Validations
		assertNotNull(valueTax);
		assertEquals(sumValue, valueTax.getNumber());
		assertEquals(value >= 0 ? ValueType.CREDIT : ValueType.CREDIT, valueTax.getType());
		
	}
	
	@Test
	void testGreaterDateTransferAndDateSchedule() {
		
		// Data configuration
		var requestValue = Value.builder().number(100).type(ValueType.CREDIT).build();
		var dt = LocalDate.now();
		var currentDate = Date.from(dt.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		var executionDate = Date.from(dt.plusDays(1).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		
		var taxZero = 0;
		var valueTaxInit = Value.ZERO;
		
		Mockito.when(infoCalcTransactionTax.getRequestValue()).thenReturn(requestValue);

		Mockito.when(infoCalcTransactionTax.getCurrentDate()).thenReturn(currentDate);
		
		Mockito.when(infoCalcTransactionTax.getExecutionDate()).thenReturn(executionDate);
		
		// Execution
		var valueTax = sameDayTransferTax.configTax(valueTaxInit);

		// Validations
		assertNotNull(valueTax);
		assertEquals(taxZero, valueTax.getNumber());
		assertEquals(ValueType.CREDIT, valueTax.getType());
		
	}

}
