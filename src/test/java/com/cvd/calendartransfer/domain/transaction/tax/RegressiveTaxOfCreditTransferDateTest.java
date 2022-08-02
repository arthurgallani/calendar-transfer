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


@DisplayName("Test rule tax value credit transfer tax")
class RegressiveTaxOfCreditTransferDateTest {


	private RegressiveTaxOfCreditTransferDate regressiveTaxOfCreditTransferDate;
	
	@Mock
	private TransactionTax nextTaxRule;
	
	@Mock
	private InfoCalcTransactionTax infoCalcTransactionTax;
	
	
	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		
		regressiveTaxOfCreditTransferDate = new RegressiveTaxOfCreditTransferDate();
		regressiveTaxOfCreditTransferDate.setInfoCalcTransactionTax(infoCalcTransactionTax);
	}

	@Test
	void testValueNegative() {
		
		// Data configuration
		var value = -1 ;
		var requestValue = Value.builder().number(value).type(ValueType.DEBIT).build();
		var dt = LocalDate.now();
		var qtdeDays = 15;
		var currentDate = Date.from(dt.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		var executionDate = Date.from(dt.plusDays(qtdeDays).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		
		var valueTaxInit = Value.ZERO;
		
		Mockito.when(infoCalcTransactionTax.getRequestValue()).thenReturn(requestValue);

		Mockito.when(infoCalcTransactionTax.getCurrentDate()).thenReturn(currentDate);
		
		Mockito.when(infoCalcTransactionTax.getExecutionDate()).thenReturn(executionDate);
		
		// Execution
		var valueTax = regressiveTaxOfCreditTransferDate.configTax(valueTaxInit);

		// Validations
		assertNotNull(valueTax);
		assertEquals(0.0, valueTax.getNumber());
		assertEquals(value >= 0 ? ValueType.CREDIT : ValueType.CREDIT, valueTax.getType());
		
	}
	
	@Test
	void testValuePositiveRegressiveFromTenToTwentyDays() {
		
		// Data configuration
		var value = 0 ;
		var requestValue = Value.builder().number(value).type(ValueType.DEBIT).build();
		var dt = LocalDate.now();
		var qtdeDays = 15;
		var currentDate = Date.from(dt.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		var executionDate = Date.from(dt.plusDays(qtdeDays).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		
		var tax = 0.08;
		var sumValue = value * tax;
		var valueTaxInit = Value.ZERO;
		
		Mockito.when(infoCalcTransactionTax.getRequestValue()).thenReturn(requestValue);

		Mockito.when(infoCalcTransactionTax.getCurrentDate()).thenReturn(currentDate);
		
		Mockito.when(infoCalcTransactionTax.getExecutionDate()).thenReturn(executionDate);
		
		// Execution
		var valueTax = regressiveTaxOfCreditTransferDate.configTax(valueTaxInit);

		// Validations
		assertNotNull(valueTax);
		assertEquals(sumValue, valueTax.getNumber());
		assertEquals(value >= 0 ? ValueType.CREDIT : ValueType.CREDIT, valueTax.getType());
		
	}
	
	@Test
	void testValuePositiveRegressiveFromTwentyToThirtyDays() {
		
		// Data configuration
		var value = 0 ;
		var requestValue = Value.builder().number(value).type(ValueType.DEBIT).build();
		var dt = LocalDate.now();
		var qtdeDays = 25;
		var currentDate = Date.from(dt.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		var executionDate = Date.from(dt.plusDays(qtdeDays).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		
		var tax = 0.06;
		var sumValue = value * tax;
		var valueTaxInit = Value.ZERO;
		
		Mockito.when(infoCalcTransactionTax.getRequestValue()).thenReturn(requestValue);

		Mockito.when(infoCalcTransactionTax.getCurrentDate()).thenReturn(currentDate);
		
		Mockito.when(infoCalcTransactionTax.getExecutionDate()).thenReturn(executionDate);
		
		// Execution
		var valueTax = regressiveTaxOfCreditTransferDate.configTax(valueTaxInit);

		// Validations
		assertNotNull(valueTax);
		assertEquals(sumValue, valueTax.getNumber());
		assertEquals(value >= 0 ? ValueType.CREDIT : ValueType.CREDIT, valueTax.getType());
		
	}
	

	@Test
	void testValuePositiveRegressiveFromThirtyToFortyDays() {
		
		// Data configuration
		var value = 0 ;
		var requestValue = Value.builder().number(value).type(ValueType.DEBIT).build();
		var dt = LocalDate.now();
		var qtdeDays = 35;
		var currentDate = Date.from(dt.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		var executionDate = Date.from(dt.plusDays(qtdeDays).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		
		var tax = 0.04;
		var sumValue = value * tax;
		var valueTaxInit = Value.ZERO;
		
		Mockito.when(infoCalcTransactionTax.getRequestValue()).thenReturn(requestValue);

		Mockito.when(infoCalcTransactionTax.getCurrentDate()).thenReturn(currentDate);
		
		Mockito.when(infoCalcTransactionTax.getExecutionDate()).thenReturn(executionDate);
		
		// Execution
		var valueTax = regressiveTaxOfCreditTransferDate.configTax(valueTaxInit);

		// Validations
		assertNotNull(valueTax);
		assertEquals(sumValue, valueTax.getNumber());
		assertEquals(value >= 0 ? ValueType.CREDIT : ValueType.CREDIT, valueTax.getType());
		
	}
	


	@Test
	void testValuePositiveRegressiveMoreFortyDaysAndLessThanHandredThousandValue() {
		
		// Data configuration
		var value = 99999.9 ;
		var requestValue = Value.builder().number(value).type(ValueType.DEBIT).build();
		var dt = LocalDate.now();
		var qtdeDays = 45;
		var currentDate = Date.from(dt.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		var executionDate = Date.from(dt.plusDays(qtdeDays).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		
		var valueTaxInit = Value.ZERO;
		
		Mockito.when(infoCalcTransactionTax.getRequestValue()).thenReturn(requestValue);

		Mockito.when(infoCalcTransactionTax.getCurrentDate()).thenReturn(currentDate);
		
		Mockito.when(infoCalcTransactionTax.getExecutionDate()).thenReturn(executionDate);
		
		// Execution
		var valueTax = regressiveTaxOfCreditTransferDate.configTax(valueTaxInit);

		// Validations
		assertNotNull(valueTax);
		assertEquals(0.0, valueTax.getNumber());
		assertEquals(value >= 0 ? ValueType.CREDIT : ValueType.CREDIT, valueTax.getType());
		
	}
	


	@Test
	void testValuePositiveRegressiveMoreFortyDaysAndMoreThanHandredThousandValue() {
		
		// Data configuration
		var value = 100000.1 ;
		var requestValue = Value.builder().number(value).type(ValueType.DEBIT).build();
		var dt = LocalDate.now();
		var qtdeDays = 45;
		var currentDate = Date.from(dt.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		var executionDate = Date.from(dt.plusDays(qtdeDays).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
		
		var tax = 0.02;
		var sumValue = value * tax;
		var valueTaxInit = Value.ZERO;
		
		Mockito.when(infoCalcTransactionTax.getRequestValue()).thenReturn(requestValue);

		Mockito.when(infoCalcTransactionTax.getCurrentDate()).thenReturn(currentDate);
		
		Mockito.when(infoCalcTransactionTax.getExecutionDate()).thenReturn(executionDate);
		
		// Execution
		var valueTax = regressiveTaxOfCreditTransferDate.configTax(valueTaxInit);

		// Validations
		assertNotNull(valueTax);
		assertEquals(sumValue, valueTax.getNumber());
		assertEquals(value >= 0 ? ValueType.CREDIT : ValueType.CREDIT, valueTax.getType());
		
	}
	


}
