package kieras.rafal.mgr.repository.hibernate.postgresql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PostgresqlEntityManagerFactory {
    private final EntityManagerFactory emf;
    
    public PostgresqlEntityManagerFactory() {
        emf = Persistence.createEntityManagerFactory("hibernate-postgresql-pu");
    }
    
    public EntityManager createEntityManager() {
        return emf.createEntityManager();
    }
    
    public void close() {
        if(emf.isOpen())
            emf.close();
    }
}
