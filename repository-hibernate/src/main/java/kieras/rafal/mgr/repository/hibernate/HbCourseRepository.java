package kieras.rafal.mgr.repository.hibernate;

import kieras.rafal.mgr.repository.CourseRepository;
import kieras.rafal.mgr.repository.entity.Course;
import kieras.rafal.mgr.repository.hibernate.entity.HbCourse;
import org.modelmapper.ModelMapper;

public abstract class HbCourseRepository  extends HbRepository<HbCourse, Long> implements CourseRepository  {
    private static ModelMapper mapper = new ModelMapper();
    
    public HbCourseRepository() {
        super(HbCourse.class);
    }

    @Override
    public void add(Course entity) {
        addEntity(mapper.map(entity, HbCourse.class));
    }

    @Override
    public Course find(Long key) {
        HbCourse entity = findEntity(key);
        if(entity == null) return null;
        return mapper.map(entity, Course.class);
    }

    @Override
    public void remove(Long key) {
        removeEntity(key);
    }

    @Override
    public void update(Course entity) {
        updateEntity(mapper.map(entity, HbCourse.class));
    }
}
