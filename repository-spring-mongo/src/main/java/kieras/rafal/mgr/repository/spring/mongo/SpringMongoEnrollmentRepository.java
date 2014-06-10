
package kieras.rafal.mgr.repository.spring.mongo;

import java.util.Set;
import kieras.rafal.mgr.repository.spring.mongo.entity.SpringMongoCourse;
import kieras.rafal.mgr.repository.spring.mongo.entity.SpringMongoEnrollment;
import kieras.rafal.mgr.repository.spring.mongo.entity.SpringMongoStudent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpringMongoEnrollmentRepository extends MongoRepository<SpringMongoEnrollment, Long> {
    public Set<SpringMongoEnrollment> findByStudent(SpringMongoStudent student);
    public Set<SpringMongoEnrollment> findByCourse(SpringMongoCourse course);
}
