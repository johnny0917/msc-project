package kieras.rafal.mgr.repository.hibernate.mongo.config;

import javax.persistence.EntityManager;
import kieras.rafal.mgr.repository.hibernate.mongo.MongoEntityManagerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("kieras.rafal.mgr.repository.hibernate.mongo")
public class Config {
    
    @Bean
    @Scope(BeanDefinition.SCOPE_SINGLETON)
    public MongoEntityManagerFactory mongoEntityManagerFactory() {
        return new MongoEntityManagerFactory();
    }
    
    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public EntityManager entityManager() {
        return mongoEntityManagerFactory().createEntityManager();
    }
    
}