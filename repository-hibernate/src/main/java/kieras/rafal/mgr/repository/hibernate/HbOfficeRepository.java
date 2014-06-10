package kieras.rafal.mgr.repository.hibernate;

import kieras.rafal.mgr.repository.OfficeRepository;
import kieras.rafal.mgr.repository.entity.Instructor;
import kieras.rafal.mgr.repository.entity.Office;
import kieras.rafal.mgr.repository.hibernate.entity.HbInstructor;
import kieras.rafal.mgr.repository.hibernate.entity.HbOffice;
import org.modelmapper.ModelMapper;

public abstract class HbOfficeRepository extends HbRepository<HbOffice, Long> implements OfficeRepository {

    private static ModelMapper mapper = new ModelMapper();

    public HbOfficeRepository() {
        super(HbOffice.class);
    }

    @Override
    public void add(Office entity) {
        addEntity(mapper.map(entity, HbOffice.class));
    }

    @Override
    public Office find(Long key) {
        HbOffice entity = findEntity(key);
        if(entity == null) return null;
        return mapper.map(entity, Office.class);
    }

    @Override
    public void remove(Long key) {
        removeEntity(key);
    }

    @Override
    public void update(Office entity) {
        updateEntity(mapper.map(entity, HbOffice.class));
    }
}
