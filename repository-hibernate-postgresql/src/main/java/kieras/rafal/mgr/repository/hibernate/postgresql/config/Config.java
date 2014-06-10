package kieras.rafal.mgr.repository.hibernate.postgresql.config;

import javax.persistence.EntityManager;
import kieras.rafal.mgr.repository.hibernate.postgresql.PostgresqlEntityManagerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("kieras.rafal.mgr.repository.hibernate.postgresql")
public class Config {
    
    @Bean
    @Scope(BeanDefinition.SCOPE_SINGLETON)
    public PostgresqlEntityManagerFactory postgresqlEntityManagerFactory() {
        return new PostgresqlEntityManagerFactory();
    }
    
    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public EntityManager entityManager() {
        return postgresqlEntityManagerFactory().createEntityManager();
    }
    
}
