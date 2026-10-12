# ADR 0002: Core Domain Decisions

## Status
Accepted

## Context
To prevent premature complexity while ensuring system reliability, we need to establish initial boundaries for data modeling, mocking strategy, and communication patterns.

## Decision
We adopted the following initial domain principles:
1. **Mock-First Strategy:** All flight aggregations will initially use reliable local mock data before connecting to real airline APIs.
2. **Stateless Aggregation:** The search engine will not persist external flight results in a database during the initial phases to ensure speed.
3. **Synchronous REST Communication:** The initial communication between Frontend and Backend will be strictly synchronous over HTTP/REST.

## Alternatives Considered
- **Database Caching:** Storing flight results immediately. Dismissed due to data stale-rate and complexity in cache invalidation for real-time prices.
- **Asynchronous/WebSockets:** Dismissed to keep the initial MVP architecture simple and easier to debug.

## Consequences
- **Positive:** Extremely fast development cycle, predictable responses, and no external database dependencies for the core MVP engine.
- **Negative:** Frontend must wait for the complete backend aggregation response time during REST calls.
