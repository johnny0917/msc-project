package kieras.rafal.mgr.repository.hibernate;

import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;

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
