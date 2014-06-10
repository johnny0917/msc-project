package kieras.rafal.mgr.repository.hibernate.mongo.test.suite;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import kieras.rafal.mgr.util.InMemoryPrimaryKeyGenerator;
import kieras.rafal.mgr.util.PrimaryKeyGenerator;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("kieras.rafal.mgr.repository.hibernate.mongo")
public class HibernateMongoConfig {
    
    @Bean
    @Scope(BeanDefinition.SCOPE_SINGLETON)
    public EntityManagerFactory postgresqlEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("hibernate-mongo-test-pu");
    }
    
    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public EntityManager entityManager() {
        return postgresqlEntityManagerFactory().createEntityManager();
    }
    
    @Bean
    public PrimaryKeyGenerator primaryKeyGenerator() {
        return new InMemoryPrimaryKeyGenerator();
    }
}
