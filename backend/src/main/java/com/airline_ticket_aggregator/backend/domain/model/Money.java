package com.airline_ticket_aggregator.backend.domain.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public record Money(BigDecimal amount, String currency) implements Comparable<Money>{

	public Money{

		Objects.requireNonNull(amount, "Amount cannot be null");
		Objects.requireNonNull(currency, "Currency cannot be null");


		if(amount.compareTo(BigDecimal.ZERO) < 0){
			throw new IllegalArgumentException("Money amount cannot be negative");

		}

		amount = amount.setScale(2, RoundingMode.HALF_EVEN);

		
	} 

	public Money plus(Money other){
		if(!this.currency.equals(other.currency)){
			throw new IllegalArgumentException("Cannot sum different currencies");
		};
		return new Money(this.amount.add(other.amount), this.currency);
				
	}	

	public Money multiply(int factor){
		if (factor < 0) {
			throw new IllegalArgumentException("Multiplication factor cannot be negative");
		}

		return new Money(this.amount.multiply(BigDecimal.valueOf(factor)), this.currency);
	}

	@Override
	public int compareTo(Money other){
		Objects.requireNonNull(other, "Other Money cannot be null");
		if (!this.currency.equals(other.currency)) {
			throw new IllegalArgumentException("Cannot compare different currencies");
		}

		return this.amount.compareTo(other.amount);
	}

}