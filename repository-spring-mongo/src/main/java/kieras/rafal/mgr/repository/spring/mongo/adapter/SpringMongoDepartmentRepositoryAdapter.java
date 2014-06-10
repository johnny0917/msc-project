package kieras.rafal.mgr.repository.spring.mongo.adapter;

import kieras.rafal.mgr.repository.DepartmentRepository;
import kieras.rafal.mgr.repository.entity.Department;
import kieras.rafal.mgr.repository.spring.mongo.SpringMongoDepartmentRepository;
import kieras.rafal.mgr.repository.spring.mongo.entity.SpringMongoDepartment;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SpringMongoDepartmentRepositoryAdapter implements DepartmentRepository {
    private static final ModelMapper mapper = new ModelMapper();

    @Autowired
    SpringMongoDepartmentRepository departmentRepository;

    @Override
    public void add(Department entity) {
        departmentRepository.save(mapper.map(entity, SpringMongoDepartment.class));
    }

    @Override
    public Department find(Long key) {
        SpringMongoDepartment department = departmentRepository.findOne(key);
        if(department == null) return null;
        return mapper.map(department, Department.class);
    }

    @Override
    public void remove(Long key) {
        departmentRepository.delete(key);
    }

    @Override
    public void update(Department entity) {
        departmentRepository.save(mapper.map(entity, SpringMongoDepartment.class));
    }
}
