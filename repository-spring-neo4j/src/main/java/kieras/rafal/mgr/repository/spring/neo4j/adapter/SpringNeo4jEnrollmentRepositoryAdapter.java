package kieras.rafal.mgr.repository.spring.neo4j.adapter;

import kieras.rafal.mgr.repository.EnrollmentRepository;
import kieras.rafal.mgr.repository.entity.Enrollment;
import kieras.rafal.mgr.repository.spring.neo4j.SpringNeo4jEnrollmentRepository;
import kieras.rafal.mgr.repository.spring.neo4j.entity.SpringNeo4jEnrollment;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class SpringNeo4jEnrollmentRepositoryAdapter  implements EnrollmentRepository {
    private static final ModelMapper mapper = new ModelMapper();

    @Autowired
    SpringNeo4jEnrollmentRepository enrollmentRepository;

    @Override
    public void add(Enrollment entity) {
        entity.setId(null);
        SpringNeo4jEnrollment saved = enrollmentRepository.save(mapper.map(entity, SpringNeo4jEnrollment.class));
        entity.setId(saved.getId());
    }

    @Override
    public Enrollment find(Long key) {
        SpringNeo4jEnrollment enrollment = enrollmentRepository.findOne(key);
        if(enrollment == null) return null;
        return mapper.map(enrollment, Enrollment.class);
    }

    @Override
    public void remove(Long key) {
        enrollmentRepository.delete(key);
    }

    @Override
    public void update(Enrollment entity) {
        enrollmentRepository.save(mapper.map(entity, SpringNeo4jEnrollment.class));
    }
}
