package com.airline_ticket_aggregator.backend.domain.model;

import java.time.OffsetDateTime;
import java.util.Objects;

public record Flight(String id, String airline, String flightNumber, String origin,String destination,
OffsetDateTime departureTime, OffsetDateTime arrivalTime, int stops, FlightStatus status){
	public Flight{
		Objects.requireNonNull(airline, "Arline cannot be null");
		Objects.requireNonNull(flightNumber, "Flight number cannot be null");
		Objects.requireNonNull(origin, "Origin cannot be null");
		Objects.requireNonNull(destination, "Destination cannot be null");
		Objects.requireNonNull(departureTime, "Departure Time cannot be null");
		Objects.requireNonNull(arrivalTime, "Arrival Time cannot be null");
		Objects.requireNonNull(stops, "Stops cannot be null");
		Objects.requireNonNull(status, "Status cannot be null");


		if (origin.trim().equalsIgnoreCase(destination.trim())) {
            throw new IllegalArgumentException("Origin and destination airports cannot be the same");
        }
        if (arrivalTime.isBefore(departureTime)) {
            throw new IllegalArgumentException("Arrival time cannot be before departure time");
        }
        if (stops < 0) {
            throw new IllegalArgumentException("Stops cannot be negative");
        }
        if (id.isBlank() || airline.isBlank() || flightNumber.isBlank()) {
            throw new IllegalArgumentException("Flight text fields cannot be blank");
        }

        origin = origin.trim().toUpperCase();
        destination = destination.trim().toUpperCase();

	}

}