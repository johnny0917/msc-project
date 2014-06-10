package kieras.rafal.mgr.repository.spring.neo4j;

import kieras.rafal.mgr.repository.spring.neo4j.entity.SpringNeo4jOffice;
import kieras.rafal.mgr.repository.spring.neo4j.entity.SpringNeo4jStudent;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface SpringNeo4jStudentRepository extends GraphRepository<SpringNeo4jStudent> {
    
}
