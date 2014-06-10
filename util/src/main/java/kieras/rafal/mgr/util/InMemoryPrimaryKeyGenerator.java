package kieras.rafal.mgr.util;

import java.util.concurrent.atomic.AtomicLong;

public class InMemoryPrimaryKeyGenerator implements PrimaryKeyGenerator {
    AtomicLong atomicLong = new AtomicLong(0);
    
    @Override
    public Long generateId() {
        return atomicLong.incrementAndGet();
    }

}
