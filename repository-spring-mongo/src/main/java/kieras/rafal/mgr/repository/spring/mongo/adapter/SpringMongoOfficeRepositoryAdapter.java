package kieras.rafal.mgr.repository.spring.mongo.adapter;

import java.util.Set;
import kieras.rafal.mgr.repository.OfficeRepository;
import kieras.rafal.mgr.repository.entity.Office;
import kieras.rafal.mgr.repository.spring.mongo.SpringMongoCourseRepository;
import kieras.rafal.mgr.repository.spring.mongo.SpringMongoOfficeRepository;
import kieras.rafal.mgr.repository.spring.mongo.entity.SpringMongoCourse;
import kieras.rafal.mgr.repository.spring.mongo.entity.SpringMongoOffice;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SpringMongoOfficeRepositoryAdapter implements OfficeRepository {
    private static final ModelMapper mapper = new ModelMapper();

    @Autowired
    SpringMongoOfficeRepository officeRepository;
    
    @Autowired
    SpringMongoCourseRepository courseRepository;

    @Override
    public void add(Office entity) {
        officeRepository.save(mapper.map(entity, SpringMongoOffice.class));
    }

    @Override
    public Office find(Long key) {
        SpringMongoOffice office = officeRepository.findOne(key);
        if(office == null) return null;
        Set<SpringMongoCourse> courses = courseRepository.findByOffice(office);
        office.setCourses(courses);
        return mapper.map(office, Office.class);
    }

    @Override
    public void remove(Long key) {
        officeRepository.delete(key);
    }

    @Override
    public void update(Office entity) {
        officeRepository.save(mapper.map(entity, SpringMongoOffice.class));
    }
}
