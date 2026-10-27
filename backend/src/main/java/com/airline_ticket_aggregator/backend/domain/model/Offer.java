package com.airline_ticket_aggregator.backend.domain.model;

import java.util.Objects;

public record Offer(String id, String flightId, String partner, Money adultPrice, Money childPrice, Boolean available, String url){
	public Offer{
		Objects.requireNonNull(id, "Offer ID cannot be null");
        Objects.requireNonNull(flightId, "Flight ID cannot be null");
        Objects.requireNonNull(partner, "Partner cannot be null");
        Objects.requireNonNull(adultPrice, "Adult price cannot be null");
        Objects.requireNonNull(childPrice, "Child price cannot be null");
        Objects.requireNonNull(url, "URL cannot be null");


		if (id.isBlank()) {
            throw new IllegalArgumentException("Offer ID cannot be blank");
        }
        if (flightId.isBlank()) {
            throw new IllegalArgumentException("Flight ID cannot be blank");
        }
        if (partner.isBlank()) {
            throw new IllegalArgumentException("Partner name cannot be blank");
        }
        if (url.isBlank()) {
            throw new IllegalArgumentException("URL cannot be blank");
        }

        if (!adultPrice.currency().equals(childPrice.currency())) {
            throw new IllegalArgumentException("Adult and child prices must use the same currency");
        }

	}
}