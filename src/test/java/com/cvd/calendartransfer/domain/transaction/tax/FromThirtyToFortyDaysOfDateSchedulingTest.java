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


@DisplayName("Test rule tax from thirty to forty days transfer tax")
class FromThirtyToFortyDaysOfDateSchedulingTest {


	private FromThirtyToFortyDaysOfDateScheduling fromThirtyToFortyDaysOfDateScheduling;
	
	@Mock
	private TransactionTax nextTaxRule;
	
	@Mock
	private InfoCalcTransactionTax infoCalcTransactionTax;
	
	
	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		
		fromThirtyToFortyDaysOfDateScheduling = new FromThirtyToFortyDaysOfDateScheduling(null);
		fromThirtyToFortyDaysOfDateScheduling.setInfoCalcTransactionTax(infoCalcTransactionTax);
	}

	@Test
	void testTwentyNineDaysDateTransferAndDateSchedule() {
		
		// Data configuration
		var requestValue = Value.builder().number(100).type(ValueType.CREDIT).build();
		var dt = LocalDate.now();
		var qtdeDays = 29;
		var currentDate = Date.from(dt.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		var executionDate = Date.from(dt.plusDays(qtdeDays).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		
		var value = 100.0 ;
		var valueTaxInit = Value.ZERO;
		
		Mockito.when(infoCalcTransactionTax.getRequestValue()).thenReturn(requestValue);

		Mockito.when(infoCalcTransactionTax.getCurrentDate()).thenReturn(currentDate);
		
		Mockito.when(infoCalcTransactionTax.getExecutionDate()).thenReturn(executionDate);
		
		// Execution
		var valueTax = fromThirtyToFortyDaysOfDateScheduling.configTax(valueTaxInit);

		// Validations
		assertNotNull(valueTax);
		assertEquals(0.0, valueTax.getNumber());
		assertEquals(value >= 0 ? ValueType.CREDIT : ValueType.CREDIT, valueTax.getType());
		
	}
	
	@Test
	void testThirtyDaysDateTransferAndDateSchedule() {
		
		// Data configuration
		var requestValue = Value.builder().number(100).type(ValueType.CREDIT).build();
		var dt = LocalDate.now();
		var qtdeDays = 30;
		var currentDate = Date.from(dt.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		var executionDate = Date.from(dt.plusDays(qtdeDays).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		
		var value = 100.0 ;
		var tax = 0.04;
		var sumValue = value * tax;
		var valueTaxInit = Value.ZERO;
		
		Mockito.when(infoCalcTransactionTax.getRequestValue()).thenReturn(requestValue);

		Mockito.when(infoCalcTransactionTax.getCurrentDate()).thenReturn(currentDate);
		
		Mockito.when(infoCalcTransactionTax.getExecutionDate()).thenReturn(executionDate);
		
		// Execution
		var valueTax = fromThirtyToFortyDaysOfDateScheduling.configTax(valueTaxInit);

		// Validations
		assertNotNull(valueTax);
		assertEquals(sumValue, valueTax.getNumber());
		assertEquals(value >= 0 ? ValueType.CREDIT : ValueType.CREDIT, valueTax.getType());
		
	}

	@Test
	void testFortyeDaysDateTransferAndDateSchedule() {
		
		// Data configuration
		var requestValue = Value.builder().number(100).type(ValueType.CREDIT).build();
		var dt = LocalDate.now();
		var qtdeDays = 40;
		var currentDate = Date.from(dt.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		var executionDate = Date.from(dt.plusDays(qtdeDays).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		
		var value = 100.0 ;
		var tax = 0.04;
		var sumValue = value * tax;
		var valueTaxInit = Value.ZERO;
		
		Mockito.when(infoCalcTransactionTax.getRequestValue()).thenReturn(requestValue);

		Mockito.when(infoCalcTransactionTax.getCurrentDate()).thenReturn(currentDate);
		
		Mockito.when(infoCalcTransactionTax.getExecutionDate()).thenReturn(executionDate);
		
		// Execution
		var valueTax = fromThirtyToFortyDaysOfDateScheduling.configTax(valueTaxInit);

		// Validations
		assertNotNull(valueTax);
		assertEquals(sumValue, valueTax.getNumber());
		assertEquals(value >= 0 ? ValueType.CREDIT : ValueType.CREDIT, valueTax.getType());
		
	}

	@Test
	void testFortyOneDaysDateTransferAndDateSchedule() {
		
		// Data configuration
		var requestValue = Value.builder().number(100).type(ValueType.CREDIT).build();
		var dt = LocalDate.now();
		var qtdeDays = 41;
		var currentDate = Date.from(dt.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		var executionDate = Date.from(dt.plusDays(qtdeDays).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		
		var value = 100.0 ;
		var valueTaxInit = Value.ZERO;
		
		Mockito.when(infoCalcTransactionTax.getRequestValue()).thenReturn(requestValue);

		Mockito.when(infoCalcTransactionTax.getCurrentDate()).thenReturn(currentDate);
		
		Mockito.when(infoCalcTransactionTax.getExecutionDate()).thenReturn(executionDate);
		
		// Execution
		var valueTax = fromThirtyToFortyDaysOfDateScheduling.configTax(valueTaxInit);

		// Validations
		assertNotNull(valueTax);
		assertEquals(0.0, valueTax.getNumber());
		assertEquals(value >= 0 ? ValueType.CREDIT : ValueType.CREDIT, valueTax.getType());
		
	}
	
}
