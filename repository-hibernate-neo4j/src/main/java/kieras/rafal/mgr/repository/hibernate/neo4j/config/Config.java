package kieras.rafal.mgr.repository.hibernate.neo4j.config;

import javax.persistence.EntityManager;
import kieras.rafal.mgr.repository.hibernate.neo4j.Neo4jEntityManagerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("kieras.rafal.mgr.repository.hibernate.neo4j")
public class Config {
    
    @Bean
    @Scope(BeanDefinition.SCOPE_SINGLETON)
    public Neo4jEntityManagerFactory neo4jEntityManagerFactory() {
        return new Neo4jEntityManagerFactory();
    }
    
    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public EntityManager entityManager() {
        return neo4jEntityManagerFactory().createEntityManager();
    }
    
}

