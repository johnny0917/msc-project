package kieras.rafal.mgr.repository.spring.mongo.adapter;

import java.util.Set;
import kieras.rafal.mgr.repository.StudentRepository;
import kieras.rafal.mgr.repository.entity.Student;
import kieras.rafal.mgr.repository.spring.mongo.SpringMongoEnrollmentRepository;
import kieras.rafal.mgr.repository.spring.mongo.SpringMongoStudentRepository;
import kieras.rafal.mgr.repository.spring.mongo.entity.SpringMongoEnrollment;
import kieras.rafal.mgr.repository.spring.mongo.entity.SpringMongoStudent;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SpringMongoStudentRepositoryAdapter implements StudentRepository {
    private static final ModelMapper mapper = new ModelMapper();

    @Autowired
    SpringMongoStudentRepository studentRepository;
    
    @Autowired
    SpringMongoEnrollmentRepository enrollmentRepository;

    @Override
    public void add(Student entity) {
        studentRepository.save(mapper.map(entity, SpringMongoStudent.class));
    }

    @Override
    public Student find(Long key) {
        SpringMongoStudent springStudent = studentRepository.findOne(key);
        if(springStudent == null) return null;
        Set<SpringMongoEnrollment> enrollments = enrollmentRepository.findByStudent(springStudent);
        springStudent.setEnrollments(enrollments);
        return mapper.map(springStudent, Student.class);
    }

    @Override
    public void remove(Long key) {
        studentRepository.delete(key);
    }

    @Override
    public void update(Student entity) {
        studentRepository.save(mapper.map(entity, SpringMongoStudent.class));
    }
}
