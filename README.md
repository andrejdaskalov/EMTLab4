# EMTLab4

# EMT Lab: DDD E-Shop for Car Parts

This repository contains a laboratory exercise for the subject "EMT". The goal of this exercise is to implement a core domain for an e-shop for buying car parts using Java Spring and Domain-Driven Design (DDD) principles.


The core domain follows the DDD principles of:

- Ubiquitous Language: using a common and consistent language to describe the domain concepts and rules.
- Bounded Context: defining the boundaries and responsibilities of the core domain and isolating it from other domains.
- Entities and Value Objects: modeling the domain concepts as either entities (with identity) or value objects (without identity).
- Aggregates and Aggregate Roots: grouping related entities and value objects into aggregates and defining an aggregate root as the main point of access for each aggregate.
- Services: encapsulating domain logic that does not belong to any entity or value object into services.
- Repositories: abstracting the persistence layer and providing access to aggregates.

To run this project, you need to have Java 19 and Maven. You also need to have PostgreSQL installed and create a database named "postgres". You can use the application.properties file to configure the database connection details.



