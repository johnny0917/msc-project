package kieras.rafal.mgr.repository.hibernate;

import kieras.rafal.mgr.repository.EnrollmentRepository;
import kieras.rafal.mgr.repository.entity.Department;
import kieras.rafal.mgr.repository.entity.Enrollment;
import kieras.rafal.mgr.repository.hibernate.entity.HbDepartment;
import kieras.rafal.mgr.repository.hibernate.entity.HbEnrollment;
import org.modelmapper.ModelMapper;

public abstract class HbEnrollmentRepository extends HbRepository<HbEnrollment, Long> implements EnrollmentRepository {

    private static ModelMapper mapper = new ModelMapper();

    public HbEnrollmentRepository() {
        super(HbEnrollment.class);
    }

    @Override
    public void add(Enrollment entity) {
        addEntity(mapper.map(entity, HbEnrollment.class));
    }

    @Override
    public Enrollment find(Long key) {
        HbEnrollment entity = findEntity(key);
        if(entity == null) return null;
        return mapper.map(entity, Enrollment.class);
    }

    @Override
    public void remove(Long key) {
        removeEntity(key);
    }

    @Override
    public void update(Enrollment entity) {
        updateEntity(mapper.map(entity, HbEnrollment.class));
    }
}
