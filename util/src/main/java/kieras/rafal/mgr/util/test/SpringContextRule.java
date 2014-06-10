package kieras.rafal.mgr.util.test;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import org.springframework.context.ConfigurableApplicationContext;

public class SpringContextRule implements TestRule {

    private final Object target;

    public SpringContextRule(Object target) {
        this.target = target;
    }

    @Override
    public Statement apply(final Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                ((ConfigurableApplicationContext) SpringContextHolder.getInstance())
                        .getAutowireCapableBeanFactory().autowireBean(target);
                base.evaluate();
            }
        };
    }
}
