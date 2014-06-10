package kieras.rafal.mgr.repository.hibernate;

import kieras.rafal.mgr.repository.DepartmentRepository;
import kieras.rafal.mgr.repository.entity.Department;
import kieras.rafal.mgr.repository.hibernate.entity.HbDepartment;
import org.modelmapper.ModelMapper;

public abstract class HbDepartmentRepository extends HbRepository<HbDepartment, Long> implements DepartmentRepository {

    private static ModelMapper mapper = new ModelMapper();

    public HbDepartmentRepository() {
        super(HbDepartment.class);
    }

    @Override
    public void add(Department entity) {
        addEntity(mapper.map(entity, HbDepartment.class));
    }

    @Override
    public Department find(Long key) {
        HbDepartment entity = findEntity(key);
        if(entity == null) return null;
        return mapper.map(entity, Department.class);
    }

    @Override
    public void remove(Long key) {
        removeEntity(key);
    }

    @Override
    public void update(Department entity) {
        updateEntity(mapper.map(entity, HbDepartment.class));
    }
}
