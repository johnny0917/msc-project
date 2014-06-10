
package kieras.rafal.mgr.repository.spring.mongo;

import kieras.rafal.mgr.repository.spring.mongo.entity.SpringMongoOffice;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpringMongoOfficeRepository extends MongoRepository<SpringMongoOffice, Long> {
    
}
