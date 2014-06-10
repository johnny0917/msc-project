package kieras.rafal.mgr.repository.spring.neo4j.test.suite;


import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import kieras.rafal.mgr.repository.spring.neo4j.test.CrudTest;
import kieras.rafal.mgr.repository.spring.neo4j.test.RelationMappingTest;
import kieras.rafal.mgr.util.test.SpringContextHolder;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@RunWith(Suite.class)
@SuiteClasses({CrudTest.class, RelationMappingTest.class })
public class SpringNeo4jTestSuite {

    @BeforeClass
    public static void before() {
        AnnotationConfigApplicationContext context = SpringContextHolder.getInstance();
        context.register(SpringNeo4jConfig.class);
        context.refresh();
    }

    @AfterClass
    public static void after() {
        AnnotationConfigApplicationContext context = SpringContextHolder.getInstance();
        context.close();
        deleteDatabase();
    }

    private static void deleteDatabase() {
        try {
            SpringContextHolder.getInstance().close();
            Path dbRelativePath = Paths.get("target\\school_spring_test.db");
            File dbDirectory = new File(dbRelativePath.toAbsolutePath().toString());
            FileUtils.deleteDirectory(dbDirectory);
        } catch (IOException ex) {
        }
    }
}
