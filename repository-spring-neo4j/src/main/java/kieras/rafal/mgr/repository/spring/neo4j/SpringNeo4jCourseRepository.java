package kieras.rafal.mgr.repository.spring.neo4j;

import kieras.rafal.mgr.repository.spring.neo4j.entity.SpringNeo4jCourse;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface SpringNeo4jCourseRepository extends GraphRepository<SpringNeo4jCourse> {
    
}
