Data access layer to NoSQL solution with Hibernate OGM and Spring Data
===========

# Description 

This repository contains the project which is trying to model data access layer to the following business model:

![Alt text](/README/image/entities.jpg?raw=true "Business model")

The solution is using different databases, SQL and NoSQL as well. The main purpose is to show how to model different relations between entities and query different datastores with Hibernate OGM and Spring Data frameworks.

# Repository pattern

In order to separate the logic that retrieves the data and maps it to the entity model from the business logic that acts on the model the repository pattern is used. The business logic should be agnostic to the type of data that comprises the data source layer.

![Alt text](/README/image/repository-pattern.png?raw=true "Repository pattern")