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



@DisplayName("Test rule tax from ten to twenty days transfer tax")
class FromTenToTwentyDaysOfDateSchedulingTest {

	private FromTenToTwentyDaysOfDateScheduling fromTenToTwentyDaysOfDateScheduling;
	
	@Mock
	private TransactionTax nextTaxRule;
	
	@Mock
	private InfoCalcTransactionTax infoCalcTransactionTax;
	
	
	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		
		fromTenToTwentyDaysOfDateScheduling = new FromTenToTwentyDaysOfDateScheduling(null);
		fromTenToTwentyDaysOfDateScheduling.setInfoCalcTransactionTax(infoCalcTransactionTax);
	}

	@Test
	void testTenDaysDateTransferAndDateSchedule() {
		
		// Data configuration
		var requestValue = Value.builder().number(100).type(ValueType.CREDIT).build();
		var dt = LocalDate.now();
		var qtdeDays = 10;
		var currentDate = Date.from(dt.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		var executionDate = Date.from(dt.plusDays(qtdeDays).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		
		var value = 100.0 ;
		var tax = 0.08;
		var sumValue = value * tax;
		var valueTaxInit = Value.ZERO;
		
		Mockito.when(infoCalcTransactionTax.getRequestValue()).thenReturn(requestValue);

		Mockito.when(infoCalcTransactionTax.getCurrentDate()).thenReturn(currentDate);
		
		Mockito.when(infoCalcTransactionTax.getExecutionDate()).thenReturn(executionDate);
		
		// Execution
		var valueTax = fromTenToTwentyDaysOfDateScheduling.configTax(valueTaxInit);

		// Validations
		assertNotNull(valueTax);
		assertEquals(sumValue, valueTax.getNumber());
		assertEquals(value >= 0 ? ValueType.CREDIT : ValueType.CREDIT, valueTax.getType());
		
	}
	
	@Test
	void testNineDaysDateTransferAndDateSchedule() {
		
		// Data configuration
		var requestValue = Value.builder().number(100).type(ValueType.CREDIT).build();
		var dt = LocalDate.now();
		var qtdeDays = 9;
		var currentDate = Date.from(dt.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		var executionDate = Date.from(dt.plusDays(qtdeDays).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		
		var value = 100.0 ;
		var valueTaxInit = Value.ZERO;
		
		Mockito.when(infoCalcTransactionTax.getRequestValue()).thenReturn(requestValue);

		Mockito.when(infoCalcTransactionTax.getCurrentDate()).thenReturn(currentDate);
		
		Mockito.when(infoCalcTransactionTax.getExecutionDate()).thenReturn(executionDate);
		
		// Execution
		var valueTax = fromTenToTwentyDaysOfDateScheduling.configTax(valueTaxInit);

		// Validations
		assertNotNull(valueTax);
		assertEquals(0.0, valueTax.getNumber());
		assertEquals(value >= 0 ? ValueType.CREDIT : ValueType.CREDIT, valueTax.getType());
		
	}
	
	@Test
	void testTwentyDaysDateTransferAndDateSchedule() {
		
		// Data configuration
		var requestValue = Value.builder().number(100).type(ValueType.CREDIT).build();
		var dt = LocalDate.now();
		var qtdeDays = 20;
		var currentDate = Date.from(dt.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		var executionDate = Date.from(dt.plusDays(qtdeDays).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		
		var value = 100.0 ;
		var tax = 0.08;
		var sumValue = value * tax;
		var valueTaxInit = Value.ZERO;
		
		Mockito.when(infoCalcTransactionTax.getRequestValue()).thenReturn(requestValue);

		Mockito.when(infoCalcTransactionTax.getCurrentDate()).thenReturn(currentDate);
		
		Mockito.when(infoCalcTransactionTax.getExecutionDate()).thenReturn(executionDate);
		
		// Execution
		var valueTax = fromTenToTwentyDaysOfDateScheduling.configTax(valueTaxInit);

		// Validations
		assertNotNull(valueTax);
		assertEquals(sumValue, valueTax.getNumber());
		assertEquals(value >= 0 ? ValueType.CREDIT : ValueType.CREDIT, valueTax.getType());
		
	}
	
	@Test
	void testTwentyOneDaysDateTransferAndDateSchedule() {
		
		// Data configuration
		var requestValue = Value.builder().number(100).type(ValueType.CREDIT).build();
		var dt = LocalDate.now();
		var qtdeDays = 21;
		var currentDate = Date.from(dt.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		var executionDate = Date.from(dt.plusDays(qtdeDays).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		
		var value = 100.0 ;
		var valueTaxInit = Value.ZERO;
		
		Mockito.when(infoCalcTransactionTax.getRequestValue()).thenReturn(requestValue);

		Mockito.when(infoCalcTransactionTax.getCurrentDate()).thenReturn(currentDate);
		
		Mockito.when(infoCalcTransactionTax.getExecutionDate()).thenReturn(executionDate);
		
		// Execution
		var valueTax = fromTenToTwentyDaysOfDateScheduling.configTax(valueTaxInit);

		// Validations
		assertNotNull(valueTax);
		assertEquals(0.0, valueTax.getNumber());
		assertEquals(value >= 0 ? ValueType.CREDIT : ValueType.CREDIT, valueTax.getType());
		
	}
	
}
