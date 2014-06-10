package kieras.rafal.mgr.util.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringContextHolder {
    private SpringContextHolder() { }
    
    private static class LazyHolder {
        private static final AnnotationConfigApplicationContext INSTANCE = new AnnotationConfigApplicationContext();
    }
 
    public static AnnotationConfigApplicationContext getInstance() {
        return LazyHolder.INSTANCE;
    }
}
