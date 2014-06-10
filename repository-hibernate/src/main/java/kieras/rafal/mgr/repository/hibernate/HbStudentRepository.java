package kieras.rafal.mgr.repository.hibernate;

import kieras.rafal.mgr.repository.StudentRepository;
import kieras.rafal.mgr.repository.entity.Office;
import kieras.rafal.mgr.repository.entity.Student;
import kieras.rafal.mgr.repository.hibernate.entity.HbOffice;
import kieras.rafal.mgr.repository.hibernate.entity.HbStudent;
import org.modelmapper.ModelMapper;

public abstract class HbStudentRepository  extends HbRepository<HbStudent, Long> implements StudentRepository  {
    private static ModelMapper mapper = new ModelMapper();
    
    public HbStudentRepository() {
        super(HbStudent.class);
    }

    @Override
    public void add(Student entity) {
        addEntity(mapper.map(entity, HbStudent.class));
    }

    @Override
    public Student find(Long key) {
        HbStudent entity = findEntity(key);
        if(entity == null) return null;
        return mapper.map(entity, Student.class);
    }

    @Override
    public void remove(Long key) {
        removeEntity(key);
    }

    @Override
    public void update(Student entity) {
        updateEntity(mapper.map(entity, HbStudent.class));
    }
}
