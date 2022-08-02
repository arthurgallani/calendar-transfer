package com.cvd.calendartransfer.domain.transaction.tax;

import static org.junit.jupiter.api.Assertions.*;

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


@DisplayName("Test rule tax until ten days transfer tax")
class UntilTenDaysDateSchedulingTransferTest {

	private UntilTenDaysDateSchedulingTransfer untilTenDaysDateSchedulingTransfer;
	
	@Mock
	private TransactionTax nextTaxRule;
	
	@Mock
	private InfoCalcTransactionTax infoCalcTransactionTax;
	
	

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		
		untilTenDaysDateSchedulingTransfer = new UntilTenDaysDateSchedulingTransfer(null);
		untilTenDaysDateSchedulingTransfer.setInfoCalcTransactionTax(infoCalcTransactionTax);
	}

	@Test
	void testOneDayUntinDateTransferAndDateSchedule() {
		
		// Data configuration
		var requestValue = Value.builder().number(100).type(ValueType.CREDIT).build();
		var dt = LocalDate.now();
		var qtdeDays = 1;
		var currentDate = Date.from(dt.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		var executionDate = Date.from(dt.plusDays(qtdeDays).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		
		var value = 100.0 ;
		var fixTax = 12;
		var sumValue = fixTax * qtdeDays;
		var valueTaxInit = Value.ZERO;
		
		Mockito.when(infoCalcTransactionTax.getRequestValue()).thenReturn(requestValue);

		Mockito.when(infoCalcTransactionTax.getCurrentDate()).thenReturn(currentDate);
		
		Mockito.when(infoCalcTransactionTax.getExecutionDate()).thenReturn(executionDate);
		
		// Execution
		var valueTax = untilTenDaysDateSchedulingTransfer.configTax(valueTaxInit);

		// Validations
		assertNotNull(valueTax);
		assertEquals(sumValue, valueTax.getNumber());
		assertEquals(value >= 0 ? ValueType.CREDIT : ValueType.CREDIT, valueTax.getType());
		
	}
	
	@Test
	void testNineDayUntinDateTransferAndDateSchedule() {
		
		// Data configuration
		var requestValue = Value.builder().number(100).type(ValueType.CREDIT).build();
		var dt = LocalDate.now();
		var qtdeDays = 9;
		var currentDate = Date.from(dt.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		var executionDate = Date.from(dt.plusDays(qtdeDays).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		
		var value = 100.0 ;
		var fixTax = 12;
		var sumValue = fixTax * qtdeDays;
		var valueTaxInit = Value.ZERO;
		
		Mockito.when(infoCalcTransactionTax.getRequestValue()).thenReturn(requestValue);

		Mockito.when(infoCalcTransactionTax.getCurrentDate()).thenReturn(currentDate);
		
		Mockito.when(infoCalcTransactionTax.getExecutionDate()).thenReturn(executionDate);
		
		// Execution
		var valueTax = untilTenDaysDateSchedulingTransfer.configTax(valueTaxInit);

		// Validations
		assertNotNull(valueTax);
		assertEquals(sumValue, valueTax.getNumber());
		assertEquals(value >= 0 ? ValueType.CREDIT : ValueType.CREDIT, valueTax.getType());
		
	}
	
	@Test
	void testTenDayUntinDateTransferAndDateSchedule() {
		
		// Data configuration
		var requestValue = Value.builder().number(100).type(ValueType.CREDIT).build();
		var dt = LocalDate.now();
		var qtdeDays = 10;
		var currentDate = Date.from(dt.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		var executionDate = Date.from(dt.plusDays(qtdeDays).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		
		var value = 100.0 ;
		var fixTax = 12;
		var sumValue = fixTax * qtdeDays;
		var valueTaxInit = Value.ZERO;
		
		Mockito.when(infoCalcTransactionTax.getRequestValue()).thenReturn(requestValue);

		Mockito.when(infoCalcTransactionTax.getCurrentDate()).thenReturn(currentDate);
		
		Mockito.when(infoCalcTransactionTax.getExecutionDate()).thenReturn(executionDate);
		
		// Execution
		var valueTax = untilTenDaysDateSchedulingTransfer.configTax(valueTaxInit);

		// Validations
		assertNotNull(valueTax);
		assertEquals(sumValue, valueTax.getNumber());
		assertEquals(value >= 0 ? ValueType.CREDIT : ValueType.CREDIT, valueTax.getType());
		
	}
	
	@Test
	void testElevenDayUntinDateTransferAndDateSchedule() {
		
		// Data configuration
		var requestValue = Value.builder().number(100).type(ValueType.CREDIT).build();
		var dt = LocalDate.now();
		var qtdeDays = 11;
		var currentDate = Date.from(dt.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		var executionDate = Date.from(dt.plusDays(qtdeDays).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		
		var value = 100.0 ;
		var valueTaxInit = Value.ZERO;
		
		Mockito.when(infoCalcTransactionTax.getRequestValue()).thenReturn(requestValue);

		Mockito.when(infoCalcTransactionTax.getCurrentDate()).thenReturn(currentDate);
		
		Mockito.when(infoCalcTransactionTax.getExecutionDate()).thenReturn(executionDate);
		
		// Execution
		var valueTax = untilTenDaysDateSchedulingTransfer.configTax(valueTaxInit);

		// Validations
		assertNotNull(valueTax);
		assertEquals(0.0, valueTax.getNumber());
		assertEquals(value >= 0 ? ValueType.CREDIT : ValueType.CREDIT, valueTax.getType());
		
	}
	
}
