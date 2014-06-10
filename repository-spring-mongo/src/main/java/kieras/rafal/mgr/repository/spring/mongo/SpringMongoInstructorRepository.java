
package kieras.rafal.mgr.repository.spring.mongo;

import kieras.rafal.mgr.repository.spring.mongo.entity.SpringMongoInstructor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpringMongoInstructorRepository extends MongoRepository<SpringMongoInstructor, Long> {
    
}
