package kieras.rafal.mgr.repository.spring.mongo.test.suite;

import com.mongodb.MongoClient;
import kieras.rafal.mgr.util.InMemoryPrimaryKeyGenerator;
import kieras.rafal.mgr.util.PrimaryKeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "kieras.rafal.mgr.repository.spring.mongo")
@ComponentScan(basePackages = "kieras.rafal.mgr.repository.spring.mongo")
public class SpringMongoConfig {

    public @Bean
    MongoDbFactory mongoDbFactory() throws Exception {
        return new SimpleMongoDbFactory(new MongoClient(), "school_spring_test");
    }

    public @Bean
    MongoTemplate mongoTemplate() throws Exception {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
        return mongoTemplate;
    }
    
    @Bean
    public PrimaryKeyGenerator primaryKeyGenerator() {
        return new InMemoryPrimaryKeyGenerator();
    }
}
