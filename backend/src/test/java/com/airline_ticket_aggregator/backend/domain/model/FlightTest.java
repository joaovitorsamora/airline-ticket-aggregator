package com.airline_ticket_aggregator.backend.domain.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class FlightTest {
	private Flight flight;

	@BeforeEach
	void setUp(){
		OffsetDateTime departureTime = OffsetDateTime.of(2026, 10, 19, 12, 0, 0, 0, ZoneOffset.UTC);
		OffsetDateTime arrivalTime = OffsetDateTime.of(2026, 10, 23, 12, 0, 0, 0, ZoneOffset.UTC);

		FlightStatus status = FlightStatus.SCHEDULED;	

		flight = new Flight("002dhhd", "Fake airline", "6645", "Fake origin", "Fake destination", departureTime, arrivalTime, 0, status);
	}


	@Test
	@DisplayName("Should ensure all domain model fields are not null")
	void shouldEnsureAllDomainModelFieldsAreNotNull(){
		assertNotNull(flight.airline());
		assertNotNull(flight.flightNumber());
		assertNotNull(flight.origin());
		assertNotNull(flight.destination());
		assertNotNull(flight.departureTime());
		assertNotNull(flight.arrivalTime());
		assertNotNull(flight.stops());
		assertNotNull(flight.status());	
	}

	@DisplayName("Should ensure origin and destination airports are not the same")
	void shouldEnsureOriginAndDestinationAirportsAreNotTheSame(){
		assertEquals(flight.origin().trim(), flight.destination().trim(), "Origin and Destination airports cannot be the same");

	}

	@DisplayName("Should ensure arrival time is not before departure time")
	void shouldEnsureArrivalTimeIsBeforeDepartureTime(){
		assertTrue(flight.arrivalTime().isBefore(flight.departureTime()), "Arrival time cannot be before departure time");;
	}

	@DisplayName("Should ensure stops are not negative")
	void shouldEnsureStopsAreNotNegative(){
		assertTrue(flight.stops() < 0, "Stops cannot be negative");
	}

	@DisplayName("Should ensure flight text fields are not blank")
	void shouldEnsureFlightTextFieldsAreNotBlank(){
		assertTrue(flight.id().isBlank(), "ID cannot be blank");
		assertTrue(flight.airline().isBlank(), "Airline cannot be blank");
		assertTrue(flight.flightNumber().isBlank(), "Flight number cannot be blank");
	}

	@DisplayName("Should ensure origin and destination airports are not in lowercase")
	void shouldEnsureOriginAndDestinationAirportsAreNotInLowercase(){
		assertFalse(flight.id().isBlank(), "ID cannot be blank");
		assertFalse(flight.airline().isBlank(), "Airline cannot be blank");
		assertFalse(flight.flightNumber().isBlank(), "Flight number cannot be blank");
		assertTrue(flight.origin().contains(flight.origin().trim().toUpperCase()), "Origin must be uppercase");
		assertTrue(flight.destination().contains(flight.destination().trim().toUpperCase()), "Destination must be uppercase");

	}
}