package kieras.rafal.mgr.repository.hibernate.neo4j.suite;

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
@ComponentScan("kieras.rafal.mgr.repository.hibernate.neo4j")
public class HibernateNeo4jConfig {

    @Bean
    @Scope(BeanDefinition.SCOPE_SINGLETON)
    public EntityManagerFactory neo4jEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("hibernate-neo4j-test-pu");
    }

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public EntityManager entityManager() {
        return neo4jEntityManagerFactory().createEntityManager();
    }

    @Bean
    public PrimaryKeyGenerator primaryKeyGenerator() {
        return new InMemoryPrimaryKeyGenerator();
    }
}
