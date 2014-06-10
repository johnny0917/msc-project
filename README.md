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

#### Domain model

There is one domain model for each datastore (MongoDB, Neo4j, PostgreSQL) and it is using JPA annotations, for example:

```java
@Entity
public class HbCourse {
    @Id
    private Long id;

    private String name;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<HbEnrollment> enrollments = new HashSet<>();

    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne
    private HbOffice office;
    
    @ManyToOne
    private HbInstructor instructor;

	... GETTERS AND SETTERS... 
}
```

Due to this we have domain model independent from database vendor.

#### Repositories
Hibernate OGM acts as a JPA implementation provider for NoSQL datastores. There is a base class called **HbRepository** which implements basic CRUD operations for an entity. It is using plain JPA and EntityManager interface to access datastore.

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

Then HbRepository is used in every particular repository implementation. Beacuse HbRepository is a generic class, we need to specify entity and primary key type.

```java
public abstract class HbCourseRepository  extends HbRepository<HbCourse, Long> implements CourseRepository  {
    private static ModelMapper mapper = new ModelMapper();
    
    public HbCourseRepository() {
        super(HbCourse.class);
    }

    @Override
    public void add(Course entity) {
        addEntity(mapper.map(entity, HbCourse.class));
    }

    @Override
    public Course find(Long key) {
        HbCourse entity = findEntity(key);
        if(entity == null) return null;
        return mapper.map(entity, Course.class);
    }

    @Override
    public void remove(Long key) {
        removeEntity(key);
    }

    @Override
    public void update(Course entity) {
        updateEntity(mapper.map(entity, HbCourse.class));
    }
}
```

There is a concrete implementation of repository for each database: Neo4j, MongoDB, PostgreSQL. They will contatin vendor specific code if needed.

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

```java
@Repository
public class HbPostgresqlCourseRepository extends HbCourseRepository  {
    
}
```

#### Queries

TODO: Fill in

### Sprng data mongodb

#### Domain model

We need to define domain model with spring mongodb annotations. For example:

```java
@Document
public class SpringMongoCourse {
    @Id
    private Long id;
    
    private String name;
    
    @Transient
    private Set<SpringMongoEnrollment> enrollments = new HashSet<>();
    
    @DBRef
    private SpringMongoOffice office;

    private Date date;
    
    @DBRef
    private SpringMongoInstructor instructor;
	
	... GETTERS AND SETTERS ...
}
```

#### Repositories

#### Queries

### Spring data neo4j

#### Domain model

We need to define domain model with spring neo4j annotations. For example:

```java
@NodeEntity
public class SpringNeo4jCourse {

    @GraphId
    private Long id;

    private String name;

    @RelatedToVia(type = "ENROLLMENT", direction = Direction.INCOMING)
    private Set<SpringNeo4jEnrollment> enrollments = new HashSet<>();

    @RelatedTo
    @Fetch
    private SpringNeo4jOffice office;

    private Date date;

    @RelatedTo
    @Fetch
    private SpringNeo4jInstructor instructor;
	
	... GETTERS AND SETTERS ...
}
```

#### Repositories

#### Queries

# Testing data access layer