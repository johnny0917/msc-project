package kieras.rafal.mgr.repository.spring.neo4j.test.suite;


import kieras.rafal.mgr.util.InMemoryPrimaryKeyGenerator;
import kieras.rafal.mgr.util.PrimaryKeyGenerator;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableNeo4jRepositories("kieras.rafal.mgr.repository.spring.neo4j")
@ComponentScan(basePackages = "kieras.rafal.mgr.repository.spring.neo4j")
public class SpringNeo4jConfig extends Neo4jConfiguration   {
    private static final String DB_PATH = "target/school_spring_test.db";
    
    @Bean(destroyMethod = "shutdown")
    public GraphDatabaseService graphDatabaseService() {
        return new GraphDatabaseFactory().newEmbeddedDatabase( DB_PATH );
    }
    
    @Bean
    public PrimaryKeyGenerator primaryKeyGenerator() {
        return new InMemoryPrimaryKeyGenerator();
    }
}
