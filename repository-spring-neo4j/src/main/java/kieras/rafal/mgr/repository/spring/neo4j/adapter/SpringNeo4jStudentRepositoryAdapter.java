package kieras.rafal.mgr.repository.spring.neo4j.adapter;

import kieras.rafal.mgr.repository.StudentRepository;
import kieras.rafal.mgr.repository.entity.Student;
import kieras.rafal.mgr.repository.spring.neo4j.SpringNeo4jStudentRepository;
import kieras.rafal.mgr.repository.spring.neo4j.entity.SpringNeo4jStudent;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class SpringNeo4jStudentRepositoryAdapter  implements StudentRepository {
    private static final ModelMapper mapper = new ModelMapper();

    @Autowired
    SpringNeo4jStudentRepository studentRepository;

    @Override
    public void add(Student entity) {
        entity.setId(null);
        SpringNeo4jStudent saved = studentRepository.save(mapper.map(entity, SpringNeo4jStudent.class));
        entity.setId(saved.getId());
    }

    @Override
    public Student find(Long key) {
        SpringNeo4jStudent student = studentRepository.findOne(key);
        if(student == null) return null;
        return mapper.map(student, Student.class);
    }

    @Override
    public void remove(Long key) {
        studentRepository.delete(key);
    }

    @Override
    public void update(Student entity) {
        studentRepository.save(mapper.map(entity, SpringNeo4jStudent.class));
    }
}
