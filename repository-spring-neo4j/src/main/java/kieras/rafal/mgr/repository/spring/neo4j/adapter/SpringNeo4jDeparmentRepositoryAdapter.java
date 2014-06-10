package kieras.rafal.mgr.repository.spring.neo4j.adapter;

import kieras.rafal.mgr.repository.DepartmentRepository;
import kieras.rafal.mgr.repository.entity.Department;
import kieras.rafal.mgr.repository.spring.neo4j.SpringNeo4jDepartmentRepository;
import kieras.rafal.mgr.repository.spring.neo4j.entity.SpringNeo4jDepartment;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class SpringNeo4jDeparmentRepositoryAdapter  implements DepartmentRepository {
    private static final ModelMapper mapper = new ModelMapper();

    @Autowired
    SpringNeo4jDepartmentRepository departmentRepository;

    @Override
    public void add(Department entity) {
        entity.setId(null);
        SpringNeo4jDepartment saved = departmentRepository.save(mapper.map(entity, SpringNeo4jDepartment.class));
        entity.setId(saved.getId());
    }

    @Override
    public Department find(Long key) {
        SpringNeo4jDepartment deparment = departmentRepository.findOne(key);
        if(deparment == null) return null;
        return mapper.map(deparment, Department.class);
    }

    @Override
    public void remove(Long key) {
        departmentRepository.delete(key);
    }

    @Override
    public void update(Department entity) {
        departmentRepository.save(mapper.map(entity, SpringNeo4jDepartment.class));
    }
}
