
package kieras.rafal.mgr.repository.spring.mongo;

import java.util.Set;
import kieras.rafal.mgr.repository.spring.mongo.entity.SpringMongoCourse;
import kieras.rafal.mgr.repository.spring.mongo.entity.SpringMongoInstructor;
import kieras.rafal.mgr.repository.spring.mongo.entity.SpringMongoOffice;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpringMongoCourseRepository extends MongoRepository<SpringMongoCourse, Long> {
    public Set<SpringMongoCourse> findByInstructor(SpringMongoInstructor instructor);
    public Set<SpringMongoCourse> findByOffice(SpringMongoOffice office);
}
