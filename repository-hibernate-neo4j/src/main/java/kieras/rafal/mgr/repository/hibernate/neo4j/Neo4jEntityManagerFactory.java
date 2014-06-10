package kieras.rafal.mgr.repository.hibernate.neo4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Neo4jEntityManagerFactory {
    
    private final EntityManagerFactory emf;

    public Neo4jEntityManagerFactory() {
        emf = Persistence.createEntityManagerFactory("hibernate-neo4j-pu");
    }

    public EntityManager createEntityManager() {
        return emf.createEntityManager();
    }

    public void close() {
        if (emf.isOpen()) {
            emf.close();
        }
    }
}
