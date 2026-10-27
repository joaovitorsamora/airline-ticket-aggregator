package com.airline_ticket_aggregator.backend.domain.model;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class MoneyTest {
	private Money money;

	@BeforeEach
	void setUp(){
		BigDecimal amount = new BigDecimal("270.00");


		money = new Money(amount, "BRL");
	}

	@Test
	@DisplayName("Should ensure that amount and currency fields are not null")
	void shouldEnsureThatAmountAndCurrencyFieldsAreNotNull(){
		assertNotNull(money.amount(), "Amount cannot be null");
		assertNotNull(money.currency(), "Currency cannot be null");
	}

	@DisplayName("Should ensure that money amount is not negative")
	void shouldEnsureThatMoneyAmountIsNotNegative(){
		assertTrue(money.amount().compareTo(BigDecimal.ZERO) < 0, "Money amount cannot be negative");
	}

	@DisplayName("Should ensure that money amount has exactly two decimal places when rounded")
	void shouldEnsureMoneyAmountHasExactlyTwoDecimalPlacesWhenRounded(){
		assertEquals(money.amount().setScale(2, RoundingMode.HALF_EVEN), money.amount(), "Money amount need to have exactly two decimal places when rounded");
	}

	@DisplayName("plus() should sum two money amounts of the same currency")
	void shouldSumTwoMoneyAmountsOfTheSameCurrency(){
		BigDecimal amountToPlus = new BigDecimal("100.00");

		BigDecimal amountToCheckResult = new BigDecimal("370.00");

		Money moneyTest =  new Money(amountToPlus, "BRL");

		money.plus(moneyTest);

		assertEquals(amountToCheckResult, money.amount());
	}

	@DisplayName("multiply() should multiply two amounts of money by a non-negative factor")
	void shouldMultiplyTwoAmountsOfMoneyByANonNegativeFactor(){

		BigDecimal amountToCheckResult = new BigDecimal("5400.00");

		int moneyTest = 20;

		assertTrue(moneyTest >= 0, "Factor cannot be negative");

		money.multiply(moneyTest);

		assertEquals(amountToCheckResult, money.amount());
	}


	@DisplayName("compareTo() should compare two amounts of money using the same currency and not null")
	void shouldCompareTwoAmountsOfMoneyUsingTheSameCurrencyAndNotNull(){

		BigDecimal amountTest = new BigDecimal("5400.00");

		Money otherMoney = new Money(amountTest, "USD");

		assertNotNull(otherMoney, "Other money cannot be null");

		assertEquals(otherMoney.currency(), money.currency(), "Cannot compare different currencies");
	}
}