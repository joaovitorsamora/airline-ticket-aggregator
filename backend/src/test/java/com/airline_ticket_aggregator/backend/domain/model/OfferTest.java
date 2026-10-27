package com.airline_ticket_aggregator.backend.domain.model;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OfferTest {
	private Offer offer;


	@BeforeEach
	void setUp(){
		BigDecimal amountAdultPrice = new BigDecimal("100.00");
		BigDecimal amountChildPrice = new BigDecimal("70.00");

		Money adultPrice = new Money(amountAdultPrice, "BRL");
		Money childPrice = new Money(amountChildPrice, "BRL");		
		offer = new Offer("OF-0031", "002dhhd", "Demo Viagens", adultPrice, childPrice, true, "https://ofertaTeste.com.br");
	}

	@Test
	@DisplayName("Should ensure that offer fields are not null")
	void shouldEnsureThatOfferFieldsAreNotNull(){
		assertNotNull(offer.id(), "Offer ID cannot be null");
		assertNotNull(offer.flightId(), "FlightID cannot be null");
		assertNotNull(offer.partner(), "Partner cannot be null");
		assertNotNull(offer.adultPrice(), "AdultPrice cannot be null");
		assertNotNull(offer.childPrice(), "ChildPrice cannot be null");
		assertNotNull(offer.available(), "Available cannot be null");
		assertNotNull(offer.url(), "URL cannot be null");
	}

	@DisplayName("Should ensure that offer ID, flight ID, partner and URL are not blank")
	void shouldEnsureThatOfferIDFlightIDPartnerAndURLAreNotBlank(){
		assertFalse(offer.id().isBlank(), "Offer ID cannot be blank");
		assertFalse(offer.flightId().isBlank(), "FlightID cannot be blank");
		assertFalse(offer.partner().isBlank(), "Partner cannot be blank");
		assertFalse(offer.url().isBlank(), "URL cannot be blank");
	}

	@DisplayName("Should ensure that adultPrice currency and childPrice currency are the same")
	void shouldEnsureThatAdultPriceCurrencyAndChildPriceCurrencyAreTheSame(){
		assertEquals(offer.adultPrice().currency(), offer.childPrice().currency(), "AdultPrice currency and childPrice currency cannot be different");
	}		
}