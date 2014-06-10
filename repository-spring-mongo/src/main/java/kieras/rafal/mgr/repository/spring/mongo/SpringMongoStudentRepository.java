
package kieras.rafal.mgr.repository.spring.mongo;

import kieras.rafal.mgr.repository.spring.mongo.entity.SpringMongoStudent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpringMongoStudentRepository extends MongoRepository<SpringMongoStudent, Long> {
    
}
