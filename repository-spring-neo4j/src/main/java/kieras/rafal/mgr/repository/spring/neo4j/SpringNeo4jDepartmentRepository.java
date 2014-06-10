package kieras.rafal.mgr.repository.spring.neo4j;

import kieras.rafal.mgr.repository.spring.neo4j.entity.SpringNeo4jDepartment;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface SpringNeo4jDepartmentRepository extends GraphRepository<SpringNeo4jDepartment> {
    
}
