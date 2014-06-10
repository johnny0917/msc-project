package kieras.rafal.mgr.repository.hibernate.postgresql.test.suite;

import kieras.rafal.mgr.repository.hibernate.postgresql.test.CrudTest;
import kieras.rafal.mgr.repository.hibernate.postgresql.test.RelationMappingTest;
import kieras.rafal.mgr.util.test.SpringContextHolder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@RunWith(Suite.class)
@SuiteClasses({ CrudTest.class, RelationMappingTest.class })
public class HibernateJpaTestSuite {
    
    @BeforeClass
    public static void before() {
        AnnotationConfigApplicationContext context = SpringContextHolder.getInstance();
        context.register(HibernateJpaConfig.class);
        context.refresh();
    }
    
    @AfterClass
    public static void after() {
        SpringContextHolder.getInstance().close();
    }
}
