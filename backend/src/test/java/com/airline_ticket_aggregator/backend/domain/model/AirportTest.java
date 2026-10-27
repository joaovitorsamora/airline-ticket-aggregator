package com.airline_ticket_aggregator.backend.domain.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



class AirportTest {
	private Airport airport;

	@BeforeEach
	void setUp(){
		airport = new Airport("AC2", "Fake airport name", "Fake airport city", "2026-10-19T15:30:00-03:00");
	}

	@Test
	@DisplayName("Should check if name, city, timezone are not blank and if IATA has exactly 3 characters")
	void shouldCheckIfTheFieldsAreCorrect(){
		assertFalse(airport.name().isBlank(), "Airport name cannot be blank");
		assertFalse(airport.city().isBlank(), "City cannot be blank");
		assertFalse(airport.timezone().isBlank(), "Timezone cannot be blank");
		
		assertEquals(3, airport.iata().trim().length(), "IATA code must be exactly 3 characters");
		
		String iataOriginal = airport.iata().trim();
    	
    	assertTrue(iataOriginal.equals(iataOriginal.toUpperCase()), "IATA code must be uppercase");
	}

}