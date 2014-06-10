package kieras.rafal.mgr.repository.spring.mongo.adapter;

import kieras.rafal.mgr.repository.EnrollmentRepository;
import kieras.rafal.mgr.repository.entity.Enrollment;
import kieras.rafal.mgr.repository.spring.mongo.SpringMongoEnrollmentRepository;
import kieras.rafal.mgr.repository.spring.mongo.entity.SpringMongoEnrollment;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SpringMongoEnrollmentRepositoryAdapter implements EnrollmentRepository {
    private static final ModelMapper mapper = new ModelMapper();

    @Autowired
    SpringMongoEnrollmentRepository enrollmentRepository;

    @Override
    public void add(Enrollment entity) {
        enrollmentRepository.save(mapper.map(entity, SpringMongoEnrollment.class));
    }

    @Override
    public Enrollment find(Long key) {
        SpringMongoEnrollment enrollment = enrollmentRepository.findOne(key);
        if(enrollment == null) return null;
        return mapper.map(enrollment, Enrollment.class);
    }

    @Override
    public void remove(Long key) {
        enrollmentRepository.delete(key);
    }

    @Override
    public void update(Enrollment entity) {
        enrollmentRepository.save(mapper.map(entity, SpringMongoEnrollment.class));
    }
}
