package com.airline_ticket_aggregator.backend.domain.model;

import java.util.Objects;

public record Airport(String iata, String name, String city, String timezone){
	public Airport{
		Objects.requireNonNull(iata, "IATA code cannot be null");
        Objects.requireNonNull(name, "Airport name cannot be null");
        Objects.requireNonNull(city, "City cannot be null");
        Objects.requireNonNull(timezone, "Timezone cannot be null");

		if (iata.isBlank()) {
            throw new IllegalArgumentException("IATA code cannot be blank");
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException("Airport name cannot be blank");
        }
        if (city.isBlank()) {
            throw new IllegalArgumentException("City cannot be blank");
        }
        if (timezone.isBlank()) {
            throw new IllegalArgumentException("Timezone cannot be blank");
        }

        if (iata.trim().length() != 3) {
            throw new IllegalArgumentException("IATA code must be exactly 3 characters");
        }

        iata = iata.trim().toUpperCase();
	}
}