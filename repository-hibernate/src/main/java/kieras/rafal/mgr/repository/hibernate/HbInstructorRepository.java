package kieras.rafal.mgr.repository.hibernate;

import kieras.rafal.mgr.repository.InstructorRepository;
import kieras.rafal.mgr.repository.entity.Enrollment;
import kieras.rafal.mgr.repository.entity.Instructor;
import kieras.rafal.mgr.repository.hibernate.entity.HbEnrollment;
import kieras.rafal.mgr.repository.hibernate.entity.HbInstructor;
import org.modelmapper.ModelMapper;

public abstract class HbInstructorRepository extends HbRepository<HbInstructor, Long> implements InstructorRepository {

    private static ModelMapper mapper = new ModelMapper();

    public HbInstructorRepository() {
        super(HbInstructor.class);
    }

    @Override
    public void add(Instructor entity) {
        addEntity(mapper.map(entity, HbInstructor.class));
    }

    @Override
    public Instructor find(Long key) {
        HbInstructor entity = findEntity(key);
        if(entity == null) return null;
        return mapper.map(entity, Instructor.class);
    }

    @Override
    public void remove(Long key) {
        removeEntity(key);
    }

    @Override
    public void update(Instructor entity) {
        updateEntity(mapper.map(entity, HbInstructor.class));
    }
}
