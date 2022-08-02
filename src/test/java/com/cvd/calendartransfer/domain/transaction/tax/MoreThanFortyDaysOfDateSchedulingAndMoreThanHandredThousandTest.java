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


@DisplayName("Test rule tax more than forty days transfer tax and more Than handred thousand")
class MoreThanFortyDaysOfDateSchedulingAndMoreThanHandredThousandTest {

	private MoreThanFortyDaysOfDateSchedulingAndMoreThanHandredThousand moreThanFortyDaysOfDateSchedulingAndMoreThanHandredThousand;
	
	@Mock
	private TransactionTax nextTaxRule;
	
	@Mock
	private InfoCalcTransactionTax infoCalcTransactionTax;
	
	
	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		
		moreThanFortyDaysOfDateSchedulingAndMoreThanHandredThousand = new MoreThanFortyDaysOfDateSchedulingAndMoreThanHandredThousand(null);
		moreThanFortyDaysOfDateSchedulingAndMoreThanHandredThousand.setInfoCalcTransactionTax(infoCalcTransactionTax);
	}

	@Test
	void testThirtyNineDaysAndLessThanHandredThousandDateTransferAndDateSchedule() {
		
		// Data configuration
		var value = 99999.9 ;
		var requestValue = Value.builder().number(value).type(ValueType.CREDIT).build();
		var dt = LocalDate.now();
		var qtdeDays = 39;
		var currentDate = Date.from(dt.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		var executionDate = Date.from(dt.plusDays(qtdeDays).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		
		var valueTaxInit = Value.ZERO;
		
		Mockito.when(infoCalcTransactionTax.getRequestValue()).thenReturn(requestValue);

		Mockito.when(infoCalcTransactionTax.getCurrentDate()).thenReturn(currentDate);
		
		Mockito.when(infoCalcTransactionTax.getExecutionDate()).thenReturn(executionDate);
		
		// Execution
		var valueTax = moreThanFortyDaysOfDateSchedulingAndMoreThanHandredThousand.configTax(valueTaxInit);

		// Validations
		assertNotNull(valueTax);
		assertEquals(0.0, valueTax.getNumber());
		assertEquals(value >= 0 ? ValueType.CREDIT : ValueType.CREDIT, valueTax.getType());
		
	}
	
	@Test
	void testFortyDaysAndLessThanHandredThousandDateTransferAndDateSchedule() {
		
		// Data configuration
		var value = 99999.9 ;
		var requestValue = Value.builder().number(value).type(ValueType.CREDIT).build();
		var dt = LocalDate.now();
		var qtdeDays = 40;
		var currentDate = Date.from(dt.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		var executionDate = Date.from(dt.plusDays(qtdeDays).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		
		
		var valueTaxInit = Value.ZERO;
		
		Mockito.when(infoCalcTransactionTax.getRequestValue()).thenReturn(requestValue);

		Mockito.when(infoCalcTransactionTax.getCurrentDate()).thenReturn(currentDate);
		
		Mockito.when(infoCalcTransactionTax.getExecutionDate()).thenReturn(executionDate);
		
		// Execution
		var valueTax = moreThanFortyDaysOfDateSchedulingAndMoreThanHandredThousand.configTax(valueTaxInit);

		// Validations
		assertNotNull(valueTax);
		assertEquals(0.0, valueTax.getNumber());
		assertEquals(value >= 0 ? ValueType.CREDIT : ValueType.CREDIT, valueTax.getType());
		
	}
	
	@Test
	void testFortyDaysAndOneThanHandredThousandDateTransferAndDateSchedule() {
		
		// Data configuration
		var value = 100000 ;
		var requestValue = Value.builder().number(value).type(ValueType.CREDIT).build();
		var dt = LocalDate.now();
		var qtdeDays = 40;
		var currentDate = Date.from(dt.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		var executionDate = Date.from(dt.plusDays(qtdeDays).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		
		
		var valueTaxInit = Value.ZERO;
		
		Mockito.when(infoCalcTransactionTax.getRequestValue()).thenReturn(requestValue);

		Mockito.when(infoCalcTransactionTax.getCurrentDate()).thenReturn(currentDate);
		
		Mockito.when(infoCalcTransactionTax.getExecutionDate()).thenReturn(executionDate);
		
		// Execution
		var valueTax = moreThanFortyDaysOfDateSchedulingAndMoreThanHandredThousand.configTax(valueTaxInit);

		// Validations
		assertNotNull(valueTax);
		assertEquals(0.0, valueTax.getNumber());
		assertEquals(value >= 0 ? ValueType.CREDIT : ValueType.CREDIT, valueTax.getType());
		
	}
	

	@Test
	void testFortyDaysAndMoreThanHandredThousandDateTransferAndDateSchedule() {
		
		// Data configuration
		var value = 100000 ;
		var requestValue = Value.builder().number(value).type(ValueType.CREDIT).build();
		var dt = LocalDate.now();
		var qtdeDays = 40;
		var currentDate = Date.from(dt.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		var executionDate = Date.from(dt.plusDays(qtdeDays).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		
		
		var valueTaxInit = Value.ZERO;
		
		Mockito.when(infoCalcTransactionTax.getRequestValue()).thenReturn(requestValue);

		Mockito.when(infoCalcTransactionTax.getCurrentDate()).thenReturn(currentDate);
		
		Mockito.when(infoCalcTransactionTax.getExecutionDate()).thenReturn(executionDate);
		
		// Execution
		var valueTax = moreThanFortyDaysOfDateSchedulingAndMoreThanHandredThousand.configTax(valueTaxInit);

		// Validations
		assertNotNull(valueTax);
		assertEquals(0.0, valueTax.getNumber());
		assertEquals(value >= 0 ? ValueType.CREDIT : ValueType.CREDIT, valueTax.getType());
		
	}
	

	@Test
	void testFortyOneDaysAndMoreThanHandredThousandDateTransferAndDateSchedule() {
		
		// Data configuration
		var value = 100000.1 ;
		var requestValue = Value.builder().number(value).type(ValueType.CREDIT).build();
		var dt = LocalDate.now();
		var qtdeDays = 41;
		var currentDate = Date.from(dt.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		var executionDate = Date.from(dt.plusDays(qtdeDays).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		
		var tax = 0.02;
		var sumValue = value * tax;
		var valueTaxInit = Value.ZERO;
		
		Mockito.when(infoCalcTransactionTax.getRequestValue()).thenReturn(requestValue);

		Mockito.when(infoCalcTransactionTax.getCurrentDate()).thenReturn(currentDate);
		
		Mockito.when(infoCalcTransactionTax.getExecutionDate()).thenReturn(executionDate);
		
		// Execution
		var valueTax = moreThanFortyDaysOfDateSchedulingAndMoreThanHandredThousand.configTax(valueTaxInit);

		// Validations
		assertNotNull(valueTax);
		assertEquals(sumValue, valueTax.getNumber());
		assertEquals(value >= 0 ? ValueType.CREDIT : ValueType.CREDIT, valueTax.getType());
		
	}
	
	@Test
	void testThirtyNineDaysAndMoreThanHandredThousandDateTransferAndDateSchedule() {
		
		// Data configuration
		var value = 100000.1 ;
		var requestValue = Value.builder().number(value).type(ValueType.CREDIT).build();
		var dt = LocalDate.now();
		var qtdeDays = 40;
		var currentDate = Date.from(dt.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		var executionDate = Date.from(dt.plusDays(qtdeDays).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		
		
		var valueTaxInit = Value.ZERO;
		
		Mockito.when(infoCalcTransactionTax.getRequestValue()).thenReturn(requestValue);

		Mockito.when(infoCalcTransactionTax.getCurrentDate()).thenReturn(currentDate);
		
		Mockito.when(infoCalcTransactionTax.getExecutionDate()).thenReturn(executionDate);
		
		// Execution
		var valueTax = moreThanFortyDaysOfDateSchedulingAndMoreThanHandredThousand.configTax(valueTaxInit);

		// Validations
		assertNotNull(valueTax);
		assertEquals(0.0, valueTax.getNumber());
		assertEquals(value >= 0 ? ValueType.CREDIT : ValueType.CREDIT, valueTax.getType());
		
	}


}
