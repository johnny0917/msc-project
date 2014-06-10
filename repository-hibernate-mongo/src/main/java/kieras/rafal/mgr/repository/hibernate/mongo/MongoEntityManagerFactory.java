package kieras.rafal.mgr.repository.hibernate.mongo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MongoEntityManagerFactory {

    private final EntityManagerFactory emf;

    public MongoEntityManagerFactory() {
        emf = Persistence.createEntityManagerFactory("hibernate-mongo-pu");
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
