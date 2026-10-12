# ADR 0001: Tech Stack Selection

## Status
Accepted

## Context
We need to build a robust, scalable, and maintainable Airline Ticket Aggregator. The system requires high performance for searching flights, resilience for handling third-party integration failures, and a smooth user experience.

## Decision
We chose a Monorepo architecture containing:
- **Backend:** Java 22 with Spring Boot 4.x and Maven.
- **Frontend:** React, TypeScript, and Vite.

## Alternatives Considered
- **Next.js (Fullstack):** Dismissed because complex flight data aggregation and third-party API processing benefit from Java's robust multi-threading and type safety.
- **Python (FastAPI):** Dismissed because Java's ecosystem offers better enterprise-grade tools for long-term scalability and framework stability.

## Consequences
- **Positive:** Clear separation of concerns, excellent performance for the backend, fast frontend build times with Vite, and strong type safety across both layers.
- **Negative:** Slightly higher initial boilerplate code and memory usage for the local development environment.
