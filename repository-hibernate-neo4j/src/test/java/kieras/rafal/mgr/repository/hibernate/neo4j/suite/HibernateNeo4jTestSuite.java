package kieras.rafal.mgr.repository.hibernate.neo4j.suite;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import kieras.rafal.mgr.repository.hibernate.neo4j.CrudTest;
import kieras.rafal.mgr.repository.hibernate.neo4j.RelationMappingTest;
import kieras.rafal.mgr.util.test.SpringContextHolder;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@RunWith(Suite.class)
@SuiteClasses({ CrudTest.class, RelationMappingTest.class })
public class HibernateNeo4jTestSuite {

    @BeforeClass
    public static void before() {
        AnnotationConfigApplicationContext context = SpringContextHolder.getInstance();
        context.register(HibernateNeo4jConfig.class);
        context.refresh();
    }

    @AfterClass
    public static void after(){
        try {
            SpringContextHolder.getInstance().close();
            Path dbRelativePath = Paths.get("target\\neo4j\\school_test");
            File dbDirectory = new File(dbRelativePath.toAbsolutePath().toString());
            FileUtils.deleteDirectory(dbDirectory);
        } catch (IOException ex) {
        }
    }
}
