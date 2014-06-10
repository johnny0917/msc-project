package kieras.rafal.mgr.repository.spring.mongo.test.suite;

import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import kieras.rafal.mgr.repository.spring.mongo.test.CrudTest;
import kieras.rafal.mgr.util.test.SpringContextHolder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@RunWith(Suite.class)
@SuiteClasses({ CrudTest.class })
public class SpringMongoTestSuite {

    @BeforeClass
    public static void before() {
        AnnotationConfigApplicationContext context = SpringContextHolder.getInstance();
        context.register(SpringMongoConfig.class);
        context.refresh();
    }

    @AfterClass
    public static void after() {
        AnnotationConfigApplicationContext context = SpringContextHolder.getInstance();
        context.close();
        deleteDatabase();
    }

    private static void deleteDatabase() {
        MongoClient mongoClient;
        try {
            mongoClient = new MongoClient();
            mongoClient.getDB("school_spring_test").dropDatabase();
        } catch (UnknownHostException ex) {
        }
    }
}
