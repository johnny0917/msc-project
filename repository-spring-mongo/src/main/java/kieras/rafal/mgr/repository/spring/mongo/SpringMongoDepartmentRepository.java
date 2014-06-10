
package kieras.rafal.mgr.repository.spring.mongo;

import kieras.rafal.mgr.repository.spring.mongo.entity.SpringMongoDepartment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpringMongoDepartmentRepository extends MongoRepository<SpringMongoDepartment, Long> {
    
}
