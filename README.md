Data access layer to NoSQL solution with Hibernate OGM and Spring Data
===========

# Description 

This repository contains the project which is trying to model data access layer to the following business model:

![Alt text](/README/image/entities.jpg?raw=true "Business model")

The solution is using different databases, SQL and NoSQL as well. The main purpose is to show how to model different relations between entities and query different datastores with Hibernate OGM and Spring Data frameworks.

# Repository pattern

In order to separate the logic that retrieves the data and maps it to the entity model from the business logic that acts on the model the repository pattern is used. The business logic should be agnostic to the type of data that comprises the data source layer.

![Alt text](/README/image/repository-pattern.png?raw=true "Repository pattern")

# Business and Domain model

## Java classes comparision

![Alt text](/README/image/business-to-domain-model.png?raw=true "Repository pattern")

## Mapping

The mapping from business model to domain model and vice versa is performed by [modelmapper](http://modelmapper.org/). It is a ligthweight java library which automatically determining how one object model maps to another.

```java 
ModelMapper mapper = new ModelMapper();
Course businessObject = getCourse();
SpringMongoCourse domainObject = mapper.map(course, SpringMongoCourse.class));
```

# Repositories definitions

## Abstract

There are six main abstract repositories defined as a Java interfaces:

![Alt text](/README/image/repository.png?raw=true "Repository pattern")

## Implementations

### General overview

![Alt text](/README/image/repository-implementation.png?raw=true "Repository pattern")

### Hibernate OGM

Hibernate OGM acts as a JPA implementation provider for NoSQL datastores. There is a base class called **HbRepository** which implements basic CRUD operations for an entity.

```java
public abstract class HbRepository<E, K>  {
    private final Class<E> entityClass;
    
    @Autowired
    private EntityManager entityManager;
    
    public HbRepository(Class<E> entityClass) {
        this.entityClass = entityClass;
    }
    
    protected void addEntity(E entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        entityManager.clear();
    }
    
    protected E findEntity(K id) {
        entityManager.getTransaction().begin();
        E entity = entityManager.find(entityClass, id);
        entityManager.getTransaction().commit();
        entityManager.clear();
        return entity;
    }
    
    protected void removeEntity(K id) {
        entityManager.getTransaction().begin();
        E entity = entityManager.find(entityClass, id);
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
        entityManager.clear();
    }
    
    protected void updateEntity(E entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
        entityManager.clear();
    }
    
    protected void close() {
        if (entityManager.isOpen()) {
            entityManager.close();
        }
    }
}
```

Every particular repository is inheriting from HbRepository:

```java
@Repository
public class HbNeo4jCourseRepository extends HbCourseRepository {

}
```

```java
@Repository
public class HbMongoCourseRepository extends HbCourseRepository {

}
```